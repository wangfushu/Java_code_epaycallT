package gmms.dao;

import gmms.domain.db.FeeMonthRebate;
import gmms.domain.db.VmVehicle;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface FeeMonthRebateDao extends BaseDao<FeeMonthRebate, String> {
	FeeMonthRebate findByMasterType(Integer masterType);
	FeeMonthRebate findByLimitRebateDayAndMasterType(Integer limitRebateDay,Integer masterType);
}
