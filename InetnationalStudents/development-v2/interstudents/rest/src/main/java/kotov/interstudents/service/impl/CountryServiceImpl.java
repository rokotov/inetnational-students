package kotov.interstudents.service.impl;

import kotov.interstudents.common.model.entity.Country;
import kotov.interstudents.common.service.impl.AbstractServiceImpl;
import kotov.interstudents.dao.CountryDao;
import kotov.interstudents.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vkotov on 16.01.2015.
 */
@Service
public class CountryServiceImpl extends AbstractServiceImpl<Country, CountryDao> implements CountryService {
    @Override
    @Autowired
    public void setDao(CountryDao dao) {
        this.dao = dao;
    }
}
