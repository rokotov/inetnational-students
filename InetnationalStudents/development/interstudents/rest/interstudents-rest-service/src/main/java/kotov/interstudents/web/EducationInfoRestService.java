package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.EducationInfo;
import kotov.interstudents.service.EducationInfoService;
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
@Path("/education-info")
public class EducationInfoRestService {
    @Autowired
    private EducationInfoService educationInfoService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntity(EducationInfo entity) {
        try {
            Integer addEntityId = educationInfoService.addEntity(entity);
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
            EducationInfo entityById = educationInfoService.findEntityById(id);

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
            List<EducationInfo> allEntities = educationInfoService.getAllEntities();
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
    public Response saveOrUpdateEntity(EducationInfo entity) {
        try {
            educationInfoService.saveOrUpdateEntity(entity);
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
            educationInfoService.deleteEntity(id);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(EducationInfo entity) {
        try {
            educationInfoService.deleteEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
