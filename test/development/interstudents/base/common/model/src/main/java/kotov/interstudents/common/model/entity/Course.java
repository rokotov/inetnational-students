package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "course")
@Table(name = "course")
public class Course extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "course_id")
    Integer id;

    @Column(name = "course_name")
    String courseName;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
