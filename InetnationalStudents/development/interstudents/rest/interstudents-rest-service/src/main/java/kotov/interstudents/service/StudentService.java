package kotov.interstudents.service;

import kotov.interstudents.common.model.entity.CourseStatisticByCountry;
import kotov.interstudents.common.model.entity.CourseStatisticBySpeciality;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.model.entity.Student;

import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */

public interface StudentService extends AbstractService<Student> {
    List<CourseStatisticBySpeciality> getCourseStatisticBySpeciality();

    List<CourseStatisticByCountry> getCourseStatisticByCountry();
}
