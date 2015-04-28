package kotov.interstudents.common.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.model.JsonStdDateSerializer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity
@Table(name = "student")
public class Student extends AbstractEntity{

    @Id
    @GeneratedValue()
    @Column(name = "student_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    @OneToOne
    @JoinColumn(name = "education_info_id")
    private EducationInfo educationInfo;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;

    @Column(name = "course")
    private String course;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "fio_latin")
    private String fioLatin;

    @Column(name = "registration_address")
    private String registrationAddress;

    @Column(name = "registration_end_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date registrationEndDate;

    @Column(name = "graduated")
    private String graduated;

    @Column(name = "receipt_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date receiptDate;

    @Column(name = "vacation")
    private String vacation;

    @Column(name = "vacation_start_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date vacationStartDate;

    @Column(name = "vacation_end_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date vacationEndDate;

    @Column(name = "line")
    private String line;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getFioLatin() {
        return fioLatin;
    }

    public void setFioLatin(String fioLatin) {
        this.fioLatin = fioLatin;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public EducationInfo getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(EducationInfo educationInfo) {
        this.educationInfo = educationInfo;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
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

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public Date getRegistrationEndDate() {
        return registrationEndDate;
    }

    public void setRegistrationEndDate(Date registrationEndDate) {
        this.registrationEndDate = registrationEndDate;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getVacation() {
        return vacation;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    public Date getVacationStartDate() {
        return vacationStartDate;
    }

    public void setVacationStartDate(Date vacationStartDate) {
        this.vacationStartDate = vacationStartDate;
    }

    public Date getVacationEndDate() {
        return vacationEndDate;
    }

    public void setVacationEndDate(Date vacationEndDate) {
        this.vacationEndDate = vacationEndDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
