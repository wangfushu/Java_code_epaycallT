package gmms.domain.query;

/**
 * Created by wangfs on 2017/7/2. helloWorld
 */
public class FeeKindQueryParam {
	private Long kind;

	private Double fee;

	public Long getKind() {
		return kind;
	}

	public void setKind(Long kind) {
		this.kind = kind;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public FeeKindQueryParam(Long kind, Double fee) {
		this.kind = kind;
		this.fee = fee;
	}
}
