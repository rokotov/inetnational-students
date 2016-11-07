package kotov.interstudents.common;

import kotov.interstudents.common.model.AbstractEntity;
import javax.ws.rs.core.Response;

/**
 * Created by vkotov on 18.12.2014.
 */

public interface AbstractRestService<T extends AbstractEntity> {

        Response addEntity(T entity);

        Response getEntityById(Integer id);

        Response getAllEntities();

        Response saveOrUpdateEntity(T entity);

        Response deleteEntity(Integer id);

        Response deleteEntity(T entity);
}

