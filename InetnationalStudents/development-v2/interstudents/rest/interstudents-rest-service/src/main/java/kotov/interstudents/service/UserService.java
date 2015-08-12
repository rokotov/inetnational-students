package kotov.interstudents.service;

import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Created by vkotov on 05.03.2015.
 */
public interface UserService extends AbstractService<User>, UserDetailsService {
    User getByLogin(String login);
}
