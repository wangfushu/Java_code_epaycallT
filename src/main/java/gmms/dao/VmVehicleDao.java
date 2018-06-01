package gmms.dao;

import gmms.domain.db.Employee;
import gmms.domain.db.VmVehicle;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface VmVehicleDao extends BaseDao<VmVehicle, String> {
	VmVehicle findByVVehicleNo(String vVehicleNo);
}
