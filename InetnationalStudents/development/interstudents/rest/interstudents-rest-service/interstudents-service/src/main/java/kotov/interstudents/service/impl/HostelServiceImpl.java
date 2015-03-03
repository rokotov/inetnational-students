package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Hostel;
import kotov.interstudents.common.service.AbstractServiceImpl;
import kotov.interstudents.dao.HostelDao;
import kotov.interstudents.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 03.03.2015.
 */
@Service
public class HostelServiceImpl extends AbstractServiceImpl<Hostel, HostelDao> implements HostelService {
    @Override
    @Autowired
    public void setDao(HostelDao dao) {
        this.dao = dao;
    }
}
