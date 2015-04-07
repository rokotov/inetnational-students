package kotov.interstudents.common.rest.client;

import kotov.interstudents.common.model.entity.Country;
import kotov.interstudents.common.rest.RestClient;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vkotov on 06.03.2015.
 */
public class CountryRestClient extends RestClient {

    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
    }


    public List<Country> getAll() {
        return Arrays.asList(getAll(Country[].class));
    }

    public Country getEntity(Integer id) {
        return get(id, Country.class);
    }
}
