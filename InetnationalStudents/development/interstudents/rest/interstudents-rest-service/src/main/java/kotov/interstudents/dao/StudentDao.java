package kotov.interstudents.dao;

import kotov.interstudents.common.AbstractDao;
import kotov.interstudents.common.model.entity.CourseStatisticBySpeciality;
import kotov.interstudents.common.model.entity.Student;

import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
public interface StudentDao extends AbstractDao<Student> {
    List<CourseStatisticBySpeciality> getCourseStatisticBySpeciality();
}