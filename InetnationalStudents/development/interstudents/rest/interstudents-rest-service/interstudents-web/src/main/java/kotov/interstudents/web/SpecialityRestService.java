package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/speciality")
public class SpecialityRestService extends AbstractRestServiceImpl<Speciality> {
    @Autowired
    private SpecialityService specialityService;

    @Override
    protected AbstractService<Speciality> getService() {
        return specialityService;
    }
}
