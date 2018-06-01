package gmms.domain.db;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "SYS_EMPLOYEEJCD")
@DynamicInsert
public class Employee {
	private Long eId;
	private String eUserNo;
	private String eUserName;
	private Long eUserStatus;
	private byte[] ePhoto;
	private String ePhone;
	private String eAddress;
	private String eEMail;
	private String eDepartment;
	private String eOfficially;
	private String eSex;
	private Date eBirthDay;
	private String eEducational;
	private Date eGraduateDate;
	private Date eComeDate;
	private String eResume;
	private String eRemark;
	private String eUserPassWord;
	private String eRoleId;
	private SysPlaza sysPlaza;
	private Long eMonitorId;
	private Long eBillManagerId;
	private Long eTagManagerId;
	private Long eSystemManagerId;
	private Long eAttribution;

	private  String cjdUserPassWord;//催缴单密码
	private Long eIsInspector;//是否是稽查员判定   1--是稽查员；0--不是稽查员


	private String systemSuperPassWord;//机子的超级管理员密码

	@Id
	@Column(name = "E_ID")
	public Long geteId() {
		return eId;
	}
	public void seteId(Long eId) {
		this.eId = eId;
	}

	@Column(name = "E_USERNO")
	public String geteUserNo() {
		return eUserNo;
	}
	public void seteUserNo(String eUserNo) {
		this.eUserNo = eUserNo;
	}
	
	@Column(name = "E_USERNAME")
	public String geteUserName() {
		return eUserName;
	}
	public void seteUserName(String eUserName) {
		this.eUserName = eUserName;
	}
	
	@Column(name = "E_USERSTATUS")
	public Long geteUserStatus() {
		return eUserStatus;
	}
	public void seteUserStatus(Long eUserStatus) {
		this.eUserStatus = eUserStatus;
	}
	
	@Column(name = "E_PHOTO")
	public byte[] getePhoto() {
		return ePhoto;
	}
	public void setePhoto(byte[] ePhoto) {
		this.ePhoto = ePhoto;
	}
	
	@Column(name = "E_PHONE")
	public String getePhone() {
		return ePhone;
	}
	public void setePhone(String ePhone) {
		this.ePhone = ePhone;
	}
	
	@Column(name = "E_ADDRESS")
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	
	@Column(name = "E_EMAIL")
	public String geteEMail() {
		return eEMail;
	}
	public void seteEMail(String eEMail) {
		this.eEMail = eEMail;
	}
	
	@Column(name = "E_DEPARTMENT")
	public String geteDepartment() {
		return eDepartment;
	}
	public void seteDepartment(String eDepartment) {
		this.eDepartment = eDepartment;
	}
	
	@Column(name = "E_OFFICIALLY")
	public String geteOfficially() {
		return eOfficially;
	}
	public void seteOfficially(String eOfficially) {
		this.eOfficially = eOfficially;
	}
	
	@Column(name = "E_SEX")
	public String geteSex() {
		return eSex;
	}
	public void seteSex(String eSex) {
		this.eSex = eSex;
	}
	
	@Column(name = "E_BIRTHDAY")
	public Date geteBirthDay() {
		return eBirthDay;
	}
	public void seteBirthDay(Date eBirthDay) {
		this.eBirthDay = eBirthDay;
	}
	
	@Column(name = "E_EDUCATIONAL")
	public String geteEducational() {
		return eEducational;
	}
	public void seteEducational(String eEducational) {
		this.eEducational = eEducational;
	}
	
	@Column(name = "E_GRADUATEDATE")
	public Date geteGraduateDate() {
		return eGraduateDate;
	}
	public void seteGraduateDate(Date eGraduateDate) {
		this.eGraduateDate = eGraduateDate;
	}
	
	@Column(name = "E_COMEDATE")
	public Date geteComeDate() {
		return eComeDate;
	}
	public void seteComeDate(Date eComeDate) {
		this.eComeDate = eComeDate;
	}
	
	@Column(name = "E_RESUME")
	public String geteResume() {
		return eResume;
	}
	public void seteResume(String eResume) {
		this.eResume = eResume;
	}
	
	@Column(name = "E_REMARK")
	public String geteRemark() {
		return eRemark;
	}
	public void seteRemark(String eRemark) {
		this.eRemark = eRemark;
	}
	
	@Column(name = "E_USERPASSWORD")
	public String geteUserPassWord() {
		return eUserPassWord;
	}
	public void seteUserPassWord(String eUserPassWord) {
		this.eUserPassWord = eUserPassWord;
	}
	
	@Column(name = "E_ROLEID")
	public String geteRoleId() {
		return eRoleId;
	}
	public void seteRoleId(String eRoleId) {
		this.eRoleId = eRoleId;
	}



	/*@Column(name = "E_PLAZANO")*/
	@ManyToOne(targetEntity = SysPlaza.class)
	@JoinColumn(name = "E_PLAZANO", updatable = false)
	public SysPlaza getSysPlaza() {
		return sysPlaza;
	}

	public void setSysPlaza(SysPlaza sysPlaza) {
		this.sysPlaza = sysPlaza;
	}


	@Column(name = "E_MONITORID")
	public Long geteMonitorId() {
		return eMonitorId;
	}
	public void seteMonitorId(Long eMonitorId) {
		this.eMonitorId = eMonitorId;
	}
	
	@Column(name = "E_BILLMANAGERID")
	public Long geteBillManagerId() {
		return eBillManagerId;
	}
	public void seteBillManagerId(Long eBillManagerId) {
		this.eBillManagerId = eBillManagerId;
	}
	
	@Column(name = "E_TAGMANAGERID")
	public Long geteTagManagerId() {
		return eTagManagerId;
	}
	public void seteTagManagerId(Long eTagManagerId) {
		this.eTagManagerId = eTagManagerId;
	}
	
	@Column(name = "E_SYSTEMMANAGERID")
	public Long geteSystemManagerId() {
		return eSystemManagerId;
	}
	public void seteSystemManagerId(Long eSystemManagerId) {
		this.eSystemManagerId = eSystemManagerId;
	}
	
	@Column(name = "E_ATTRIBUTION")
	public Long geteAttribution() {
		return eAttribution;
	}
	public void seteAttribution(Long eAttribution) {
		this.eAttribution = eAttribution;
	}


	@Column(name = "CJD_USERPASSWORD")
	public String getCjdUserPassWord() {
		return cjdUserPassWord;
	}

	public void setCjdUserPassWord(String cjdUserPassWord) {
		this.cjdUserPassWord = cjdUserPassWord;
	}

	@Column(name = "E_ISINSPECTOR")
	public Long geteIsInspector() {
		return eIsInspector;
	}

	public void seteIsInspector(Long eIsInspector) {
		this.eIsInspector = eIsInspector;
	}

	@Transient
	public String getSystemSuperPassWord() {
		return systemSuperPassWord;
	}

	public void setSystemSuperPassWord(String systemSuperPassWord) {
		this.systemSuperPassWord = systemSuperPassWord;
	}
}
