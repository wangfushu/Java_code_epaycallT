package gmms.domain.query;

import java.util.Date;

/**
 * Created by wangfs on 2017/7/2. helloWorld
 */
public class VmVehicleQueryParam {
    private String plateNo;
    private String plateColor;
    private Long kind;

    private Long eId;//员工ID
    private Long isFee;
    private Date queryDate;//查询开单起始日期


    public Long getIsFee() {
        return isFee;
    }

    public void setIsFee(Long isFee) {
        this.isFee = isFee;
    }

    public Date getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(Date queryDate) {
        this.queryDate = queryDate;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
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

    public Long getKind() {
        return kind;
    }

    public void setKind(Long kind) {
        this.kind = kind;
    }
    /* private String vPlateNo;
    private String vPlateColor;
    private String vKind;

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

    public String getvKind() {
        return vKind;
    }

    public void setvKind(String vKind) {
        this.vKind = vKind;
    }*/
}
