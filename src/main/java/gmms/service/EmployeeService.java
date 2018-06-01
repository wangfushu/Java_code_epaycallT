package gmms.service;

import gmms.dao.EmployeeDao;
import gmms.dao.SysConfigDao;
import gmms.domain.db.Employee;
import gmms.domain.db.SysConfig;
import gmms.util.CommonExceptions.InvalidException;
import gmms.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

/**
 * Created by wangfs on 2017/6/28. helloWorld
 */
@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private SysConfigDao sysConfigDao;

	public Employee findById(long eId) {
		return employeeDao.findByEId(eId);
	}


	public Employee findByName(String userName){
		Employee employee=employeeDao.findByEUserNo(userName);
		return employee;
	}
	public void delete(long id) {
		employeeDao.delete(id);
	}

	public void changePassword(Long eId, String oldPassword,String newPassword) throws InvalidException {
		if (eId == null) {
			throw new InvalidException("用户ID不可为空！");
		}
		if (oldPassword == null || "".equals(oldPassword.trim())) {
			throw new InvalidException("原始密码不可为空！");
		}
		if (newPassword == null || "".equals(newPassword.trim())) {
			throw new InvalidException("新密码不可为空！");
		}
		Employee employee= findById(eId);
		//Base64.encode("81dc9bdb52d04dc20036dbd8313ed055".getBytes());
		if (!employee.getCjdUserPassWord().endsWith(MD5.GetMD5Code(oldPassword))) {
			throw new InvalidException("密码修改失败，旧密码不正确！");
		}
		employee.setCjdUserPassWord(MD5.GetMD5Code(newPassword));

		this.employeeDao.save(employee);
	}

	public SysConfig findSysConfig(){
		SysConfig sysConfig= this.sysConfigDao.findByCfPlazaNoAndCfConfigNameAndCfPCNo("0000","CJDAdminPassWord","00");
		return sysConfig;
	}

}
