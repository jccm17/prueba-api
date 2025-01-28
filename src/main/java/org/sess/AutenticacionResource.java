package org.sess;

import org.sess.utils.TokenUtils;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("auth")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class AutenticacionResource {
    @PermitAll
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login() {
        try {
            return Response.ok(TokenUtils.generateToken("ADMIN")).build();
        } catch (Exception e) {
            return Response.status(403).build();
        }
    }
}
