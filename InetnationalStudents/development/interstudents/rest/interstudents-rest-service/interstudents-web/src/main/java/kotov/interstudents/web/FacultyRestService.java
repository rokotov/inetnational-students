package kotov.interstudents.web;

import kotov.interstudents.common.service.AbstractRestService;
import kotov.interstudents.common.model.entity.Faculty;
import kotov.interstudents.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/faculty")
public class FacultyRestService implements AbstractRestService<Faculty> {

    @Autowired
    private FacultyService facultyService;

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntity(Faculty entity) {
        try {
            Integer addEntityId = facultyService.addEntity(entity);
            return Response.status(Response.Status.CREATED).entity(addEntityId).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEntityById(@PathParam("id") Integer id) {
        try {
            Faculty entityById = facultyService.findEntityById(id);

            if (entityById != null){
                return Response.status(Response.Status.OK).entity(entityById).build();
            }else {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEntities() {
        try {
            List<Faculty> allEntities = facultyService.getAllEntities();
            if (allEntities != null) {
                return Response.status(Response.Status.OK).header("Access-Control-Allow-Origin", "http://localhost:8000").entity(allEntities).build();
            }else {
                return Response.status(Response.Status.NO_CONTENT).header("Access-Control-Allow-Origin", "http://localhost:8000").build();
            }
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("Access-Control-Allow-Origin", "http://localhost:8000").entity(e.getMessage()).build();
        }
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateEntity(Faculty entity) {
        try {
            facultyService.saveOrUpdateEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(@PathParam("id") Integer id) {
        try {
            facultyService.deleteEntity(id);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(Faculty entity) {
        try {
            facultyService.deleteEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
