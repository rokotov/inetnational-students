package kotov.interstudents.common.model.entity;

import kotov.interstudents.common.model.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 02.03.2015.
 */
@Entity()
@Table(name = "personal_info")
public class PersonalInfo extends AbstractEntity {

    @Id
    @GeneratedValue()
    @Column(name = "personal_info_id")
    private Integer id;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "pasport_number")
    private String pasportNumber;

    @Column(name = "pasport_validity")
    private Date pasportValidity;

    @Column(name = "gender")
    private String gender;

    @Column(name = "visa_number")
    private String visaNumber;

    @Column(name = "visa_end_date")
    private Date visaEndDate;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "insurance_end_date")
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

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getPasportNumber() {
        return pasportNumber;
    }

    public Date getPasportValidity() {
        return pasportValidity;
    }

    public String getGender() {
        return gender;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public Date getVisaEndDate() {
        return visaEndDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }
}
