package gmms.domain.db;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Administrator on 2017-07-31.
 */

@Entity
@Table(name = "SYS_PLAZA")
@DynamicInsert
public class SysPlaza {

    @Id
    @Column(name = "PLA_NO")
    private String plaNo;

    @Column(name = "PLA_ORDERNO")
    private Long plaOrderNo;
    @Column(name = "PLA_NAME")
    private String plaName;
    @Column(name = "PLA_CASHBANK")
    private String plaCashBank;
    @Column(name = "PLA_POSBANK")
    private String plaPosBank;
    @Column(name = "PLA_REMARK")
    private String plaRemark;
    @Column(name = "PLA_ZIPCODE")
    private String plaZipCode;

    public String getPlaNo() {
        return plaNo;
    }

    public void setPlaNo(String plaNo) {
        this.plaNo = plaNo;
    }

    public Long getPlaOrderNo() {
        return plaOrderNo;
    }

    public void setPlaOrderNo(Long plaOrderNo) {
        this.plaOrderNo = plaOrderNo;
    }

    public String getPlaName() {
        return plaName;
    }

    public void setPlaName(String plaName) {
        this.plaName = plaName;
    }

    public String getPlaCashBank() {
        return plaCashBank;
    }

    public void setPlaCashBank(String plaCashBank) {
        this.plaCashBank = plaCashBank;
    }

    public String getPlaPosBank() {
        return plaPosBank;
    }

    public void setPlaPosBank(String plaPosBank) {
        this.plaPosBank = plaPosBank;
    }

    public String getPlaRemark() {
        return plaRemark;
    }

    public void setPlaRemark(String plaRemark) {
        this.plaRemark = plaRemark;
    }

    public String getPlaZipCode() {
        return plaZipCode;
    }

    public void setPlaZipCode(String plaZipCode) {
        this.plaZipCode = plaZipCode;
    }
/*   private String Pla_DataDirectory;
    private String Pla_BackupDirectory;
    private String Pla_ServerNo;
    private String Pla_ServerIp;
    private String Pla_DataBaseName;
    private String Pla_DataBaseUser;
    private String Pla_DataBasePassword;
    private String Pla_Transactor;
    private String Pla_Phone;
    private String Pla_Address;
    private String Pla_Fax;
    private String Pla_UserNo;
    private String Pla_UserName;
    private Date Pla_ModifyTime;
    private Long Pla_InUse;
    private Long Pla_MonitorId;
    private Long Pla_BillManagerId;
    private Long Pla_TagManagerId;
    private Long Pla_SystemManagerId;
    private Long Pla_UserId;
    private Long Pla_IsTollgate;*/

}
