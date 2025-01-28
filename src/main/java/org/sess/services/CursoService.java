package org.sess.services;

import java.util.ArrayList;
import java.util.List;

import org.sess.dto.DtoCapacidadCurso;
import org.sess.dto.DtoCurso;
import org.sess.dto.DtoPromedioCurso;
import org.sess.models.Curso;
import org.sess.repository.AlumnoRepository;
import org.sess.repository.CursoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class CursoService {

    @Inject
    private CursoRepository cursoRepository;
    @Inject
    private AlumnoRepository alumnoRepository;

    public List<Curso> listar() {
        List<Curso> lista = cursoRepository.listAll();
        for (Curso curso : lista) {
            curso.setTotalAlumnos(alumnoRepository.countByCurso(curso.getId()).intValue());
        }
        return lista;
    }

    public Curso buscarPorId(Long id) {
        Long total = alumnoRepository.countByCurso(id);
        Curso curso = cursoRepository.findById(id);
        curso.setTotalAlumnos(total.intValue());
        return curso;
    }

    public Curso buscarPorNombre(String nombre) {
        return cursoRepository.findByNombre(nombre)
                .orElseThrow(() -> new WebApplicationException("Curso " + nombre + " no existe.", 404));
    }

    @Transactional
    public Curso nuevo(DtoCurso curso) {
        Curso entity = new Curso();
        entity.setNombre(curso.getNombre());
        entity.setCupo_maximo(curso.getCupo_maximo());
        cursoRepository.persist(entity);
        return entity;
    }

    @Transactional
    public Curso modificar(Long id, DtoCurso curso) {
        Curso entity = cursoRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Curso id " + id + " no existe.", 404);
        }
        System.out.println("entity id: " + entity.getId());
        entity.setNombre(curso.getNombre());
        entity.setCupo_maximo(curso.getCupo_maximo());
        cursoRepository.persist(entity);
        return entity;
    }

    @Transactional
    public boolean eliminar(Long id) {
        Curso entity = cursoRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Curso id " + id + " no existe.", 404);
        }
        System.out.println("entity id: " + entity.getId());
        cursoRepository.delete(entity);
        return true;
    }

    public Long totalCurso() {
        return cursoRepository.count();
    }

    public Long totalAlumnos(Long id) {
        return cursoRepository.countAlumnos(id);
    }

    public List<DtoCapacidadCurso> capacidadCurso() {
        List<Curso> listaCursos = this.listar();
        List<DtoCapacidadCurso> list = new ArrayList<>();
        for (Curso curso : listaCursos) {
            DtoCapacidadCurso dto = new DtoCapacidadCurso();
            dto.setCurso(curso.getNombre());
            dto.setMaximaCapacidad(curso.getCupo_maximo());
            Double porcentaje = (curso.getTotalAlumnos() * 100.0) / curso.getCupo_maximo();
            dto.setPorcentajeDisponible(100 - porcentaje);
            list.add(dto);
        }
        return list;
    }

    public List<DtoPromedioCurso> capacidadCursoOcupado() {
        List<Curso> listaCursos = this.listar();
        List<DtoPromedioCurso> list = new ArrayList<>();
        for (Curso curso : listaCursos) {
            DtoPromedioCurso dto = new DtoPromedioCurso();
            dto.setCurso(curso.getNombre());
            dto.setMaximaCapacidad(curso.getCupo_maximo());
            Double promedio = curso.getCupo_maximo() / (curso.getTotalAlumnos() * 1.00);
            dto.setPromedio(promedio);
            list.add(dto);
        }
        return list;
    }
}
