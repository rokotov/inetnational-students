package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Hostel;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 03.03.2015.
 */
@Component
@Path("/hostel")
public class HostelRestService extends AbstractRestServiceImpl<Hostel> {
    @Autowired
    private HostelService hostelService;

    @Override
    protected AbstractService<Hostel> getService() {
        return hostelService;
    }
}
