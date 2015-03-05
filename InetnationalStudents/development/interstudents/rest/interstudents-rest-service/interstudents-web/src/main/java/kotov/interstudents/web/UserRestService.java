package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.RestService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Created by vkotov on 05.03.2015.
 */
@Component
@Path("/user")
public class UserRestService extends AbstractRestServiceImpl<User> implements RestService<User> {

    @Autowired
    private UserService userService;

    @Override
    protected AbstractService<User> getService() {
        return userService;
    }

    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByLogin(@QueryParam("login") String login) {
        try {
            return returnEntityCheck(userService.getByLogin(login));
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
