package gmms.service;

import com.google.common.collect.Lists;
import gmms.constants.ConfigConstants;
import gmms.constants.VYearFeeConstants;
import gmms.controller.EpayMentControl;
import gmms.dao.*;
import gmms.dao.util.DynamicSpecifications;
import gmms.dao.util.SearchFilter;
import gmms.domain.db.*;
import gmms.domain.form.YearFee;
import gmms.domain.query.FeeKindQueryParam;
import gmms.domain.query.KindQueryParam;
import gmms.domain.query.VmVehicleQueryParam;
import gmms.util.DateUtil;
import gmms.util.DateUtils;
import gmms.util.FeeUtils;
import gmms.util.StringUtil;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangfs on 2017/6/28. helloWorld
 */
@Service
public class VmVehicleService {

    private Logger LOGGER = LoggerFactory.getLogger(VmVehicleService.class);
    @Autowired
    private VmVehicleDao vmVehicleDao;
    @Autowired
    private CallReminderDao callReminderDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SysConfigDao sysConfigDao;
    @Autowired
    private FeeMonthRebateDao feeMonthRebateDao;
    @Autowired
    private SysFreeDateDao sysFreeDateDao;
    @Autowired
    private CrashLogDao crashLogDao;


    public VmVehicle findById(String vVehicleNo) {
        return vmVehicleDao.findByVVehicleNo(vVehicleNo);
    }

    public List<VmVehicle> listAll(VmVehicleQueryParam queryParam) {

        List<SearchFilter> filters = Lists.newArrayList();

        if (queryParam.getPlateNo() != null) {
            filters.add(new SearchFilter("vPlateNo", SearchFilter.Operator.EQ, queryParam.getPlateNo()));
        }
        if (queryParam.getPlateColor() != null) {
            filters.add(new SearchFilter("vPlateColor", SearchFilter.Operator.EQ, queryParam.getPlateColor()));

        }
        if (queryParam.getKind() != null) {
            filters.add(new SearchFilter("vKind", SearchFilter.Operator.EQ, queryParam.getKind()));
        }

        Specification<VmVehicle> spec = DynamicSpecifications.bySearchFilter(filters, VmVehicle.class);
        //PageRequest page = new PageRequest(pageNo - 1, pageSize, new Sort(Sort.Direction.DESC, "id"));
//        vmVehicleDao.findAll(spec, page);
        return vmVehicleDao.findAll(spec);
    }

    public Page<CallReminder> callReminderlistAll(VmVehicleQueryParam queryParam, int pageNo, int pageSize) {

        List<SearchFilter> filters = Lists.newArrayList();

        if (null != queryParam.getPlateNo()) {
            filters.add(new SearchFilter("plateNo", SearchFilter.Operator.EQ, queryParam.getPlateNo()));
        }
        if (null != queryParam.getPlateColor()) {
            filters.add(new SearchFilter("plateColor", SearchFilter.Operator.EQ, queryParam.getPlateColor()));

        }
        if (null != queryParam.getKind()) {
            filters.add(new SearchFilter("vehicleType", SearchFilter.Operator.EQ, queryParam.getKind()));
        }
   /*     if (org.apache.commons.lang.StringUtils.isNotBlank("")) {
            filters.add(new SearchFilter("title" + SearchFilter.OR_SEPARATOR + "agentName", SearchFilter.Operator.LIKEIGNORECASE, queryParam.getSearchKey()));
        }*/
        Specification<CallReminder> spec = DynamicSpecifications.bySearchFilter(filters, CallReminder.class);
        PageRequest page = new PageRequest(pageNo - 1, pageSize, new Sort(Sort.Direction.DESC, "checkTime"));
        Page<CallReminder> callReminders = callReminderDao.findAll(spec, page);
        return callReminders;
    }

