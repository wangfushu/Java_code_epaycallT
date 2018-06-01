package gmms.dao;

import gmms.domain.db.TestUser;

/**
 * Created by Administrator on 2015/9/21.
 */
public interface TestUserDao extends BaseDao<TestUser, Long> {
	TestUser findByUserName(String userName);

	//Users findByTelphone(String telphone);
}
