package kotov.interstudents.dao.impl;

import kotov.interstudents.common.dao.AbstractDaoImpl;
import kotov.interstudents.common.model.entity.CourseStatisticBySpeciality;
import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.common.rest.client.SpecialityRestClient;
import kotov.interstudents.dao.SpecialityDao;
import kotov.interstudents.dao.StudentDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@Repository
@Transactional
public class StudentDaoImpl extends AbstractDaoImpl<Student> implements StudentDao {
    @Autowired
    private SpecialityRestClient specialityRestClient;

    @Override
    public List<CourseStatisticBySpeciality> getCourseStatisticBySpeciality() {

        List<Speciality> specialityList = specialityRestClient.getAll();
        List<CourseStatisticBySpeciality> list = new ArrayList<>();


        for(Speciality speciality : specialityList) {
            CourseStatisticBySpeciality statisticBySpeciality = new CourseStatisticBySpeciality();
            statisticBySpeciality.setSpeciality(specialityRestClient.getEntity(speciality.getId()));

            Criteria criteria = getSession().createCriteria(Student.class);
            criteria.createAlias("group","group");
            List<Student> studentList = criteria.add(Restrictions.eq("group.speciality", speciality)).list();

            for(Student student : studentList){
                switch (student.getCourse()){
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
                }
            }
            list.add(statisticBySpeciality);
        }

        return list;
    }
}