    public List<CallReminder> callReminderlistAll(VmVehicleQueryParam queryParam) {

        List<SearchFilter> filters = Lists.newArrayList();

        if (null != queryParam.getPlateNo()) {
            filters.add(new SearchFilter("plateNo", SearchFilter.Operator.EQ, queryParam.getPlateNo()));
        }
        if (null != queryParam.getPlateColor()) {
            filters.add(new SearchFilter("plateColor", SearchFilter.Operator.EQ, queryParam.getPlateColor()));

        }
        if (null != queryParam.getKind()) {
            filters.add(new SearchFilter("vehicleType", SearchFilter.Operator.EQ, queryParam.getKind()));
        }
        if (null != queryParam.geteId()) {
            filters.add(new SearchFilter("userID", SearchFilter.Operator.EQ, queryParam.geteId()));
        }
        if (null != queryParam.getIsFee()) {
            //isFee
            filters.add(new SearchFilter("isFee", SearchFilter.Operator.EQ, queryParam.getIsFee()));
        }

        if (null != queryParam.getQueryDate()) {
            //System.out.println("1================"+DateUtils.getTimeStr(queryParam.getQueryDate(),2));
            filters.add(new SearchFilter("checkTime", SearchFilter.Operator.GTE, queryParam.getQueryDate()));//开单时间
            //System.out.println("2================"+DateUtils.getTimeStr(DateUtil.getEndDate(queryParam.getQueryDate()), 2));
             filters.add(new SearchFilter("checkTime", SearchFilter.Operator.LTE, DateUtil.getEndDate(queryParam.getQueryDate())));
        }
        /*if(null!=queryParam.getQueryDate()){

        }*/

        Specification<CallReminder> spec = DynamicSpecifications.bySearchFilter(filters, CallReminder.class);

        return callReminderDao.findAll(spec,new Sort(Sort.Direction.DESC, "checkTime"));
    }


    public List<CallReminder> queryIsFeeCallReminder(VmVehicleQueryParam queryParam) {
        // List<CallReminder> callReminders=callReminderDao.queryIsFeeCallReminder(queryParam.geteId(),DateUtils.getYearMonthStr(2));

        String startTime = "";
        String endTime = "";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Integer nowDayMonth = cal.get(Calendar.DAY_OF_MONTH);//当前日期
        Integer nowMonth = cal.get(Calendar.MONTH);//当前月份
        if (nowDayMonth > 25) {
            endTime = DateUtils.getTimeStr(DateUtil.getEndDate(cal.getTime()), 2);
            cal.set(Calendar.DAY_OF_MONTH, 26);
            startTime = DateUtils.getTimeStr(DateUtil.getStartDate(cal.getTime()), 2);

        } else {
            endTime = DateUtils.getTimeStr(DateUtil.getEndDate(cal.getTime()), 2);
            cal.add(Calendar.MONTH, -1);
            cal.set(Calendar.DAY_OF_MONTH, 26);
            startTime = DateUtils.getTimeStr(DateUtil.getStartDate(cal.getTime()), 2);
        }
        List<CallReminder> callReminders = callReminderDao.queryIsFeeCallReminderbyStartTimetoTime(queryParam.geteId(), startTime, endTime);

        return callReminders;
    }

