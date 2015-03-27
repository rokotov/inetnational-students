package kotov.interstudents.common.rest.client;

import kotov.interstudents.common.model.entity.CourseStatisticBySpeciality;
import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.common.rest.RestClient;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vkotov on 06.03.2015.
 */
public class SpecialityRestClient extends RestClient {
    private String getCourseStatisticBySpecialityUrl;

    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
        this.getCourseStatisticBySpecialityUrl = this.serviceUrl + "statisticbySpec";
    }

//    public List<CourseStatisticBySpeciality> getCourseStatisticBySpeciality() {
//        return Arrays.asList((CourseStatisticBySpeciality[])restTemplate.getForObject(this.getCourseStatisticBySpecialityUrl, CourseStatisticBySpeciality[].class));
//    }

    public List<Speciality> getAll() {
        return Arrays.asList(restTemplate.getForObject(this.serviceUrl, Speciality[].class));
    }

    public Speciality getEntity(Integer id) {
        return get(id, Speciality.class);
    }
}
