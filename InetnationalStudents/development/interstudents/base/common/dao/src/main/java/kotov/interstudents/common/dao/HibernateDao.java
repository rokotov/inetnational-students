package kotov.interstudents.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by vkotov on 18.12.2014.
 */
public class HibernateDao <T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    public HibernateDao() {
        for (Type type = getClass().getGenericSuperclass(); type != null; ) {
            if (type instanceof ParameterizedType) {
                Object parameter = ((ParameterizedType) type).getActualTypeArguments()[0];

                if (parameter instanceof Class) {
                    persistentClass = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    persistentClass = (Class<T>) ((ParameterizedType) ((TypeVariable<?>) parameter).getBounds()[0]).getRawType();
                }

                break;
            } else if (type instanceof Class) {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
