package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "speciality")
@Table(name = "speciality")
public class Speciality extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "speciality_id")
    Integer id;

    @Column(name = "speciality_name")
    String specialityName;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
