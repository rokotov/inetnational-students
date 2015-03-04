package kotov.interstudents.common.rest;

public class RestClient extends AbstractRestClient {

    protected String serviceUrlAll;

    @Override
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
        this.serviceUrlAll = this.serviceUrl + "all";
    }

    public <T> T getAll(Class<T> responseType) {
        return restTemplate.getForObject(this.serviceUrlAll, responseType);
    }

    public <T> T get(int entityId, Class<T> responseType) {
        return restTemplate.getForObject(this.serviceUrl + entityId, responseType);
    }

    public <T> T get(String path, Class<T> responseType) {
        return restTemplate.getForObject(this.serviceUrl + path, responseType);
    }

    public <T> T get(String path, Class<T> responseType, Object... urlVariables) {
        return restTemplate.getForObject(this.serviceUrl + path, responseType, urlVariables);
    }

    public <T> T post(Object request, Class<T> responseType) {
        return restTemplate.postForObject(this.serviceUrl, request, responseType);
    }

    public <T> T post(String path, Object request, Class<T> responseType) {
        return restTemplate.postForObject(this.serviceUrl + path,request, responseType);
    }

    public void put(Object request) {
        restTemplate.put(this.serviceUrl, request);
    }

    public void delete(Integer id) {
        restTemplate.delete(this.serviceUrl + id);
    }
}
