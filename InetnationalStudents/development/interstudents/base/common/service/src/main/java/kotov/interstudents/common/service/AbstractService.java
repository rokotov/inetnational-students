package kotov.interstudents.common.service;


import kotov.interstudents.common.model.AbstractEntity;

import java.util.List;

/**
 * Created by vkotov on 18.12.2014.
 */
public interface AbstractService <T extends AbstractEntity> {

    T findEntityById(Integer id, String... properties);

    List<T> getAllEntities();

    Integer addEntity(T entity);

    void deleteEntity(Integer id);

    void deleteEntity(T entity);

    void saveOrUpdateEntity(T entity);
}
