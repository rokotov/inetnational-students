package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.SpecialityDao;
import kotov.interstudents.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class SpecialityServiceImpl extends AbstractServiceImpl<Speciality, SpecialityDao> implements SpecialityService{
    @Override
    @Autowired
    public void setDao(SpecialityDao dao) {
        this.dao = dao;
    }
}
