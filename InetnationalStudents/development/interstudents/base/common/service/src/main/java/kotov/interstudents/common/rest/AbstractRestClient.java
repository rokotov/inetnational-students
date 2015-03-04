package kotov.interstudents.common.rest;

import org.springframework.web.client.RestTemplate;

public abstract class AbstractRestClient {

    protected RestTemplate restTemplate;

    protected String serviceUrl;

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }
}
