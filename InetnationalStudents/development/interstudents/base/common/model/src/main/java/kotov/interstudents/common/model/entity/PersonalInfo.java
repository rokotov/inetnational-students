package kotov.interstudents.common.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.model.JsonStdDateSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 02.03.2015.
 */
@Entity
@Table(name = "personal_info")
public class PersonalInfo extends AbstractEntity {

    @Id
    @GenericGenerator(name = "studentGen", strategy = "increment")
    @GeneratedValue(generator = "studentGen")
    @Column(name = "personal_info_id")
    private Integer id;

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

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
