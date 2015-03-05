package kotov.interstudents.dao;

import kotov.interstudents.common.AbstractDao;
import kotov.interstudents.common.model.entity.User;

/**
 * Created by vkotov on 05.03.2015.
 */
public interface UserDao extends AbstractDao<User> {
    User getByLogin(String login);
}
