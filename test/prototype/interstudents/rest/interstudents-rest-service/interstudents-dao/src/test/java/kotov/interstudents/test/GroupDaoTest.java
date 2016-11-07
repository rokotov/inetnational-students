package kotov.interstudents.test;

import kotov.interstudents.common.model.entity.Group;
import kotov.interstudents.common.model.entity.Speciality;
import kotov.interstudents.dao.GroupDao;
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
 * Created by vkotov on 26.01.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/interstudents-dao-test-context.xml"})
@TransactionConfiguration(defaultRollback=true, transactionManager="kotov.interstudents.TransactionManager")
@Transactional
public class GroupDaoTest {
    @Autowired
    private GroupDao groupDao;

    @Test
    public void findEntityById(){
        Group entityById = groupDao.findEntityById(1);

        Assert.assertEquals(Integer.class, entityById.getId().getClass());
        Assert.assertEquals(String.class, entityById.getGroupName().getClass());
    }

    @Test
    public void getAllEntities(){
        List<Group> list = groupDao.getAllEntities();

        Assert.assertNotNull(list);
    }

    @Test
    public void addEntity(){
        Group entity = new Group();
        entity.setGroupName("123");
        entity.setSpeciality(groupDao.findEntityById(1).getSpeciality());

        Assert.assertTrue(groupDao.addEntity(entity) > 0);
    }

    @Test
    public void deleteEntity(){
        Group entity = new Group();
        entity.setGroupName("123");
        entity.setSpeciality(groupDao.findEntityById(1).getSpeciality());

        groupDao.addEntity(entity);
        groupDao.deleteEntity(entity);
    }

    @Test
    public void saveOrUpdateEntity(){
        //new entity
        Group entity = new Group();
        entity.setGroupName("setGroupName 1");
        entity.setSpeciality(groupDao.findEntityById(1).getSpeciality());
        //add entity
        groupDao.addEntity(entity);
        //edit entity
        entity.setGroupName("setGroupName 2");
        entity.setSpeciality(new Speciality());

        groupDao.saveOrUpdateEntity(entity);
    }
}
