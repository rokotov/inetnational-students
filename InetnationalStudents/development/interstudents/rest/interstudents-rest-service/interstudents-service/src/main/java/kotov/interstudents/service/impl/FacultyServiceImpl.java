package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Faculty;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.FacultyDao;
import kotov.interstudents.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class FacultyServiceImpl extends AbstractServiceImpl<Faculty, FacultyDao> implements FacultyService{
    @Override
    @Autowired
    public void setDao(FacultyDao dao) {
        this.dao = dao;
    }
}
