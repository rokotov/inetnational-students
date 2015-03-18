package kotov.interstudents.web;

import kotov.interstudents.common.model.entity.Country;

import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.service.impl.AbstractRestServiceImpl;
import kotov.interstudents.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Component
@Path("/country")
public class CountryRestService extends AbstractRestServiceImpl<Country> {
    @Autowired
    private CountryService countryService;

    @Override
    protected AbstractService<Country> getService() {
        return countryService;
    }

}
