package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.EducationInfo;
import kotov.interstudents.common.service.AbstractServiceImpl;
import kotov.interstudents.dao.EducationInfoDao;
import kotov.interstudents.service.EducationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 03.03.2015.
 */
@Service
public class EducationInfoServiceImpl extends AbstractServiceImpl<EducationInfo, EducationInfoDao> implements EducationInfoService {
    @Override
    @Autowired
    public void setDao(EducationInfoDao dao) {
        this.dao = dao;
    }
}
