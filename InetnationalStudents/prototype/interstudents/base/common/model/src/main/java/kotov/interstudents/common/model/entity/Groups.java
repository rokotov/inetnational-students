package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "groups")
@Table(name = "groups")
public class Groups extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    Integer id;

    @Column(name = "group_name")
    String groupName;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    Speciality speciality;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
