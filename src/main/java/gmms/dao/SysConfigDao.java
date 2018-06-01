package gmms.dao;

import gmms.domain.db.FeeMonthRebate;
import gmms.domain.db.SysConfig;
import gmms.domain.db.SysConfigPK;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface SysConfigDao extends BaseDao<SysConfig, SysConfigPK> {
	SysConfig findByCfPlazaNoAndCfConfigNameAndCfPCNo(String cfPlazaNo,String cfConfigName , String cfPCNo);
}
