package org.sess.services;

import java.util.ArrayList;
import java.util.List;

import org.sess.dto.DtoAlumnoCurso;
import org.sess.dto.DtoAlumnoGenero;
import org.sess.models.Alumno;
import org.sess.models.Curso;
import org.sess.repository.AlumnoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class AlumnoService {

    @Inject
    private AlumnoRepository alumnoRepository;
    @Inject
    private CursoService cursoService;

    public List<Alumno> listar() {
        return alumnoRepository.listAll();
    }

    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    @Transactional
    public Alumno nuevo(Alumno alumno) {
        Alumno entity = new Alumno();
        entity.setNombre(alumno.getNombre());
        entity.setEdad(alumno.getEdad());
        entity.setGenero(alumno.getGenero());
        entity.setCurso(alumno.getCurso());
        alumnoRepository.persist(entity);
        return entity;
    }

    @Transactional
    public Alumno modificar(Long id, Alumno alumno) {
        Alumno entity = alumnoRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Alumno id " + id + " no existe.", 404);
        }
        System.out.println("entity id: " + entity.getId());
        entity.setNombre(alumno.getNombre());
        entity.setEdad(alumno.getEdad());
        entity.setCurso(alumno.getCurso());
        entity.setGenero(alumno.getGenero());
        alumnoRepository.persist(entity);
        return entity;
    }

    public boolean eliminar(Long id) {
        Alumno entity = alumnoRepository.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Alumno id " + id + " no existe.", 404);
        }
        System.out.println("entity id: " + entity.getId());
        alumnoRepository.delete(entity);
        return true;
    }

    public Long totalAlumno() {
        return alumnoRepository.count();
    }

    public List<DtoAlumnoGenero> totalAlumnoGenero() {
        return alumnoRepository.countByGenero();
    }

    public List<DtoAlumnoCurso> alumnosPorCursoGenero() {
        List<DtoAlumnoCurso> list = new ArrayList<>();
        List<Curso> cursos = cursoService.listar();
        List<String> listGenero = alumnoRepository.listGenero();

        for (Curso curso : cursos) {
            for (String genero : listGenero) {
                DtoAlumnoCurso dto = new DtoAlumnoCurso();
                dto.setCurso(curso.getNombre());
                dto.setTotal(alumnoRepository.countByGenero(genero, curso.getId()));
                dto.setGenero(genero);
                list.add(dto);
            }
        }
        return list;
    }

    public Double promedioAlumnoGenero() {
        List<String> listGenero = alumnoRepository.listGenero();
        Long total = alumnoRepository.count();
        Double promedio = total.doubleValue() / listGenero.size();
        return promedio;
    }

    public Double promedioAlumnoCurso() {
        Long total = alumnoRepository.count();
        Long totalCurso = cursoService.totalCurso();
        Double promedio = total.doubleValue() / totalCurso;
        return promedio;
    }
}
