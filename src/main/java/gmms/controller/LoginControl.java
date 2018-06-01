package gmms.controller;

import gmms.domain.db.Employee;
import gmms.domain.db.SysConfig;
import gmms.service.EmployeeService;
import gmms.util.CommonExceptions.InvalidException;
import gmms.util.JsonMapper;
import gmms.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yangjb on 2017/6/26. helloWorld
 */
@RequestMapping("/login")
@Controller
public class LoginControl {
	@Autowired
	private EmployeeService employeeService;

	private Logger LOGGER = LoggerFactory.getLogger(LoginControl.class);

	@ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String login(String userName, String password) {
		Employee employee =employeeService.findByName(userName);
		if (null == employee) {
			LOGGER.info("用户:"+userName+" 密码： "+password+"---------无此用户/n");
			return "6";
		} else {
			if(null!=employee.geteIsInspector()&&employee.geteIsInspector().equals(1L)){
			if("true".equals((employee.geteUserNo().equals(userName) && employee.getCjdUserPassWord().endsWith(MD5.GetMD5Code(password))) ? "true" : "false")){
				SysConfig sysConfig =employeeService.findSysConfig();
				employee.setSystemSuperPassWord(sysConfig.getCfConfigValue());
				return JsonMapper.nonEmptyMapper().toJson(employee);
			}else{
				LOGGER.info("用户:"+userName+" 密码： "+password+"---------密码错误/n");
				return "2";
			}
			}else{
				LOGGER.info("用户:"+userName+" 密码： "+password+"---------无权限/n");
				return "3";
			}
		}
    }


	@ResponseBody
	@RequestMapping(value = "changePassWord", method = RequestMethod.POST)
	public String changePassWord(Long eId, String oldpassword,String newpassword){
		try {
			this.employeeService.changePassword(eId, oldpassword, newpassword);
			return "success";
		} catch (NumberFormatException e) {
			return "error";
		} catch (InvalidException e) {
			return e.getMessage();
		}
	}

	@ResponseBody
	@RequestMapping(value = "/superPassword")
	public String superPassword(String password) {

		SysConfig sysConfig =employeeService.findSysConfig();
		if (null == sysConfig) {
			return "false";
		} else {
			if(sysConfig.getCfConfigValue().equals(password))	{
				return "true";
			}	else{
				return "false";
			}
		}
	}


}
