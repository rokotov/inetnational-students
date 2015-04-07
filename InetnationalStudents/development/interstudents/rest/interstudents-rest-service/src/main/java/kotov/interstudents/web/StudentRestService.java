package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/student")
public class StudentRestService extends AbstractRestServiceImpl<Student> {
    @Autowired
    private StudentService studentService;

    @Override
    protected AbstractService<Student> getService() {
        return studentService;
    }

    @GET
    @Path("/statisticBySpeciality")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseStatisticBySpeciality() {
        try {
            return returnEntityCheck(studentService.getCourseStatisticBySpeciality());
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/statisticByCountry")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseStatisticByCountry() {
        try {
            return returnEntityCheck(studentService.getCourseStatisticByCountry());
        }
        catch (CannotCreateTransactionException e){
            return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
