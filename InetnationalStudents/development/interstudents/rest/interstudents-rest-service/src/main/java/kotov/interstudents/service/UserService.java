package kotov.interstudents.service;

import kotov.interstudents.common.service.AbstractService;
import kotov.interstudents.common.model.entity.User;


/**
 * Created by vkotov on 05.03.2015.
 */
public interface UserService extends AbstractService<User> {
    User getByLogin(String login);
}
