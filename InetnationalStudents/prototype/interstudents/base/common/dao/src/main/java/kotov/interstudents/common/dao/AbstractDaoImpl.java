package kotov.interstudents.common.dao;

import kotov.interstudents.common.AbstractDao;
import kotov.interstudents.common.model.AbstractEntity;

import java.util.List;

/**
 * Created by vkotov on 18.12.2014.
 */
public abstract class AbstractDaoImpl <T extends AbstractEntity> extends HibernateDao <T> implements AbstractDao<T> {
    @Override
    public T findEntityById(Integer id, String... properties) {
        return (T) getSession().get(getPersistentClass(), id);
    }

    @Override
    public List<T> getAllEntities() {
        return getSession().createCriteria(getPersistentClass()).list();
    }

    @Override
    public Integer addEntity(T entity) {
        return (Integer) getSession().save(entity);
    }

    @Override
    public void deleteEntity(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void saveOrUpateEntity(T entity) {
        getSession().saveOrUpdate(entity);
    }
}
