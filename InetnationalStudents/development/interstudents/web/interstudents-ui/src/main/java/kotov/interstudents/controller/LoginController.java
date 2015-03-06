package kotov.interstudents.controller;

import kotov.interstudents.common.model.entity.User;
import kotov.interstudents.common.rest.client.StudentRestClient;
import kotov.interstudents.common.rest.client.UserRestClient;
import kotov.interstudents.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by vkotov on 04.03.2015.
 */
@Controller
@RequestMapping(LoginController.LOGIN_PATH)
public class LoginController {

    public static final String LOGIN_PATH = "/login";

    public static final String REDIRECT_PATH = "/home";

    @Autowired
    private UserRestClient userRestClient;

    @RequestMapping(method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/loginAngular";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                        BindingResult result,
                        HttpSession session) {

        if (result.hasErrors()) {
            return "login/loginAngular";
        }
        User user = userRestClient.getByLogin(loginForm.getLogin());

      /*  Employee employee = employeeRestClient.getByLogin(loginForm.getLogin());
        if (employee == null) {
            result.rejectValue("login", "loginForm.notFound");
            return "testlogin";
        }*/
//        JobPosition hrPostion = jobPositionRestClient.getHr();
//        session.setAttribute("isHr", employee.getPosition().equals(hrPostion));
//        session.setAttribute("employee", employee);

        String redirect = (String) session.getAttribute("redirect");
        session.removeAttribute("redirect");
        if (redirect == null) {
            redirect = REDIRECT_PATH;
        }
        return "redirect:" + redirect;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("employee");
        session.removeAttribute("isHr");
        return "redirect:" + LOGIN_PATH;
    }
}
