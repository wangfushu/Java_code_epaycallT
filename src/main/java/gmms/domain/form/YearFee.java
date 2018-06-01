package gmms.domain.form;

/**
 * Created by wangfs on 2017-09-04 helloword.
 */
public class YearFee {
    Integer year;
    Integer startMonth;
    Integer endMonth ;
    Double fee;
    Double delayPay;
    Double freeFee;

    public YearFee(Integer year, Integer startMonth, Integer endMonth, Double fee, Double delayPay) {
        this.year = year;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.fee = fee;
        this.delayPay = delayPay;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getDelayPay() {
        return delayPay;
    }

    public void setDelayPay(Double delayPay) {
        this.delayPay = delayPay;
    }

    public Double getFreeFee() {
        return freeFee;
    }

    public void setFreeFee(Double freeFee) {
        this.freeFee = freeFee;
    }
}
