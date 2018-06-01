package gmms.domain.db;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "Vm_Vehicle")
@DynamicInsert
public class VmVehicle {

	@Id
	@Column(name = "V_VEHICLENO")
	private String vVehicleNo;

	@Column(name = "V_PLATENO")
	private String vPlateNo;


	@Column(name = "V_PLATECOLOR")
	private String vPlateColor;


	@Column(name = "V_VEHICLEKINDNO")
	private String vVehicleKindNo;
	
	@Column(name = "V_KIND")
	private Long vKind;
	
	@Column(name = "V_MODECODE")
	private Long vModeCode;
	
	@Column(name = "V_CAPACITY")
	private Float vCapacity;
	
	@Column(name = "V_CALCCAPACITY")
	private Float vCalcCapacity;
	
	@Column(name = "V_REMARK")
	private String vRemark;
	
	@Column(name = "V_TAGNO")
	private String vTagNo;
	
	@Column(name = "V_OUTTAGNO")
	private String vOutTagNo;
	
	@Column(name = "V_TAGTYPE")
	private Long vTagType;
	
	@Column(name = "V_TAGDATE")
	private Date vTagDate;
	
	@Column(name = "V_UPDATESIGN")
	private Long vUpdateSign;
	
	@Column(name = "V_CALCMONTHFEE")
	private Float vCalcMonthFee;
	
	@Column(name = "V_MONTHFEE")
	private Float vMonthFee;
	
	@Column(name = "V_FEESTATE")
	private String vFeeState;
	
	@Column(name = "V_MASTERTYPE")
	private Long vMasterType;

	@Column(name = "V_REGISTERTIME")
	private Date vRegisterTime;
	
	@Column(name = "V_FEESTARTTIME")
	private Date vFeeStartTime;
	
	@Column(name = "V_INPUTTIME")
	private Date vInputTime;
	
	@Column(name = "V_MODIFYTIME")
	private Date vModifyTime;
	
	@Column(name = "V_CUSTOMERNAME")
	private String vCustomerName;
	
	@Column(name = "V_CUSTOMERFAX")
	private String vCustomerFax;
	
	@Column(name = "V_TRANSANCTOR")
	private String vTransanctor;
	
	@Column(name = "V_TRANSACTORPHONE")
	private String vTransactorPhone;
	
	@Column(name = "V_TRANSACTORADDRESS")
	private String vTransactorAddress;
	
	@Column(name = "V_TRANSACTORZIP")
	private String vTransactorZip;
	
	@Column(name = "V_TRANSACTOREMAIL")
	private String vTransactorEmail;
	
	@Column(name = "V_IMAGEDIRECTORY")
	private String vImageDirectory;
	
	@Column(name = "V_VEHICLESOURCE")
	private Long vVehicleSource;
	
	@Column(name = "V_ISLOCAL")
	private Long vIsLocal;
	
	@Column(name = "V_ISCONSIGN")
	private Long vIsConsign;
	
	@Column(name = "V_BANKNO")
	private String vBankNo;
	
	@Column(name = "V_USERID")
	private Long vUserId;
	
	@Column(name = "V_USERNO")
	private String vUserNo;
	
	@Column(name = "V_USERNAME")
	private String vUserName;
	
	@Column(name = "V_IDCARD")
	private String vIDCard;
	
	@Column(name = "V_PASSSTATE")
	private Long vPassState;
	
	@Column(name = "V_TAGSOURCE")
	private Long vTagSource;
	
	@Column(name = "V_VBODYCOLOR")
	private Long vVBodyColor;
	
	@Column(name = "V_BRANK")
	private Long vBrank;
	
	@Column(name = "V_OFFSETFEE")
	private BigDecimal vOffsetFee;
	
	@Column(name = "V_CHANGETIME")
	private Date vChangeTime;
	
	@Column(name = "V_CALCEDITTIME")
	private Date vCalcEditTime;
	
	@Column(name = "V_CALCFEETIME")
	private Date vCalcFeeTime;

	@Transient
	private String oweStartYear;//欠费起始年度

	@Transient
	private String oweOddNumber;//流水单号

	@Transient
	private Date checkTime;//开单日期

	@Transient
	private String oweStartToYear;//欠费起始年度

	public String getvVehicleNo() {
		return vVehicleNo;
	}

