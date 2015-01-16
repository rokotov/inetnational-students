package kotov.interstudents.common.model.entity;



import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "faculty")
@Table(name = "faculty")
public class Faculty extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "faculty_id")
    Integer id;

    @Column(name = "faculty_name")
    String facultyName;

    @OneToMany
    List<Speciality> specialityList;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Speciality> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        this.specialityList = specialityList;
    }
}
