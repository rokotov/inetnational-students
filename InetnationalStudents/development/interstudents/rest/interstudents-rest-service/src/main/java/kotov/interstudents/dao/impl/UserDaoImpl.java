package kotov.interstudents.dao.impl;

import kotov.interstudents.common.dao.AbstractDaoImpl;
import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.dao.UserDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by vkotov on 05.03.2015.
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {
    @Override
    public User getByLogin(String login) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }
}
