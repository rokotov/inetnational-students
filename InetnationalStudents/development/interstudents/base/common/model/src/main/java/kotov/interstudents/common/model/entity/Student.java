package kotov.interstudents.common.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.model.JsonStdDateSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 16.01.2015.
 */
@Entity
@Table(name = "student")
public class Student extends AbstractEntity{

    @Id
    @GenericGenerator(name = "studentGen", strategy = "increment")
    @GeneratedValue(generator = "studentGen")
    @Column(name = "student_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    //////////////личная

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "hostel_id")
    private Hostel hostel;

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

    @Column(name = "birth_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "pasport_number")
    private String pasportNumber;

    @Column(name = "pasport_validity")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date pasportValidity;

    @Column(name = "gender")
    private String gender;

    @Column(name = "visa_number")
    private String visaNumber;

    @Column(name = "visa_end_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date visaEndDate;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "insurance_end_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date insuranceEndDate;

    //////////// образование

    @Column(name = "graduated")
    private String graduated;

    @Column(name = "graduated_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date graduatedDate;

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

    @Column(name = "incoming_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date incomingDate;

    @Column(name = "dismis_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date dismisDate;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "order_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date orderDate;

    @Column(name = "study_form")
    private String studyForm;

    @Column(name = "reason_dismis")
    private String reasonDismis;

    @Column(name = "income_type")
    private String incomeType;

    @Column(name = "inviting_part")
    private String invitingPart;

    @Column(name = "invite_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date inviteDate;

    @Column(name = "incoming_rb_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date incomingRbDate;

    @Column(name = "recovery")
    private String recovery;

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

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
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

    public String getPasportNumber() {
        return pasportNumber;
    }

    public void setPasportNumber(String pasportNumber) {
        this.pasportNumber = pasportNumber;
    }

    public Date getPasportValidity() {
        return pasportValidity;
    }

    public void setPasportValidity(Date pasportValidity) {
        this.pasportValidity = pasportValidity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public Date getVisaEndDate() {
        return visaEndDate;
    }

    public void setVisaEndDate(Date visaEndDate) {
        this.visaEndDate = visaEndDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(Date insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public Date getIncomingDate() {
        return incomingDate;
    }

    public void setIncomingDate(Date incomingDate) {
        this.incomingDate = incomingDate;
    }

    public Date getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(Date graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

    public Date getDismisDate() {
        return dismisDate;
    }

    public void setDismisDate(Date dismisDate) {
        this.dismisDate = dismisDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }

    public String getReasonDismis() {
        return reasonDismis;
    }

    public void setReasonDismis(String reasonDismis) {
        this.reasonDismis = reasonDismis;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getInvitingPart() {
        return invitingPart;
    }

    public void setInvitingPart(String invitingPart) {
        this.invitingPart = invitingPart;
    }

    public Date getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(Date inviteDate) {
        this.inviteDate = inviteDate;
    }

    public Date getIncomingRbDate() {
        return incomingRbDate;
    }

    public void setIncomingRbDate(Date incomingRbDate) {
        this.incomingRbDate = incomingRbDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }
}
