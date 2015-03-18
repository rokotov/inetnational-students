package kotov.interstudents.test.rest;

import kotov.interstudents.common.model.entity.Faculty;
import kotov.interstudents.web.FacultyRestService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;

/**
 * Created by vkotov on 16.01.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/interstudents-dao-test-context.xml"})
@TransactionConfiguration(defaultRollback=true, transactionManager="kotov.interstudents.TransactionManager")
@Transactional
public class FacultyRestServiceTest {
    @Autowired
    FacultyRestService facultyRestService = new FacultyRestService();

    @Test
    public void getAllEntities() {
        Response response =  facultyRestService.getAllEntities();
        Assert.assertNotEquals(Response.Status.INTERNAL_SERVER_ERROR, response.getStatus());
    }

    @Test
    public void addEntity() {
        Faculty entity = new Faculty();
        entity.setFacultyName("name");
        Response response =  facultyRestService.addEntity(entity);
        Assert.assertNotEquals(Response.Status.INTERNAL_SERVER_ERROR, response.getStatus());
    }

    @Test
    public void getEntityById(){
        Response response =  facultyRestService.getEntityById(1);
        Assert.assertNotEquals(Response.Status.INTERNAL_SERVER_ERROR, response.getStatus());
    }
}
