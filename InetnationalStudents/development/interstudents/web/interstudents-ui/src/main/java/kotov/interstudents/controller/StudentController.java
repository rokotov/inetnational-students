package kotov.interstudents.controller;

import kotov.interstudents.common.model.entity.*;
import kotov.interstudents.common.rest.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vkotov on 06.03.2015.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private CountryRestClient countryRestClient;

//    @Autowired
//    private EducationInfoRestClient educationInfoRestClient;

    @Autowired
    private FacultyRestClient facultyRestClient;

    @Autowired
    private GroupRestClient groupRestClient;

    @Autowired
    private HostelRestClient hostelRestClient;

    @Autowired
    private StudentRestClient studentRestClient;

    @RequestMapping(method = RequestMethod.GET)
    public String student(ModelMap model) {
        model.addAttribute("countries", countryRestClient.getAll(Country[].class));
        model.addAttribute("faculties", facultyRestClient.getAll(Faculty[].class));
        model.addAttribute("groups", groupRestClient.getAll(Group[].class));
        model.addAttribute("hostels", hostelRestClient.getAll(Hostel[].class));
        model.addAttribute("students", studentRestClient.getAll(Student[].class));
        return "student/student";
    }
}
