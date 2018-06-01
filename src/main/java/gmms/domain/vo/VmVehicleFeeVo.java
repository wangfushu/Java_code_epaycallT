package gmms.domain.vo;

/**
 * Created by Administrator on 2017-07-31.
 */
public class VmVehicleFeeVo {
    private String vehicleNo;//编码
    private String vPlateNo;//车牌号码
    private String vPlateColor;//颜色
    private Long vKind;//车型

    private String vFeeState;//年费缴交状态
    private String vFeeStartTime;//开始时间

    private String vOutTagNo;

    private Long isCallReminder;//状态  0-开单日期小于7天  1-有欠费 2-无欠缴行为  3-未贴卡  4-无注册信息


    public String getvOutTagNo() {
        return vOutTagNo;
    }

    public void setvOutTagNo(String vOutTagNo) {
        this.vOutTagNo = vOutTagNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
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

    public Long getvKind() {
        return vKind;
    }

    public void setvKind(Long vKind) {
        this.vKind = vKind;
    }

    public String getvFeeState() {
        return vFeeState;
    }

    public void setvFeeState(String vFeeState) {
        this.vFeeState = vFeeState;
    }

    public String getvFeeStartTime() {
        return vFeeStartTime;
    }

    public void setvFeeStartTime(String vFeeStartTime) {
        this.vFeeStartTime = vFeeStartTime;
    }

    public Long getIsCallReminder() {
        return isCallReminder;
    }

    public void setIsCallReminder(Long isCallReminder) {
        this.isCallReminder = isCallReminder;
    }
}
