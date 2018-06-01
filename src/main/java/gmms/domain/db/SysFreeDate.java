package gmms.domain.db;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by wangfs on 2017-09-05 helloword.
 */

@Entity
@Table(name = "SYS_FREEDATE")
@DynamicInsert
public class SysFreeDate {

    @Id
    @Column(name = "FREEDATE")
    private Date freeDate;


    @Column(name = "FREEYEAR")
    private Integer freeYear;

    @Column(name = "USERID")
    private Integer userId;

    @Column(name = "USERNO")
    private String userNo;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "MODIFYTIME")
    private Date modifyTime;

    public Date getFreeDate() {
        return freeDate;
    }

    public void setFreeDate(Date freeDate) {
        this.freeDate = freeDate;
    }

    public Integer getFreeYear() {
        return freeYear;
    }

    public void setFreeYear(Integer freeYear) {
        this.freeYear = freeYear;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
