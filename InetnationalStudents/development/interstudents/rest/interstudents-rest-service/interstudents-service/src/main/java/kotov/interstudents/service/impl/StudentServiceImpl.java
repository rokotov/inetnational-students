package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.StudentDao;
import kotov.interstudents.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class StudentServiceImpl extends AbstractServiceImpl<Student, StudentDao> implements StudentService{
    @Override
    @Autowired
    public void setDao(StudentDao dao) {
        this.dao = dao;
    }
}
