package kotov.interstudents.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by vkotov on 04.03.2015.
 */
public class LoginForm {
    @Size(min = 1)
    @NotNull
    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
