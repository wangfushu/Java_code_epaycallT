package gmms.service;

import com.google.common.collect.Lists;
import gmms.dao.TestUserDao;
import gmms.dao.util.DynamicSpecifications;
import gmms.dao.util.SearchFilter;
import gmms.domain.db.TestUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangfs on 2017/6/28. helloWorld
 */
@Service
public class TestUserService {
	@Autowired
	private TestUserDao testUserDao;

/*	@Autowired
	private UsersDao usersDao;*/

	// @Autowired
	// private UsersRoleDao usersRoleDao;

/*	public void saveUser(UsersForm usersForm) {
		Role role = roleDao.findById(usersForm.getRoleId());
		Preconditions.checkNotNull(role, "id={}对应的角色不存在", usersForm.getRoleId());
		Users user = DomainCopyUtil.map(usersForm, Users.class);
		user.setGmtCreate(new Date());
		user.setGmtModify(new Date());
		user.setLastLoginTime(DateUtil.parseDate("2000-01-01", "yyyy-MM-dd"));
		Users save = usersDao.save(user);

		save.setRoles(Lists.newArrayList(role));
	}
*/
	/*public void alterUser(UsersForm usersForm) {
		Role role = roleDao.findById(usersForm.getRoleId());
		Preconditions.checkNotNull(role, "id={}对应的角色不存在", usersForm.getRoleId());
		Users user = DomainCopyUtil.map(usersForm, Users.class);
		user.setGmtModify(new Date());
		Users save = usersDao.save(user);
		save.setRoles(Lists.newArrayList(role));
	}*/

	public TestUser findById(long id) {
		return testUserDao.findOne(id);
	}


	public TestUser findByName(String name) {
		return testUserDao.findByUserName(name);
	}


}
