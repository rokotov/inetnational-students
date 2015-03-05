package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.PersonalInfo;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.PersonalInfoDao;
import kotov.interstudents.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 03.03.2015.
 */
@Service
public class PersonalInfoServiceImpl extends AbstractServiceImpl<PersonalInfo, PersonalInfoDao> implements PersonalInfoService {
    @Override
    @Autowired
    public void setDao(PersonalInfoDao dao) {
        this.dao = dao;
    }
}
