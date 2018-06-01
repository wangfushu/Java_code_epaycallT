package gmms.controller;

import gmms.service.VmVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yangjb on 2017/6/26. helloWorld
 */
@RequestMapping("/auditing")
@Controller
public class TestControl {
	@Autowired
	private VmVehicleService vmVehicleService;
	public String test(String username, String password) {
		return "login success";
	}

	@RequestMapping(value = "saveLog",method = RequestMethod.POST)
	public void saveLog(String crashText){
		vmVehicleService.saveCrashLog(crashText);
	}
}
