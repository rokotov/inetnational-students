package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Faculty;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/faculty")
public class FacultyRestService extends AbstractRestServiceImpl<Faculty> {

    @Autowired
    private FacultyService facultyService;

    @Override
    protected AbstractService<Faculty> getService() {
        return facultyService;
    }
}
