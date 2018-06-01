package gmms.domain.query;

import gmms.util.DateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Created by wangfs on 2017/7/2. helloWorld
 */
public class KindQueryParam {
	private Long kind;

	private Integer number;

	public Long getKind() {
		return kind;
	}

	public void setKind(Long kind) {
		this.kind = kind;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public KindQueryParam(Long kind, Integer number) {
		this.kind = kind;
		this.number = number;
	}
}
