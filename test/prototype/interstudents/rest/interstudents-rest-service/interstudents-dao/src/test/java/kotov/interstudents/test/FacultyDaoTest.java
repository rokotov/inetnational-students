package kotov.interstudents.test;

import kotov.interstudents.common.model.entity.Faculty;
import kotov.interstudents.dao.FacultyDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/interstudents-dao-test-context.xml"})
@TransactionConfiguration(defaultRollback=true, transactionManager="kotov.interstudents.TransactionManager")
@Transactional
public class FacultyDaoTest {

    @Autowired
    private FacultyDao facultyDao;

    @Test
    public void findEntityById(){
        Faculty entityById = facultyDao.findEntityById(1);

        Assert.assertEquals(Integer.class, entityById.getId().getClass());
        Assert.assertEquals(String.class, entityById.getFacultyName().getClass());
    }

    @Test
    public void getAllEntities(){
        List<Faculty> list = facultyDao.getAllEntities();

        Assert.assertNotNull(list);
    }

    @Test
    public void addEntity(){
        Faculty entity = new Faculty();
        entity.setFacultyName("123");

        Assert.assertTrue(facultyDao.addEntity(entity) > 0);
    }

    @Test
    public void deleteEntity(){
        Faculty entity = new Faculty();
        entity.setFacultyName("123");

        facultyDao.addEntity(entity);
        facultyDao.deleteEntity(entity);
    }

    @Test
    public void saveOrUpdateEntity(){
        //new entity
        Faculty entity = new Faculty();
        entity.setFacultyName("FacultyName 1");
        //add entity
        facultyDao.addEntity(entity);
        //edit entity
        entity.setFacultyName("FacultyName 2");

        facultyDao.saveOrUpdateEntity(entity);
    }
}
