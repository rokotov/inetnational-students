package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

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
}
