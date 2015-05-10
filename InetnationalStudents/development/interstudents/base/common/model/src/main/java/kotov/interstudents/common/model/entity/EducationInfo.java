package kotov.interstudents.common.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kotov.interstudents.common.model.AbstractEntity;
import kotov.interstudents.common.model.JsonStdDateSerializer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vkotov on 03.03.2015.
 */
@Entity()
@Table(name = "education_info")
public class EducationInfo extends AbstractEntity {

    @Id
    @GenericGenerator(name = "studentGen", strategy = "increment")
    @GeneratedValue(generator = "studentGen")
    @Column(name = "education_info_id")
    private Integer id;

    @Column(name = "incoming_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date incomingDate;

    @Column(name = "graduated_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date graduatedDate;

    @Column(name = "dismis_date")
    @JsonSerialize(using = JsonStdDateSerializer.class)
    private Date dismisDate;

    @Column(name = "order_number")
    private String orderNumber;

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

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
