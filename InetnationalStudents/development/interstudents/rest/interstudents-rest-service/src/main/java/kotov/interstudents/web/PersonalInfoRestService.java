package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.PersonalInfo;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 03.03.2015.
 */
@Component
@Path("/personal-info")
public class PersonalInfoRestService extends AbstractRestServiceImpl<PersonalInfo> {
    @Autowired
    private PersonalInfoService personalInfoService;

    @Override
    protected AbstractService<PersonalInfo> getService() {
        return personalInfoService;
    }
}