	public void setvVehicleNo(String vVehicleNo) {
		this.vVehicleNo = vVehicleNo;
	}

	public String getvPlateNo() {
		return vPlateNo;
	}

	public void setvPlateNo(String vPlateNo) {
		this.vPlateNo = vPlateNo;
	}

	public String getvPlateColor() {
		return vPlateColor;
	}

	public void setvPlateColor(String vPlateColor) {
		this.vPlateColor = vPlateColor;
	}

	public String getvVehicleKindNo() {
		return vVehicleKindNo;
	}

	public void setvVehicleKindNo(String vVehicleKindNo) {
		this.vVehicleKindNo = vVehicleKindNo;
	}

	public Long getvKind() {
		return vKind;
	}

	public void setvKind(Long vKind) {
		this.vKind = vKind;
	}

	public Long getvModeCode() {
		return vModeCode;
	}

	public void setvModeCode(Long vModeCode) {
		this.vModeCode = vModeCode;
	}

	public Float getvCapacity() {
		return vCapacity;
	}

	public void setvCapacity(Float vCapacity) {
		this.vCapacity = vCapacity;
	}

	public Float getvCalcCapacity() {
		return vCalcCapacity;
	}

	public void setvCalcCapacity(Float vCalcCapacity) {
		this.vCalcCapacity = vCalcCapacity;
	}

	public String getvRemark() {
		return vRemark;
	}

	public void setvRemark(String vRemark) {
		this.vRemark = vRemark;
	}

	public String getvTagNo() {
		return vTagNo;
	}

	public void setvTagNo(String vTagNo) {
		this.vTagNo = vTagNo;
	}

	public String getvOutTagNo() {
		return vOutTagNo;
	}

	public void setvOutTagNo(String vOutTagNo) {
		this.vOutTagNo = vOutTagNo;
	}

	public Long getvTagType() {
		return vTagType;
	}

	public void setvTagType(Long vTagType) {
		this.vTagType = vTagType;
	}

	public Date getvTagDate() {
		return vTagDate;
	}

	public void setvTagDate(Date vTagDate) {
		this.vTagDate = vTagDate;
	}

	public Long getvUpdateSign() {
		return vUpdateSign;
	}

	public void setvUpdateSign(Long vUpdateSign) {
		this.vUpdateSign = vUpdateSign;
	}

	public Float getvCalcMonthFee() {
		return vCalcMonthFee;
	}

	public void setvCalcMonthFee(Float vCalcMonthFee) {
		this.vCalcMonthFee = vCalcMonthFee;
	}

	public Float getvMonthFee() {
		return vMonthFee;
	}

	public void setvMonthFee(Float vMonthFee) {
		this.vMonthFee = vMonthFee;
	}

	public String getvFeeState() {
		return vFeeState;
	}

	public void setvFeeState(String vFeeState) {
		this.vFeeState = vFeeState;
	}

	public Long getvMasterType() {
		return vMasterType;
	}

	public void setvMasterType(Long vMasterType) {
		this.vMasterType = vMasterType;
	}

	public Date getvRegisterTime() {
		return vRegisterTime;
	}

	public void setvRegisterTime(Date vRegisterTime) {
		this.vRegisterTime = vRegisterTime;
	}

	public Date getvFeeStartTime() {
		return vFeeStartTime;
	}

	public void setvFeeStartTime(Date vFeeStartTime) {
		this.vFeeStartTime = vFeeStartTime;
	}

	public Date getvInputTime() {
		return vInputTime;
	}

	public void setvInputTime(Date vInputTime) {
		this.vInputTime = vInputTime;
	}

	public Date getvModifyTime() {
		return vModifyTime;
	}

	public void setvModifyTime(Date vModifyTime) {
		this.vModifyTime = vModifyTime;
	}

	public String getvCustomerName() {
		return vCustomerName;
	}

	public void setvCustomerName(String vCustomerName) {
		this.vCustomerName = vCustomerName;
	}

	public String getvCustomerFax() {
		return vCustomerFax;
	}

	public void setvCustomerFax(String vCustomerFax) {
		this.vCustomerFax = vCustomerFax;
	}

	public String getvTransanctor() {
		return vTransanctor;
	}

	public void setvTransanctor(String vTransanctor) {
		this.vTransanctor = vTransanctor;
	}

