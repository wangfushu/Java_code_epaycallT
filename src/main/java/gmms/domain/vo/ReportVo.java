package gmms.domain.vo;

import gmms.domain.query.FeeKindQueryParam;
import gmms.domain.query.KindQueryParam;

import java.util.List;
import java.util.Map;

/**
 * Created by wangfs on 2017-11-08 helloword.
 */
public class ReportVo {
    private Integer  totalCallRNum;//开单总数
    private Integer  totalFeeCallRNum;//生效单总数
    private Double totalFee;//生效金额
    private List<KindQueryParam> numByKinds;//开单总数各车型数量
    private List<FeeKindQueryParam> feeNumByKinds;//生效金额各车型

    public Integer getTotalCallRNum() {
        return totalCallRNum;
    }

    public void setTotalCallRNum(Integer totalCallRNum) {
        this.totalCallRNum = totalCallRNum;
    }

    public Integer getTotalFeeCallRNum() {
        return totalFeeCallRNum;
    }

    public void setTotalFeeCallRNum(Integer totalFeeCallRNum) {
        this.totalFeeCallRNum = totalFeeCallRNum;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public List<KindQueryParam> getNumByKinds() {
        return numByKinds;
    }

    public void setNumByKinds(List<KindQueryParam> numByKinds) {
        this.numByKinds = numByKinds;
    }

    public List<FeeKindQueryParam> getFeeNumByKinds() {
        return feeNumByKinds;
    }

    public void setFeeNumByKinds(List<FeeKindQueryParam> feeNumByKinds) {
        this.feeNumByKinds = feeNumByKinds;
    }
}
