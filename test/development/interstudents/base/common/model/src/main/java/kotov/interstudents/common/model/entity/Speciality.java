package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity
@Table(name = "speciality")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Speciality extends AbstractEntity{

    @Id
    @GenericGenerator(name = "specialityGen", strategy = "increment")
    @GeneratedValue(generator = "specialityGen")
    @Column(name = "speciality_id")
    private Integer id;

    @Column(name = "speciality_name")
    private String specialityName;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

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
