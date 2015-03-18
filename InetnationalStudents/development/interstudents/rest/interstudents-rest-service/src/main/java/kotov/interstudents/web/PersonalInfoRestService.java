package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.PersonalInfo;
import kotov.interstudents.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by vkotov on 03.03.2015.
 */
@Component
@Path("/personal-info")
public class PersonalInfoRestService {
    @Autowired
    private PersonalInfoService personalInfoService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntity(PersonalInfo entity) {
        try {
            Integer addEntityId = personalInfoService.addEntity(entity);
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
            PersonalInfo entityById = personalInfoService.findEntityById(id);

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
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEntities() {
        try {
            List<PersonalInfo> allEntities = personalInfoService.getAllEntities();
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateEntity(PersonalInfo entity) {
        try {
            personalInfoService.saveOrUpdateEntity(entity);
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
            personalInfoService.deleteEntity(id);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(PersonalInfo entity) {
        try {
            personalInfoService.deleteEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
