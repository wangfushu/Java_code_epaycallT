package gmms.domain.db;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "Call_Reminder")
@DynamicInsert
public class CallReminder {
	
	@Id
	@Column(name = "ID")
	private String id;

/*	@Column(name = "PLAZANO")
	private String plazaNo;*/

	@ManyToOne(targetEntity = SysPlaza.class)
	@JoinColumn(name = "PLAZANO", updatable = false)
	private  SysPlaza sysPlaza;
	
	@Column(name = "VEHICLENO")
	private String vehicleNo;
	
	@Column(name = "PLATENO")
	private String plateNo;
	
	@Column(name = "PLATECOLOR")
	private String plateColor;
	
	@Column(name = "VEHICLETYPE")
	private Long vehicleType;
	
	@Column(name = "STARTYEAR")
	private Long startYear;

	@Column(name = "USERID")
	private Long userID;
	
	@Column(name = "USERNO")
	private String userNo;
	
	@Column(name = "USERNAME")
	private String userName;

	
	@Column(name = "CHECKTIME")
	private Date checkTime;//开单时间
	
	@Column(name = "ISFEE")
	private Long isFee;//是否补缴  0：未缴费 1：已缴费
	
	@Column(name = "FEE")
	private Float fee;

	@Column(name = "FEETIME")
	private Date feeTime;
	
	@Column(name = "FEEPLAZANO")
	private String feePlazaNo;
	
	@Column(name = "FEEUSER")
	private String feeUser;
	
	@Column(name = "ENDYEAR")
	private Long endYear;

	@Column(name = "IMAGEPATH")
	private String imagePath;

	@Column(name = "ISCANCEL")
	private Long isCancel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Long isCancel) {
		this.isCancel = isCancel;
	}

	/*
	public String getPlazaNo() {
		return plazaNo;
	}

	public void setPlazaNo(String plazaNo) {
		this.plazaNo = plazaNo;
	}
*/

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	public Long getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Long vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getStartYear() {
		return startYear;
	}

	public void setStartYear(Long startYear) {
		this.startYear = startYear;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Long getIsFee() {
		return isFee;
	}

	public void setIsFee(Long isFee) {
		this.isFee = isFee;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Date getFeeTime() {
		return feeTime;
	}

	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}

	public String getFeePlazaNo() {
		return feePlazaNo;
	}

	public void setFeePlazaNo(String feePlazaNo) {
		this.feePlazaNo = feePlazaNo;
	}

	public String getFeeUser() {
		return feeUser;
	}

	public void setFeeUser(String feeUser) {
		this.feeUser = feeUser;
	}

	public Long getEndYear() {
		return endYear;
	}

	public void setEndYear(Long endYear) {
		this.endYear = endYear;
	}


	public SysPlaza getSysPlaza() {
		return sysPlaza;
	}

	public void setSysPlaza(SysPlaza sysPlaza) {
		this.sysPlaza = sysPlaza;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
