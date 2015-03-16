package kotov.interstudents.common.service.impl;

import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.RestService;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by vkotov on 05.03.2015.
 */
public abstract class AbstractRestServiceImpl<T extends AbstractEntity> implements RestService<T> {

    protected abstract AbstractService<T> getService();

    @Override
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEntity(T entity) {
        try {
            Integer addEntityId = getService().addEntity(entity);
            return returnEntityCheck(addEntityId, Response.Status.CREATED);
        } catch (CannotCreateTransactionException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrUpdateEntity(T entity) {
        try {
            getService().saveOrUpdateEntity(entity);
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
            getService().deleteEntity(id);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEntity(T entity) {
        try {
            getService().deleteEntity(entity);
            return Response.status(Response.Status.OK).build();
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        try {
            return returnEntityCheck(getService().getAllEntities());
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
    public Response find(@PathParam("id") Integer id) {
        try {
            return returnEntityCheck(getService().findEntityById(id));
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    protected <returnEntityType> Response returnEntityCheck(returnEntityType returnEntity) {
        return  returnEntityCheck(returnEntity, Response.Status.OK);
    }

    protected <returnEntityType> Response returnEntityCheck(returnEntityType returnEntity, Response.Status sucessStatus) {
        if (returnEntity != null) {
            return Response.status(sucessStatus).entity(returnEntity).build();
        } else {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }
}
