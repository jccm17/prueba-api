package org.sess;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import org.sess.dto.DtoAlumnoCurso;
import org.sess.dto.DtoAlumnoGenero;
import org.sess.models.Alumno;
import org.sess.services.AlumnoService;

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
import jakarta.ws.rs.core.Response;

@Path("api/v1/alumnos")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class AlumnoResource {

    @Inject
    private AlumnoService alumnoService;

    @GET
    @RolesAllowed("ADMIN")
    public List<Alumno> listar() {
        return alumnoService.listar();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public Alumno buscarPorId(@PathParam("id") Long id) {
        return alumnoService.buscarPorId(id);
    }

    @POST
    @RolesAllowed("ADMIN")
    public RestResponse<?> nuevo(Alumno alumno) {
        Alumno entity = alumnoService.nuevo(alumno);
        return RestResponse
                .ok(entity != null ? Response.status(201).entity(entity).build() : Response.status(401).build());
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public RestResponse<?> modificar(@PathParam("id") Long id, Alumno alumno) {
        Alumno entity = alumnoService.modificar(id, alumno);
        return RestResponse
                .ok(entity != null ? Response.status(200).entity(entity).build() : Response.status(401).build());
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("ADMIN")
    public RestResponse<?> eliminar(@PathParam("id") Long id) {
        boolean resultado = alumnoService.eliminar(id);
        return RestResponse.ok(Response.status(resultado ? 200 : 401).build());
    }

    @GET
    @Path("/total")
    @RolesAllowed("ADMIN")
    public Long totalAlumno() {
        return alumnoService.totalAlumno();
    }

    @GET
    @Path("/total-genero")
    @RolesAllowed("ADMIN")
    public List<DtoAlumnoGenero> totalAlumnoGenero() {

        return alumnoService.totalAlumnoGenero();
    }

    @GET
    @Path("/total-genero-curso")
    @RolesAllowed("ADMIN")
    public List<DtoAlumnoCurso> totalAlumnoGeneroPorCurso() {
        return alumnoService.alumnosPorCursoGenero();
    }

    @GET
    @Path("/promedio-genero")
    @RolesAllowed("ADMIN")
    public Double promedioGenero() {
        return alumnoService.promedioAlumnoGenero();
    }

    @GET
    @Path("/promedio-Curso")
    @RolesAllowed("ADMIN")
    public Double promedioCurso() {
        return alumnoService.promedioAlumnoCurso();
    }
}
