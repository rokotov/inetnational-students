package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Group;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/group")
public class GroupRestService extends AbstractRestServiceImpl<Group> {
    @Autowired
    private GroupService groupService;

    @Override
    protected AbstractService<Group> getService() {
        return groupService;
    }
}
