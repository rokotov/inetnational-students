package kotov.interstudents.dao.impl;

import kotov.interstudents.common.dao.AbstractDaoImpl;
import kotov.interstudents.common.model.entity.*;
import kotov.interstudents.common.rest.client.CountryRestClient;
import kotov.interstudents.common.rest.client.SpecialityRestClient;
import kotov.interstudents.dao.SpecialityDao;
import kotov.interstudents.dao.StudentDao;
import kotov.interstudents.service.CountryService;
import kotov.interstudents.service.SpecialityService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@Repository
@Transactional
public class StudentDaoImpl extends AbstractDaoImpl<Student> implements StudentDao {

    @Autowired
    private CountryService countryService;

    @Autowired
    private SpecialityService specialityService;


    @Override
    public List<CourseStatisticBySpeciality> getCourseStatisticBySpeciality() {

        List<Speciality> specialityList = specialityService.getAllEntities();
        List<CourseStatisticBySpeciality> list = new ArrayList<>();


        for(Speciality speciality : specialityList) {
            CourseStatisticBySpeciality statisticBySpeciality = new CourseStatisticBySpeciality();
            statisticBySpeciality.setSpeciality(speciality);

            Criteria criteria = getSession().createCriteria(Student.class);
            criteria.createAlias("group","group");
            List<Student> studentList = criteria.add(Restrictions.eq("group.speciality", speciality)).list();

            for(Student student : studentList){
                /*switch (student.getCourse()){
                    case "0": statisticBySpeciality.addCount0();
                        break;
                    case "1": statisticBySpeciality.addCount1();
                        break;
                    case "2": statisticBySpeciality.addCount2();
                        break;
                    case "3": statisticBySpeciality.addCount3();
                        break;
                    case "4": statisticBySpeciality.addCount4();
                        break;
                    case "5": statisticBySpeciality.addCount5();
                        break;
                    case "II": statisticBySpeciality.addCountII();
                        break;
                    case "III": statisticBySpeciality.addCountIII();
                        break;
                    case "K": statisticBySpeciality.addCountK();
                        break;
                    case "A": statisticBySpeciality.addCountA();
                        break;
                    default:
                        break;
                }*/
            }
            list.add(statisticBySpeciality);
        }

        return list;
    }

    @Override
    public List<CourseStatisticByCountry> getCourseStatisticByCountry() {
        List<Country> countryList = countryService.getAllEntities();
        List<CourseStatisticByCountry> list = new ArrayList<>();


        for(Country country : countryList) {
            CourseStatisticByCountry statisticByCountry = new CourseStatisticByCountry();
            statisticByCountry.setCountry(country);

            Criteria criteria = getSession().createCriteria(Student.class);
            List<Student> studentList = criteria.add(Restrictions.eq("country", country)).list();

            for(Student student : studentList){
                /*switch (student.getCourse()){
                    case "0": statisticByCountry.addCount0();
                        break;
                    case "1": statisticByCountry.addCount1();
                        break;
                    case "2": statisticByCountry.addCount2();
                        break;
                    case "3": statisticByCountry.addCount3();
                        break;
                    case "4": statisticByCountry.addCount4();
                        break;
                    case "5": statisticByCountry.addCount5();
                        break;
                    case "II": statisticByCountry.addCountII();
                        break;
                    case "III": statisticByCountry.addCountIII();
                        break;
                    case "K": statisticByCountry.addCountK();
                        break;
                    case "A": statisticByCountry.addCountA();
                        break;
                    default:
                        break;
                }*/
            }
            list.add(statisticByCountry);
        }

        return list;
    }
}
