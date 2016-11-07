package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Course;
import kotov.interstudents.common.service.AbstractServiceImpl;
import kotov.interstudents.dao.CourseDao;
import kotov.interstudents.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class CourseServiceImpl extends AbstractServiceImpl<Course, CourseDao> implements CourseService {
    @Override
    @Autowired
    public void setDao(CourseDao dao) {
        this.dao = dao;
    }
}
