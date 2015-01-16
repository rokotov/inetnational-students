package kotov.interstudents.dao.impl;

import kotov.interstudents.common.dao.AbstractDaoImpl;
import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.dao.StudentDao;
import org.springframework.stereotype.Repository;

/**
 * Created by vkotov on 16.01.2015.
 */
@Repository
public class StudentDaoImpl extends AbstractDaoImpl<Student> implements StudentDao {
}
