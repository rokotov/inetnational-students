package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity()
@Table(name = "groupe")
public class Group extends AbstractEntity{

    @Id
    @GenericGenerator(name = "groupGen", strategy = "increment")
    @GeneratedValue(generator = "groupGen")
    @Column(name = "group_id")
    private Integer id;

    @Column(name = "group_name")
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
