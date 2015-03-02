package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "country")
@Table(name = "country")
public class Country extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "country_id")
    Integer id;

    @Column(name = "country_name")
    String countryName;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
