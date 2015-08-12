package kotov.interstudents.common.rest.client;

import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.common.rest.RestClient;

/**
 * Created by vkotov on 05.03.2015.
 */
public class UserRestClient extends RestClient {
    private String byLoginUrl;


    @Override
    public void setServiceUrl(String serviceUrl) {
        super.setServiceUrl(serviceUrl);
        this.byLoginUrl = this.serviceUrl + "login?login={login}";
    }

    public User getByLogin(String login) {
        return restTemplate.getForObject(this.byLoginUrl, User.class, login);
    }
}
