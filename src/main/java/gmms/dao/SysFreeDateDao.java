package gmms.dao;

import gmms.domain.db.FeeMonthRebate;
import gmms.domain.db.SysFreeDate;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface SysFreeDateDao extends BaseDao<SysFreeDate, Date> {

	@Query(value = "select count(*) from SysFreeDate cr where freeYear = ?")
	Long queryFreeDays(Integer freeYear);
}
