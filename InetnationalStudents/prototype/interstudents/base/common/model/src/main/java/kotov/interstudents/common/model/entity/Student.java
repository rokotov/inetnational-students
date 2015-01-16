package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity(name = "student")
@Table(name = "student")
public class Student extends AbstractEntity{

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Groups group;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "midle_name")
    String middleName;

    @Column(name = "fio_latin")
    String fioLatin;

    @Column(name = "study_form")
    String studyForm;

    @Column(name = "registration_address")
    String registrationAddress;

    @Column(name = "registration_deadline")
    Date registrationDeadline;

    @Column(name = "order_number")
    int orderNumber;

    @Column(name = "birth_date")
    Date birthDate;

    @Column(name = "birth_place")
    String birthPlace;

    @Column(name = "passport number")
    String passportNumber;

    @Column(name = "passport_validity")
    Date passportValidity;

    @Column(name = "graduated")
    String graduated;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFioLatin() {
        return fioLatin;
    }

    public void setFioLatin(String fioLatin) {
        this.fioLatin = fioLatin;
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public Date getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(Date registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Date getPassportValidity() {
        return passportValidity;
    }

    public void setPassportValidity(Date passportValidity) {
        this.passportValidity = passportValidity;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }
}
