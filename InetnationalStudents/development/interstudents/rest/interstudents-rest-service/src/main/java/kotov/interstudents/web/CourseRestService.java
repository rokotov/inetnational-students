package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Course;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/course")
public class CourseRestService extends AbstractRestServiceImpl<Course> {
    @Autowired
    private CourseService courseService;

    @Override
    protected AbstractService<Course> getService() {
        return courseService;
    }
}
