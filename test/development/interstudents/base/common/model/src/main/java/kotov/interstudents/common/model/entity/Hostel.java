package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by vkotov on 03.03.2015.
 */
@Entity()
@Table(name = "hostel")
public class Hostel extends AbstractEntity {

    @Id
    @GeneratedValue()
    @Column(name = "hostel_id")
    private Integer id;

    @Column(name = "hostel_name")
    private String hostelName;

    @Column(name = "address")
    private String address;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
