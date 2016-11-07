package kotov.interstudents.common.rest.client;

import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.common.rest.RestClient;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vkotov on 06.03.2015.
 */
public class SpecialityRestClient extends RestClient {

    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
    }


    public List<Speciality> getAll() {
        return Arrays.asList(getAll(Speciality[].class));
    }

    public Speciality getEntity(Integer id) {
        return get(id, Speciality.class);
    }
}
