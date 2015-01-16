package kotov.interstudents.common.service;

import kotov.interstudents.common.AbstractDao;
import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.AbstractService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vkotov on 18.12.2014.
 */
public abstract class AbstractServiceImpl <T extends AbstractEntity, D extends AbstractDao<T>> implements AbstractService<T> {

    protected D dao;

    public abstract void setDao(D dao);


    @Override
    @Transactional(readOnly = true)
    public T findEntityById(Integer id, String... properties) {
        return dao.findEntityById(id, properties);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> getAllEntities() {
        return dao.getAllEntities();
    }

    @Override
    @Transactional
    public Integer addEntity(T entity) {
        return dao.addEntity(entity);
    }

    @Override
    @Transactional
    public void deleteEntity(Integer id) {
        T entity = dao.findEntityById(id);

        if (entity != null) {
            dao.deleteEntity(entity);
        }
    }

    @Override
    @Transactional
    public void deleteEntity(T entity) {
        dao.deleteEntity(entity);
    }

    @Override
    @Transactional
    public void saveOrUpdateEntity(T entity) {
        dao.saveOrUpdateEntity(entity);
    }
}