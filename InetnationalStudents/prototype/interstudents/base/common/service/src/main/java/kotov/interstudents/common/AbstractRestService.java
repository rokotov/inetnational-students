package kotov.interstudents.common;

import com.artezio.artvacation.common.model.AbstractEntity;

import java.util.List;

/**
 * Created by vkotov on 18.12.2014.
 */

public interface AbstractRestService {

        AbstractEntity getEntityById(Integer id);

        List<? extends AbstractEntity> getAllEntities();
}

