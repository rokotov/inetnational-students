package kotov.interstudents.test;

import kotov.interstudents.common.model.entity.Country;
import kotov.interstudents.common.model.entity.Course;
import kotov.interstudents.common.model.entity.Group;
import kotov.interstudents.common.model.entity.Student;
import kotov.interstudents.dao.StudentDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/interstudents-dao-test-context.xml"})
@TransactionConfiguration(defaultRollback=true, transactionManager="kotov.interstudents.TransactionManager")
@Transactional
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void findEntityById(){
        Student entityById = studentDao.findEntityById(1);

        Assert.assertEquals(Integer.class, entityById.getId().getClass());
        Assert.assertEquals(Country.class, entityById.getCountry().getClass());
        Assert.assertEquals(Course.class, entityById.getCourse().getClass());
        Assert.assertEquals(String.class, entityById.getFirstName().getClass());
        Assert.assertEquals(String.class, entityById.getLastName().getClass());
        Assert.assertEquals(String.class, entityById.getMiddleName().getClass());
        Assert.assertEquals(String.class, entityById.getFioLatin().getClass());
        Assert.assertEquals(String.class, entityById.getStudyForm().getClass());
        Assert.assertEquals(String.class, entityById.getRegistrationAddress().getClass());
        Assert.assertEquals(Timestamp.class, entityById.getRegistrationDeadline().getClass());
        Assert.assertNotNull(entityById.getOrderNumber());
        Assert.assertEquals(Timestamp.class, entityById.getBirthDate().getClass());
        Assert.assertEquals(String.class, entityById.getBirthPlace().getClass());
        Assert.assertEquals(String.class, entityById.getPassportNumber().getClass());
        Assert.assertEquals(Timestamp.class, entityById.getPassportValidity().getClass());
        Assert.assertEquals(String.class, entityById.getGraduated().getClass());
    }

    @Test
    public void getAllEntities(){
        List<Student> list = studentDao.getAllEntities();

        Assert.assertNotNull(list);
    }

    @Test
    public void addEntity(){

        Student entity = new Student();
        entity.setGroup(studentDao.findEntityById(1).getGroup());
        entity.setCountry(studentDao.findEntityById(1).getCountry());
        entity.setCourse(studentDao.findEntityById(1).getCourse());
        entity.setFirstName("123");
        entity.setLastName("123");
        entity.setMiddleName("123");
        entity.setFioLatin("123");
        entity.setStudyForm("123");
        entity.setRegistrationAddress("123");
        entity.setRegistrationDeadline(new Date(123));
        entity.setOrderNumber(134);
        entity.setBirthDate(new Date(123));
        entity.setBirthPlace("123");
        entity.setPassportNumber("123");
        entity.setPassportValidity(new Date(123));
        entity.setGraduated("123");


        Assert.assertTrue(studentDao.addEntity(entity) > 0);
    }

    @Test
    public void deleteEntity(){
        Student entity = new Student();
        entity.setGroup(studentDao.findEntityById(1).getGroup());
        entity.setCountry(studentDao.findEntityById(1).getCountry());
        entity.setCourse(studentDao.findEntityById(1).getCourse());
        entity.setFirstName("123");
        entity.setLastName("123");
        entity.setMiddleName("123");
        entity.setFioLatin("123");
        entity.setStudyForm("123");
        entity.setRegistrationAddress("123");
        entity.setRegistrationDeadline(new Date(123));
        entity.setOrderNumber(134);
        entity.setBirthDate(new Date(123));
        entity.setBirthPlace("123");
        entity.setPassportNumber("123");
        entity.setPassportValidity(new Date(123));
        entity.setGraduated("123");

        studentDao.addEntity(entity);
        studentDao.deleteEntity(entity);
    }

    @Test
    public void saveOrUpdateEntity(){
        //new entity
        Student entity = new Student();
        entity.setGroup(studentDao.findEntityById(1).getGroup());
        entity.setCountry(studentDao.findEntityById(1).getCountry());
        entity.setCourse(studentDao.findEntityById(1).getCourse());
        entity.setFirstName("123");
        entity.setLastName("123");
        entity.setMiddleName("123");
        entity.setFioLatin("123");
        entity.setStudyForm("123");
        entity.setRegistrationAddress("123");
        entity.setRegistrationDeadline(new Date(123));
        entity.setOrderNumber(134);
        entity.setBirthDate(new Date(123));
        entity.setBirthPlace("123");
        entity.setPassportNumber("123");
        entity.setPassportValidity(new Date(123));
        entity.setGraduated("123");
        //add entity
        studentDao.addEntity(entity);
        //edit entity
        entity.setGroup(new Group());
        entity.setCountry(new Country());
        entity.setCourse(new Course());
        entity.setFirstName("123af");
        entity.setLastName("12sdf3");
        entity.setMiddleName("1dsf23");
        entity.setFioLatin("12dsf3");
        entity.setStudyForm("12sdf3");
        entity.setRegistrationAddress("12fd3");
        entity.setRegistrationDeadline(new Date(1233));
        entity.setOrderNumber(1334);
        entity.setBirthDate(new Date(1223));
        entity.setBirthPlace("123sdf");
        entity.setPassportNumber("12sfd3");
        entity.setPassportValidity(new Date(1233));
        entity.setGraduated("12asd3");

        studentDao.saveOrUpdateEntity(entity);
    }
}
