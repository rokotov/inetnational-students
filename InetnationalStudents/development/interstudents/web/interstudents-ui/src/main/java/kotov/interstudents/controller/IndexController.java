package kotov.interstudents.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vkotov on 04.03.2015.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping()
    public String index() {
        return "redirect:" +"/login";
    }

    @RequestMapping(method = RequestMethod.HEAD)
    public String head() {
        return "redirect: " + "/login";
    }
}
