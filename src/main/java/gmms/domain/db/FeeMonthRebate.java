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
@Table(name = "FM_FEEMONTHREBATE")
@DynamicInsert
public class FeeMonthRebate {

    @Column(name = "FMR_VEHICLETYPE")
    private Integer vehicleType;

    @Id
    @Column(name = "FMR_MASTERTYPE")
    private Integer masterType;

    @Column(name = "FMR_MASTERNAME")
    private String masterName;

    @Column(name = "FMR_FEEMONTH")
    private Integer feeMonth;

    @Column(name = "FMR_REBATE")
    private Double rebate;

    @Column(name = "FMR_LIMITREBATEDAY")
    private Integer limitRebateDay;

    @Column(name = "FMR_REBATESTARTDAY")
    private Date rebateStartDay;

    @Column(name = "FMR_REBATEENDDAY")
    private Date rebateEndDay;

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getMasterType() {
        return masterType;
    }

    public void setMasterType(Integer masterType) {
        this.masterType = masterType;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public Integer getFeeMonth() {
        return feeMonth;
    }

    public void setFeeMonth(Integer feeMonth) {
        this.feeMonth = feeMonth;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public Integer getLimitRebateDay() {
        return limitRebateDay;
    }

    public void setLimitRebateDay(Integer limitRebateDay) {
        this.limitRebateDay = limitRebateDay;
    }

    public Date getRebateStartDay() {
        return rebateStartDay;
    }

    public void setRebateStartDay(Date rebateStartDay) {
        this.rebateStartDay = rebateStartDay;
    }

    public Date getRebateEndDay() {
        return rebateEndDay;
    }

    public void setRebateEndDay(Date rebateEndDay) {
        this.rebateEndDay = rebateEndDay;
    }
}
