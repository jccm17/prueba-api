package org.sess.repository;

import java.util.ArrayList;
import java.util.List;

import org.sess.dto.DtoAlumnoGenero;
import org.sess.models.Alumno;
import org.sess.models.Curso;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepository<Alumno> {

    private final EntityManager entityManager;

    public AlumnoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Alumno> findByCurso(Curso curso) {
        return list("curso", curso);
    }

    public Long countByCurso(Long id) {
        return count("curso.id", id);
    }

    public Long countByGenero(String genero) {
        return count("genero", genero);
    }

    public Long countByGenero(String genero, Long id) {
        return count("genero=?1 and curso.id=?2", genero, id);
    }

    public List<DtoAlumnoGenero> countByGenero() {
        List<DtoAlumnoGenero> list = new ArrayList<>();
        List<String> generos = listGenero();
        for (String genero : generos) {
            DtoAlumnoGenero dto = new DtoAlumnoGenero();
            dto.setTotal(countByGenero(genero));
            dto.setGenero(genero);
            list.add(dto);
        }
        return list;
    }

    public List<String> listGenero() {
        return entityManager.createQuery(
                "SELECT a.genero FROM Alumno a GROUP BY a.genero",
                String.class).getResultList();
    }

}
