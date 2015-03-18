package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.EducationInfo;
import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.EducationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 03.03.2015.
 */
@Component
@Path("/education-info")
public class EducationInfoRestService extends AbstractRestServiceImpl<EducationInfo> {
    @Autowired
    private EducationInfoService educationInfoService;

    @Override
    protected AbstractService<EducationInfo> getService() {
        return educationInfoService;
    }
}