    public void saveCallReminder(Long eid, String vehicleNo, String plateNo, String plateColor, Long vehicleType, String oweOddNumber, String oweStartYear, Date checkTime, String imagePath) {
        //CallReminder callReminder = DomainCopyUtil.map(callReminderForm, CallReminder.class);
        LOGGER.info("用户ID {} / 车辆编号 {} / 车牌号 {} /车牌颜色  {} / 单号  {}  /开单时间 {}",eid,(StringUtil.isEmpty(vehicleNo)?"":vehicleNo),(StringUtil.isEmpty(plateNo)?"空白":plateNo),(StringUtil.isEmpty(plateColor)?"空白":plateColor),(StringUtil.isEmpty(oweOddNumber)? "空白单号" :oweOddNumber),DateUtils.getCurrTimeStr(2) );
        CallReminder callReminder = new CallReminder();
        //if(!StringUtil.isEmpty(oweOddNumber))
        callReminder.setId(oweOddNumber);
        Employee employee = employeeDao.findByEId(eid);
        callReminder.setUserNo(employee.geteUserNo());
        callReminder.setUserID(employee.geteId());
        callReminder.setUserName(employee.geteUserName());
        callReminder.setSysPlaza(employee.getSysPlaza());

        if (null != vehicleNo && !"".equals(vehicleNo)) {
            VmVehicle vmVehicle = vmVehicleDao.findOne(vehicleNo);
            callReminder.setVehicleNo(vehicleNo);
            callReminder.setPlateNo(vmVehicle.getvPlateNo());
            callReminder.setVehicleType(vmVehicle.getvKind());
            callReminder.setPlateColor(vmVehicle.getvPlateColor());
        } else {
            callReminder.setVehicleNo(null);
            callReminder.setPlateNo(plateNo);
            callReminder.setVehicleType(vehicleType);
            callReminder.setPlateColor(plateColor);
        }
        if (null != oweStartYear && !"".equals(oweStartYear)) {
            callReminder.setStartYear(Long.valueOf(oweStartYear));
        } else {
            callReminder.setStartYear(null);
        }


        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Integer tonowYear = cal.get(Calendar.YEAR);//当前年份
        callReminder.setEndYear(Long.valueOf(tonowYear - 1));


        callReminder.setCheckTime(checkTime);
        callReminder.setIsFee(0L);
        callReminder.setImagePath(imagePath);
        callReminder.setIsCancel(0L);
        List<CallReminder> callReminders1 = findCallReminderByVvehicle(plateNo, plateColor, vehicleType);
        for (CallReminder c : callReminders1) {
            c.setIsCancel(1L);
            callReminderDao.save(c);
        }

        CallReminder save = callReminderDao.save(callReminder);

    }


    public List<CallReminder> findCallReminderByVvehicle(String plateNo, String plateColor, Long vehicleType) {
        List<CallReminder> callReminders = this.callReminderDao.findByPlateNoAndPlateColorAndVehicleType(plateNo, plateColor, vehicleType);
        return callReminders;
    }

    public List<String> getMaxApplyNo(String currDate) {
        String temp = currDate + "%";
        List<String> list = this.callReminderDao.findAllNo(temp);
        return list;
    }

    public FeeMonthRebate findFeeMonthRebateByLimitRebateDayAndMasterType(Integer limitRebateDay, Integer masterType) {
        return feeMonthRebateDao.findByLimitRebateDayAndMasterType(limitRebateDay, masterType);
    }

    public SysConfig findSysConfig(String cfPlazaNo, String cfConfigName, String cfPCNo) {
        SysConfigPK pk = new SysConfigPK(cfPlazaNo, cfConfigName, cfPCNo);
        return sysConfigDao.findOne(pk);
    }

    public List<SysConfig> findSysConfigbycfPCNo(String cfPlazaNo, String cfPCNo) {
        List<SearchFilter> filters = Lists.newArrayList();

        if (cfPlazaNo != null) {
            filters.add(new SearchFilter("cfPlazaNo", SearchFilter.Operator.EQ, cfPlazaNo));
        }
        if (cfPCNo != null) {
            filters.add(new SearchFilter("cfPCNo", SearchFilter.Operator.EQ, cfPCNo));
        }
        Specification<SysConfig> spec = DynamicSpecifications.bySearchFilter(filters, SysConfig.class);
        return sysConfigDao.findAll(spec);
    }

    public Integer queryFreeDays(Integer feeYear) {
        return Integer.parseInt(String.valueOf(sysFreeDateDao.queryFreeDays(feeYear)));
    }

