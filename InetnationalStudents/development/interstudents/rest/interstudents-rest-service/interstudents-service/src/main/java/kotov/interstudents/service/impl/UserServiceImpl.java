package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.UserDao;
import kotov.interstudents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 05.03.2015.
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User, UserDao> implements UserService {


    @Override
    @Autowired
    public void setDao(UserDao dao) {
        this.dao = dao;
    }


    @Override
    public User getByLogin(String login) {
        return this.dao.getByLogin(login);
    }
}
