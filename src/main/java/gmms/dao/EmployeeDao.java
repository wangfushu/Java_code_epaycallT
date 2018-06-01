package gmms.dao;

import gmms.domain.db.Employee;
import gmms.domain.db.TestUser;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface EmployeeDao extends BaseDao<Employee, Long> {
	//Employee findByUserName(String userName);
	Employee findByEId(Long eId);
	Employee findByEUserNo(String eUserNo);
	//Users findByTelphone(String telphone);
}