    public List<YearFee> GetYearFees(String vehicleNo) throws ParseException {
        Integer feeMonth = null;
        VmVehicle vmVehicle = findById(vehicleNo);
        if (vmVehicle == null) {
            return null;
        }
        FeeMonthRebate feeMonthRebate = findFeeMonthRebateByLimitRebateDayAndMasterType(1, vmVehicle.getvKind().intValue());
        if (feeMonthRebate != null) {
            feeMonth = feeMonthRebate.getFeeMonth();
        }
        Double lastYearDelayRate = 0d;
        Double currentYearDelayRate = 0d;
        SysConfig cfgLastYearDelayRate = findSysConfig(VYearFeeConstants.DefaultPlazaNo, ConfigConstants.LastYearDelayRate, VYearFeeConstants.DefaultComputerNo);
        if (cfgLastYearDelayRate != null) {
            lastYearDelayRate = Double.parseDouble(cfgLastYearDelayRate.getCfConfigValue());
        }
        SysConfig cfgCurrentYearDelayRate = findSysConfig(VYearFeeConstants.DefaultPlazaNo, ConfigConstants.CurrYearDelayRate, VYearFeeConstants.DefaultComputerNo);
        if (cfgCurrentYearDelayRate != null) {
            currentYearDelayRate = Double.parseDouble(cfgCurrentYearDelayRate.getCfConfigValue());
        }
        List<YearFee> yearFees = FeeUtils.CreateYearFeeList(vmVehicle.getvPlateNo(), vmVehicle.getvFeeState(), vmVehicle.getvFeeStartTime(), vmVehicle.getvRegisterTime(), Double.parseDouble(String.valueOf(vmVehicle.getvMonthFee())),
                lastYearDelayRate,
                currentYearDelayRate,
                feeMonth);
        if (vmVehicle.getvKind() == 1 &&
                vmVehicle.getvCapacity() <= 7) {
            List<YearFee> vehicleYearFees = new ArrayList<YearFee>();
            for (YearFee yearFee : yearFees) {
                int feeYear = yearFee.getYear();

                int freeDays = Integer.parseInt(String.valueOf(sysFreeDateDao.queryFreeDays(feeYear)));

                if (freeDays > 0 || feeYear <= VYearFeeConstants.FreeStartYear) {
                    yearFee.setFreeFee(Double.parseDouble(String.valueOf(-Math.round(freeDays * (vmVehicle.getvMonthFee() / VYearFeeConstants.YearTotalDays)))));
                    vehicleYearFees.add(yearFee);
                }
            }

            return vehicleYearFees;
        }

        return yearFees;
    }


    /**
     * 查询开单各车型数量
     *
     * @param eId
     * @param date
     * @return
     */
    public List<KindQueryParam> NumqueryByKind(Long eId, Date date) {
        List<KindQueryParam> kindQueryParams = this.callReminderDao.queryNumbyVehiclKind(eId, date);
        return kindQueryParams;
    }

    /**
     * 查询生效金额各车型的总金额
     *
     * @param eId
     * @param date
     * @return
     */
    public List<FeeKindQueryParam> FeequeryByKind(Long eId, Date date) {
        List<FeeKindQueryParam> feeKindQueryParams = this.callReminderDao.queryFeebyVehiclKind(eId, date);
        return feeKindQueryParams;
    }

    /**
     * 查询生效总金额
     *
     * @param eId
     * @param date
     * @return
     */
    public Double queryTotalFee(Long eId, Date date) {
        Double totalFee = this.callReminderDao.queryTotalFeeByEid(eId, date);
        return totalFee;
    }

    /**
     * 安卓机子打印日志
     * @param carshLogText
     */
    public void saveCrashLog(String carshLogText){
        CrashLog crashLog = new CrashLog();
        crashLog.setCrashText(carshLogText);
        crashLog.setCrashTime(new Date());
        this.crashLogDao.save(crashLog);
    }


    /*********************************************主键数据库操作*********************************************************************/

    private static final Map<String, IdPool> ID_MAP = new ConcurrentHashMap<String, IdPool>();
    private int poosize=3;

    public synchronized String generate( String serialNumber,String objString) throws HibernateException {

        // String dayStr= DateUtils.getCurrDateStr(1);
        String entityName = objString+serialNumber;
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("需要获取主键的实体名:[" + entityName + "]");
        }
        if (ID_MAP.get(entityName) == null) {
            initalize(entityName);
        }
        String id = serialNumber+ID_MAP.get(entityName).getNextId();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("线程:[" + Thread.currentThread().getName() + "] " +
                    "实体:[" + entityName + "] 生成的主键为:[" + id + "]");
        }
        return id;
    }
    /**
     * 初始化对象的主键
     *
     * @param entityName 对象名称
     */
    private void initalize(String entityName) {
        IdPool pool = new IdPool(entityName, poosize);
        ID_MAP.put(entityName, pool);
    }

/*********************************************************************************************************************/


}
