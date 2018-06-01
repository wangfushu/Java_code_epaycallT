package gmms.service;

import gmms.domain.db.CallReminder;
import gmms.domain.query.KindQueryParam;
import gmms.domain.query.VmVehicleQueryParam;
import gmms.util.DateUtil;
import gmms.util.DateUtils;
import gmms.util.NewDateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by wangfs on 2017/6/28. helloWorld
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@RunWith(SpringJUnit4ClassRunner.class)
public class UsersServiceTest {
/*	@Autowired
	private UsersService usersService;
	@Autowired
	private TestUserService testUserService;*/

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private VmVehicleService vmVehicleService;

/*	@Test
		 public void findById() throws Exception {
		TestUser byId = testUserService.findById(1);
		System.out.println("sss--------"+byId.getUserName());
		System.out.println("sss");
	}*/

	@Test
	public void findById() throws Exception {
/*		Employee byId = employeeService.findByName("admin");
		System.out.println("employee--------"+byId.geteUserName());
		System.out.println("employee");*/
	/*	VmVehicleQueryParam queryParam=new VmVehicleQueryParam();
		queryParam.setPlateNo("闽E16271");
		queryParam.setPlateColor("蓝");
		queryParam.setKind(1L);
		//List<VmVehicle> vmVehicles=vmVehicleService.listAll(queryParam);
		Page<CallReminder> callReminders=vmVehicleService.callReminderlistAll(queryParam,1,10);
		System.out.println(JsonMapper.nonEmptyMapper().toJson(callReminders));
		System.out.println("sssssssss");*/
/*
		CallReminderForm callReminderForm = new CallReminderForm();
		callReminderForm.setPlazaNo("0001");
		callReminderForm.setVehicleNo("000000005918");
		callReminderForm.setPlateNo("闽E16271");
		callReminderForm.setPlateColor("蓝");
		callReminderForm.setVehicleType(1L);
		callReminderForm.setUserID(String.valueOf(1L));
		callReminderForm.setUserNo("00");
		callReminderForm.setUserName("苏先达");
		callReminderForm.setStartYear(2014L);
		callReminderForm.setCheckTime(new Date());
		vmVehicleService.saveCallReminder(callReminderForm);

*/
		//vmVehicleService.saveCallReminder(15L,"000000005928","00012017081400001","2014",new Date(),"00012017081100004.png");
		//System.out.println("this is :"+vmVehicleService.saveCallReminder(17L, "000000005930"));
/*		List<String > str=vmVehicleService.getMaxApplyNo("20170807");
		System.out.println(str.get(0));*/

		//StartAndEndMonthForm startAndEndMonthForm=FeeUtils.GetFeeStartAndEndMonth("闽D37469", 2014, new Date(), DateUtil.fromDateStringToDate("2000-01-05 15:46:29.00"));
		//System.out.println("StartMonth  : "+startAndEndMonthForm.getStartMonth()+" EndMonth:  "+startAndEndMonthForm.getEndMonth()+" IsNeedFee: "+startAndEndMonthForm.getIsNeedFee());

/*		Calendar date = Calendar.getInstance();
		date.set(2016,10-1,1);
		System.out.println("**************************   "+DateUtil.formatDate(date.getTime(),"yyyy-MM-dd"));*/

	/*	FeeMonthRebate feeMonthRebate= vmVehicleService.findFeeMonthRebateByLimitRebateDayAndMasterType(1, 33);
		if(feeMonthRebate==null){
			System.out.println("**************************   null" );
		}else {
			System.out.println("**************************   " + feeMonthRebate.getMasterName() + "*************** " + feeMonthRebate.getFeeMonth());
		}*/
	/*	SysConfig sysConfig= vmVehicleService.findSysConfig("0000","LastYearDelayRate","00");
		if(sysConfig==null){
			System.out.println("**************************   null" );
		}else {
			System.out.println("**************************   " + sysConfig.getCfConfigDescription() + "*************** " + sysConfig.getCfConfigValue());
		}*/
/*		List<SysConfig> sysConfig =vmVehicleService.findSysConfigbycfPCNo("0000","00");
		System.out.println("**************************     "+sysConfig.size()+"**************************     "+sysConfig.get(0).getCfConfigDescription() );*/
/*		Integer a =vmVehicleService.queryFreeDays(2012);
		System.out.println("**************************     "+a );*/
		//余华宁车号00025320120119000528     00015220140130000009   20017120141215000200
	/*	List<YearFee> yearFees =vmVehicleService.GetYearFees("20017120141210000186");
		for(YearFee yearFee:yearFees){
			System.out.println("**************************     "+yearFees.size()+"  *****年份：    "+yearFee.getYear()+"  *****滞纳金：     "+yearFee.getDelayPay()+"  *****年费：    "+yearFee.getFee()+"  *****免费：   "+yearFee.getFreeFee() );
		}*/
/*
		List<KindQueryParam> kindQueryParams=this.vmVehicleService.NumqueryByKind(0L,DateUtil.getStartDate(NewDateUtil.fromDateStringToDate("2017-08-14 16:54:47.000")));
		System.out.println("==========================="+kindQueryParams.size());
*/
/*		SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
		if (DateUtil.getDaySub(sdf.format(DateUtil.fromDateStringToDate("2017-11-09 17:36:00")), DateUtils.getCurrTimeStr(2)) < 7) {
			System.out.println("小于7天");//开单小于7天
		}else{
			System.out.println("大于7天");
		}*/
		/*String abc="我很烦";
		char[] feeState=abc.toCharArray();
		for(int i=0;i<feeState.length;i++){
			System.out.println("__________________  "+feeState[i]);
		}*/
		/*VmVehicleQueryParam queryParam= new VmVehicleQueryParam();
		queryParam.seteId(0L);
		List<CallReminder> callReminders1= vmVehicleService.queryIsFeeCallReminder(queryParam);
		System.out.println("=========================: "+callReminders1.size());*/




	/*	String startTime= "";
		String endTime="";
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		Integer nowDayMonth = cal.get(Calendar.DAY_OF_MONTH);//当前日期
		Integer nowMonth=cal.get(Calendar.MONTH);//当前月份
		if(nowDayMonth> 25 ){
			endTime=DateUtils.getTimeStr(DateUtil.getEndDate(cal.getTime()),2);
			cal.set(Calendar.DAY_OF_MONTH,26);
			startTime=DateUtils.getTimeStr(DateUtil.getStartDate(cal.getTime()),2);

		}else{
			endTime=DateUtils.getTimeStr(DateUtil.getEndDate(cal.getTime()),2);
			cal.add(Calendar.MONTH, -1);
			cal.set(Calendar.DAY_OF_MONTH,26);
			startTime=DateUtils.getTimeStr(DateUtil.getStartDate(cal.getTime()),2);
		}

		System.out.println("=========================: "+startTime+ " ======================== "+endTime);

*/

		VmVehicleQueryParam vmVehicleQueryParam=new VmVehicleQueryParam();
		vmVehicleQueryParam.seteId(176L);
		List<CallReminder> callReminders= vmVehicleService.queryIsFeeCallReminder(vmVehicleQueryParam);
		System.out.println("=========================: "+callReminders.size()+ " ======================== ");

	}
}