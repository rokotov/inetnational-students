package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Group;
import kotov.interstudents.common.service.AbstractServiceImpl;
import kotov.interstudents.dao.GroupDao;
import kotov.interstudents.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class GroupServiceImpl extends AbstractServiceImpl<Group, GroupDao> implements GroupService{
    @Override
    @Autowired
    public void setDao(GroupDao dao) {
        this.dao = dao;
    }
}
