package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Course;
import kotov.interstudents.service.CourseService;
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
@Path("/course")
public class CourseRestService {
    @Autowired
    private CourseService courseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntity(Course entity) {
        try {
            Integer addEntityId = courseService.addEntity(entity);
            return Response.status(Response.Status.CREATED).entity(addEntityId).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEntityById(@PathParam("id") Integer id) {
        try {
            Course entityById = courseService.findEntityById(id);

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

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEntities() {
        try {
            List<Course> allEntities = courseService.getAllEntities();
            if (allEntities != null) {
                return Response.status(Response.Status.OK).entity(allEntities).build();
            }else {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateEntity(Course entity) {
        try {
            courseService.saveOrUpdateEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(@PathParam("id") Integer id) {
        try {
            courseService.deleteEntity(id);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(Course entity) {
        try {
            courseService.deleteEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