	public String getvTransactorPhone() {
		return vTransactorPhone;
	}

	public void setvTransactorPhone(String vTransactorPhone) {
		this.vTransactorPhone = vTransactorPhone;
	}

	public String getvTransactorAddress() {
		return vTransactorAddress;
	}

	public void setvTransactorAddress(String vTransactorAddress) {
		this.vTransactorAddress = vTransactorAddress;
	}

	public String getvTransactorZip() {
		return vTransactorZip;
	}

	public void setvTransactorZip(String vTransactorZip) {
		this.vTransactorZip = vTransactorZip;
	}

	public String getvTransactorEmail() {
		return vTransactorEmail;
	}

	public void setvTransactorEmail(String vTransactorEmail) {
		this.vTransactorEmail = vTransactorEmail;
	}

	public String getvImageDirectory() {
		return vImageDirectory;
	}

	public void setvImageDirectory(String vImageDirectory) {
		this.vImageDirectory = vImageDirectory;
	}

	public Long getvVehicleSource() {
		return vVehicleSource;
	}

	public void setvVehicleSource(Long vVehicleSource) {
		this.vVehicleSource = vVehicleSource;
	}

	public Long getvIsLocal() {
		return vIsLocal;
	}

	public void setvIsLocal(Long vIsLocal) {
		this.vIsLocal = vIsLocal;
	}

	public Long getvIsConsign() {
		return vIsConsign;
	}

	public void setvIsConsign(Long vIsConsign) {
		this.vIsConsign = vIsConsign;
	}

	public String getvBankNo() {
		return vBankNo;
	}

	public void setvBankNo(String vBankNo) {
		this.vBankNo = vBankNo;
	}

	public Long getvUserId() {
		return vUserId;
	}

	public void setvUserId(Long vUserId) {
		this.vUserId = vUserId;
	}

	public String getvUserNo() {
		return vUserNo;
	}

	public void setvUserNo(String vUserNo) {
		this.vUserNo = vUserNo;
	}

	public String getvUserName() {
		return vUserName;
	}

	public void setvUserName(String vUserName) {
		this.vUserName = vUserName;
	}

	public String getvIDCard() {
		return vIDCard;
	}

	public void setvIDCard(String vIDCard) {
		this.vIDCard = vIDCard;
	}

	public Long getvPassState() {
		return vPassState;
	}

	public void setvPassState(Long vPassState) {
		this.vPassState = vPassState;
	}

	public Long getvTagSource() {
		return vTagSource;
	}

	public void setvTagSource(Long vTagSource) {
		this.vTagSource = vTagSource;
	}

	public Long getvVBodyColor() {
		return vVBodyColor;
	}

	public void setvVBodyColor(Long vVBodyColor) {
		this.vVBodyColor = vVBodyColor;
	}

	public Long getvBrank() {
		return vBrank;
	}

	public void setvBrank(Long vBrank) {
		this.vBrank = vBrank;
	}

	public BigDecimal getvOffsetFee() {
		return vOffsetFee;
	}

	public void setvOffsetFee(BigDecimal vOffsetFee) {
		this.vOffsetFee = vOffsetFee;
	}

	public Date getvChangeTime() {
		return vChangeTime;
	}

	public void setvChangeTime(Date vChangeTime) {
		this.vChangeTime = vChangeTime;
	}

	public Date getvCalcEditTime() {
		return vCalcEditTime;
	}

	public void setvCalcEditTime(Date vCalcEditTime) {
		this.vCalcEditTime = vCalcEditTime;
	}

	public Date getvCalcFeeTime() {
		return vCalcFeeTime;
	}

	public void setvCalcFeeTime(Date vCalcFeeTime) {
		this.vCalcFeeTime = vCalcFeeTime;
	}

	public String getOweStartYear() {
		return oweStartYear;
	}

	public void setOweStartYear(String oweStartYear) {
		this.oweStartYear = oweStartYear;
	}

	public String getOweOddNumber() {
		return oweOddNumber;
	}

	public void setOweOddNumber(String oweOddNumber) {
		this.oweOddNumber = oweOddNumber;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getOweStartToYear() {
		return oweStartToYear;
	}

	public void setOweStartToYear(String oweStartToYear) {
		this.oweStartToYear = oweStartToYear;
	}
}
