package kotov.interstudents.common.model.entity;



import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity
@Table(name = "faculty")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Faculty extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "faculty_id")
    private Integer id;

    @Column(name = "faculty_name")
    private String facultyName;

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
}
