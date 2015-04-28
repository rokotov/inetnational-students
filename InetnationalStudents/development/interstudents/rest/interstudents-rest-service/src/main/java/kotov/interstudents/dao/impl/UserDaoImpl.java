package kotov.interstudents.dao.impl;

import kotov.interstudents.common.dao.AbstractDaoImpl;
import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.dao.UserDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vkotov on 05.03.2015.
 */
@Repository
@Transactional
public class UserDaoImpl extends AbstractDaoImpl<User> implements UserDao {

    @Autowired
    private StandardPasswordEncoder passwordEncoder;

    @Override
    public User getByLogin(String login) {
        return (User) getSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = (User) getSession().createCriteria(User.class).add(Restrictions.eq("name", s)).uniqueResult();

       /* System.out.println(passwordEncoder.encode("admin"));*/

        if (null == user) {
            throw new UsernameNotFoundException("The user with name " + s + " was not found");
        }
        return user;
    }

    @Override
    public Integer addEntity(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));

        return (Integer) getSession().save(entity);
    }
}
