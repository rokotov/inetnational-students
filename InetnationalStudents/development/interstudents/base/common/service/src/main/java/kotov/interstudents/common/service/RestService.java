package kotov.interstudents.common.service;

import javax.ws.rs.core.Response;

/**
 * Created by vkotov on 05.03.2015.
 */
public interface RestService<T> {

    Response addEntity(T entity);

    Response saveOrUpdateEntity(T entity);

    Response deleteEntity(Integer id);

    Response deleteEntity(T entity);

    Response findAll();

    Response find(Integer id);
}
