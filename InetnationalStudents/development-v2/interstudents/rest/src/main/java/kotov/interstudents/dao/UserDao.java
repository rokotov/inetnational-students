package kotov.interstudents.dao;

import kotov.interstudents.common.AbstractDao;
import kotov.interstudents.common.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by vkotov on 05.03.2015.
 */
public interface UserDao extends AbstractDao<User>, UserDetailsService {
    User getByLogin(String login);
}
