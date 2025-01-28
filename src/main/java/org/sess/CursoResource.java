package org.sess;

import java.util.List;

import org.sess.dto.DtoCapacidadCurso;
import org.sess.dto.DtoCurso;
import org.sess.dto.DtoPromedioCurso;
import org.sess.models.Curso;
import org.sess.services.CursoService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("api/v1/cursos")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class CursoResource {

    @Inject
    private CursoService cursoService;

    @GET
    @RolesAllowed("ADMIN")
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Curso buscarPorId(@PathParam("id") Long id) {
        return cursoService.buscarPorId(id);
    }

    @POST
    @RolesAllowed("ADMIN")
    public Curso nuevo(DtoCurso curso) {
        return cursoService.nuevo(curso);
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Curso modificar(@PathParam("id") Long id, DtoCurso curso) {
        return cursoService.modificar(id, curso);
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Boolean eliminar(@PathParam("id") Long id) {
        return cursoService.eliminar(id);
    }

    @GET
    @Path("/total")
    @RolesAllowed("ADMIN")
    public Long totalCurso() {
        return cursoService.totalCurso();
    }

    @GET
    @Path("/total-alumnos-curso/{id}")
    @RolesAllowed("ADMIN")
    public Long totalAlumnosCurso(@PathParam("id") Long id) {
        return cursoService.totalAlumnos(id);
    }

    @GET
    @Path("/cupo-disponible-curso")
    @RolesAllowed("ADMIN")
    public List<DtoCapacidadCurso> capacidadCursoDisponible() {
        return cursoService.capacidadCurso();
    }

    @GET
    @Path("/promedio-ocupado-curso")
    @RolesAllowed("ADMIN")
    public List<DtoPromedioCurso> promedioCursoOcupado() {
        return cursoService.capacidadCursoOcupado();
    }
}
