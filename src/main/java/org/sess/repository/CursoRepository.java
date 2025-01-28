package org.sess.repository;

import java.util.List;
import java.util.Optional;

import org.sess.models.Alumno;
import org.sess.models.Curso;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CursoRepository implements PanacheRepository<Curso> {

    private final EntityManager entityManager;

    public List<Curso> listAllCustom() {
        return entityManager.createQuery(
                "SELECT c, (SELECT count(a.id) FROM Alumno a WHERE a.curso.id = c.id) as totalAlumno FROM Curso c ",
                Curso.class).getResultList();
    }

    public CursoRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<Curso> findByNombre(String nombre) {
        return find("nombre", nombre).firstResultOptional();
    }

    public int totalAlumnos(Long id) {
        return entityManager.createQuery(
                "SELECT count(a.id) FROM Alumno a "
                        + "INNER JOIN Curso c ON a.curso.id = c.id "
                        + " WHERE c.id = :id",
                Alumno.class)
                .setParameter("id", id).getFirstResult();
    }

    public Long countAlumnos(Long id) {
        return (Long) entityManager.createQuery(
                "SELECT count(a.id) FROM Alumno a "
                        + "INNER JOIN Curso c ON a.curso.id = c.id "
                        + " WHERE c.id = :id")
                .setParameter("id", id).getSingleResult();
    }
}
