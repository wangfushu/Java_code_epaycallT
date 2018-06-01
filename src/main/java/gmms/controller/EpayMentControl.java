package gmms.controller;

import gmms.domain.AjaxResponseBodyFactory;
import gmms.domain.db.CallReminder;
import gmms.domain.db.Employee;
import gmms.domain.db.VmVehicle;
import gmms.domain.query.FeeKindQueryParam;
import gmms.domain.query.KindQueryParam;
import gmms.domain.query.VmVehicleQueryParam;
import gmms.domain.vo.ReportVo;
import gmms.domain.vo.VmVehicleFeeVo;
import gmms.service.EmployeeService;
import gmms.service.VmVehicleService;
import gmms.util.*;
import gmms.util.CommonExceptions.InvalidException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yangjb on 2017/6/26. helloWorld
 */
@RequestMapping("/epayment")
@Controller
public class EpayMentControl {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VmVehicleService vmVehicleService;


    @Value("${image_path}")
    private String file_path;

    private Logger LOGGER = LoggerFactory.getLogger(EpayMentControl.class);

    @ResponseBody
    @RequestMapping(value = "queryvehicle", method = RequestMethod.POST)
    public String queryvehicle(VmVehicleQueryParam queryParam) {

/*        long startTime = System.currentTimeMillis();//运行开始时间*/
        List<VmVehicle> vmVehicles = vmVehicleService.listAll(queryParam);

        //for(VmVehicle v: vmVehicles){
        VmVehicleFeeVo vmVehicleFeeVo = new VmVehicleFeeVo();

        //小于7天不能开单，状态设置为0；
        List<CallReminder> callReminders = vmVehicleService.callReminderlistAll(queryParam);
        if (null != callReminders && callReminders.size() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (DateUtil.getDaySub(sdf.format(callReminders.get(0).getCheckTime()), DateUtils.getCurrTimeStr(2)) < 7) {
                vmVehicleFeeVo.setIsCallReminder(0L);//开单小于7天
            }
        }
/*************************************************************************************************************************************/
        //判断是否欠费以及贴卡
        if (vmVehicles.size() > 0) {
            vmVehicleFeeVo.setVehicleNo(vmVehicles.get(0).getvVehicleNo());
            vmVehicleFeeVo.setvPlateNo(vmVehicles.get(0).getvPlateNo());
            vmVehicleFeeVo.setvPlateColor(vmVehicles.get(0).getvPlateColor());
            vmVehicleFeeVo.setvKind(vmVehicles.get(0).getvKind());

            vmVehicleFeeVo.setvOutTagNo(vmVehicles.get(0).getvOutTagNo());

            // vmVehicleFeeVo.setvFeeState(v.getvFeeState());
            Calendar c = Calendar.getInstance();
            c.setTime(vmVehicles.get(0).getvFeeStartTime());
            c.add(Calendar.MONTH, 1);

            vmVehicleFeeVo.setvFeeStartTime(String.valueOf(c.get(Calendar.YEAR)));
            Integer tempMonth = c.get(Calendar.YEAR);
            if (tempMonth > 2005 && tempMonth <= 2025) {
                Integer stringIndex = tempMonth - 2005;
                String newvFeeState = vmVehicles.get(0).getvFeeState().substring(stringIndex, vmVehicles.get(0).getvFeeState().length());
                vmVehicleFeeVo.setvFeeState(newvFeeState);
            } else {
                vmVehicleFeeVo.setvFeeState(vmVehicles.get(0).getvFeeState());
            }
            if (null == vmVehicleFeeVo.getIsCallReminder())
                vmVehicleFeeVo.setIsCallReminder(1L);//欠费


            String tempfeeState = vmVehicles.get(0).getvFeeState();
            String yearFeeState = "";
            Integer oweFeeStartYear = null;
            c.setTime(vmVehicles.get(0).getvFeeStartTime());
            c.add(Calendar.MONTH, 1);
            Integer eStartTime = c.get(Calendar.YEAR);//车辆起始年份
            c.setTime(new Date());
            Integer tonowYear = c.get(Calendar.YEAR);//当前年份
            for (int i = 0; i < tempfeeState.length(); i++) {
                yearFeeState = tempfeeState.substring(tempfeeState.length() - (i + 1), tempfeeState.length() - i);
                if (yearFeeState.equals("0")) {

                } else {
                    //System.out.println(i);
                    oweFeeStartYear = 2024 - i + 1;
                    if (oweFeeStartYear < eStartTime) {
                        oweFeeStartYear = eStartTime;
                        if (tonowYear - oweFeeStartYear <= 0 || oweFeeStartYear < eStartTime) {
                            vmVehicleFeeVo.setIsCallReminder(2L);//无欠缴行为
                        }
                    } else {
                        if (tonowYear - oweFeeStartYear <= 0 || oweFeeStartYear < eStartTime) {
                            vmVehicleFeeVo.setIsCallReminder(2L);//无欠缴行为
                        }
                    }
                    break;
                }
                //System.out.println(yearFeeState);
            }
            if (null == oweFeeStartYear) {

                if (eStartTime > 2005) {
                    oweFeeStartYear = eStartTime;
                } else {
                    oweFeeStartYear = 2005;
                }
                if (tonowYear - oweFeeStartYear <= 0 || oweFeeStartYear < eStartTime) {
                    vmVehicleFeeVo.setIsCallReminder(2L);//无欠缴行为
                }
            }

            if (null == vmVehicles.get(0).getvOutTagNo() || "".equals(vmVehicles.get(0).getvOutTagNo())) {
                if (null == vmVehicleFeeVo.getIsCallReminder()) {
                    if (!vmVehicleFeeVo.getIsCallReminder().equals(1L)) {
                        vmVehicleFeeVo.setIsCallReminder(3L);//未贴卡
                    }
                }
            }
        } else {
            if (null == vmVehicleFeeVo.getIsCallReminder())
                vmVehicleFeeVo.setIsCallReminder(4L);//无注册信息
        }

/*        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");*/
        return JsonMapper.nonEmptyMapper().toJson(vmVehicleFeeVo);
    }

    @ResponseBody
    @RequestMapping(value = "querycallReminders", method = RequestMethod.POST)
    public String querycallReminders(VmVehicleQueryParam queryParam, @RequestParam(required = false, defaultValue = "1") int pageNo, @RequestParam(required = false, defaultValue = "5") int pageSize) {
       // long startTime = System.currentTimeMillis();//运行开始时间
        Page<CallReminder> callReminders = vmVehicleService.callReminderlistAll(queryParam, pageNo, pageSize);
        // System.out.println(" "+callReminders.getSize()+" "+ callReminders.getTotalPages()+" "+callReminders.getNumber()+" "+callReminders.getTotalElements()+" "+callReminders.getNumberOfElements());
       // long endTime = System.currentTimeMillis(); //获取结束时间

      //  System.out.println("call程序运行时间： " + (endTime - startTime) + "ms");
        return JsonMapper.nonEmptyMapper().toJson(callReminders);
    }


   /* @ResponseBody
    @RequestMapping(value = "/addecall", method = RequestMethod.POST)
    public String releaseHouse(@Valid CallReminderForm callReminderForm) {
        //添加修改催缴单
        if (callReminderForm.getId() != null) {

        } else {
            vmVehicleService.saveCallReminder(callReminderForm);
        }
        return AjaxResponseBodyFactory.createSuccessBody(true, "add success");
    }
*/

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String saveorupdateCallReminder(@RequestParam(value = "file", required = false) MultipartFile file,
                                           HttpServletRequest request) throws Exception {

        // Long eid; String vehicleNo;
        Long eId = Long.valueOf(request.getParameter("eId"));
        String vehicleNo = request.getParameter("vehicleNo");
        String oweStartYear = request.getParameter("oweStartYear");
        String oweOddNumber = request.getParameter("oweOddNumber");
        Date checkTime = DateUtil.fromDateStringToDate(request.getParameter("checkTime"));

        String path = "";
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            //String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = file.getContentType();
            //获得文件后缀名称
            String fileName = file.getOriginalFilename();

            //String imageName=contentType.substring(contentType.indexOf("/")+1);
            String imageName = fileName.substring(fileName.indexOf(".") + 1);
            path = "D:/essiImgAndVideoPlay/uaAerial/" + oweOddNumber + imageName;
            file.transferTo(new File(path));
        }
        System.out.println(path);
        //vmVehicleService.saveCallReminder(eId, vehicleNo,oweOddNumber,oweStartYear,checkTime,path);

        return AjaxResponseBodyFactory.createSuccessBody(true, "add success");
    }


    @ResponseBody
    @RequestMapping(value = "/orderquery", method = RequestMethod.POST)
    public String orderquery(String vehicleNo, String eId) {
        VmVehicle vmVehicle = new VmVehicle();
        Employee employee = employeeService.findById(Long.valueOf(eId));
        String currDate = DateUtils.getCurrTimeStr(6);
        String predix="CallReminder.id";
        if (null != vehicleNo && !"".equals(vehicleNo)) {
            vmVehicle = vmVehicleService.findById(vehicleNo);
            String tempfeeState = vmVehicle.getvFeeState();
            String yearFeeState = "";
            Integer oweFeeStartYear = null;
            Calendar c = Calendar.getInstance();
            c.setTime(vmVehicle.getvFeeStartTime());
            c.add(Calendar.MONTH, 1);
            Integer eStartTime = c.get(Calendar.YEAR);//车辆起始年份
            c.setTime(new Date());
            Integer tonowYear = c.get(Calendar.YEAR);//当前年份
            for (int i = 0; i < tempfeeState.length(); i++) {
                yearFeeState = tempfeeState.substring(tempfeeState.length() - (i + 1), tempfeeState.length() - i);
                if (yearFeeState.equals("0")) {
                } else {
                    //System.out.println(i);
                    oweFeeStartYear = 2024 - i + 1;
                    break;
                }
                //System.out.println(yearFeeState);
            }
            if (null == oweFeeStartYear) {

                if (eStartTime > 2005) {
                    oweFeeStartYear = eStartTime;
                } else {
                    oweFeeStartYear = 2005;
                }
            } else {

                if (oweFeeStartYear < eStartTime) {
                    oweFeeStartYear = eStartTime;
                }
            }

            String id=employee.getSysPlaza().getPlaNo() + vmVehicleService.generate(currDate,predix);
            vmVehicle.setOweStartYear(String.valueOf(oweFeeStartYear));
            vmVehicle.setOweStartToYear(oweFeeStartYear + "-" + tonowYear);
            vmVehicle.setOweOddNumber(id);
            vmVehicle.setCheckTime(new Date());
        } else {
            String id=employee.getSysPlaza().getPlaNo() + vmVehicleService.generate(currDate,predix);
            vmVehicle.setOweOddNumber(id);
            vmVehicle.setCheckTime(new Date());
        }

        return JsonMapper.nonEmptyMapper().toJson(vmVehicle);
    }

    @ResponseBody
    @RequestMapping(value = "/addepay", method = RequestMethod.POST)
    private String fildUpload(@RequestParam(value = "file1", required = false) MultipartFile file1, @RequestParam(value = "file2", required = false) MultipartFile file2,
                              HttpServletRequest request) {
        try {
            // Long eid; String vehicleNo;
            Long eId = Long.valueOf(request.getParameter("eId"));
            String vehicleNo = request.getParameter("vehicleNo");
            String plateNo = request.getParameter("plateNo");
            String plateColor = request.getParameter("plateColor");
            Long vehicleType = Long.valueOf(request.getParameter("kind"));
            String oweStartYear = request.getParameter("oweStartYear");

            String oweOddNumber = request.getParameter("oweOddNumber");
            if(StringUtil.isEmpty(oweOddNumber)) {
                LOGGER.error("单号为空 /车牌 {} /车牌颜色 {}", StringUtil.isEmpty(plateNo)?" ":plateNo,StringUtil.isEmpty(plateColor)?" ":plateColor);
                throw new InvalidException("单号为空");
            }


            Date checkTime = DateUtil.fromDateStringToDate(request.getParameter("checkTime"));
            String imagePath = "";
            String path = "";
            List<MultipartFile> files = new ArrayList<MultipartFile>();
            if (!file1.isEmpty()) {
                files.add(file1);
            }
            if (!file2.isEmpty()) {
                files.add(file2);
            }

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    //生成uuid作为文件名称
                    //String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    //获得文件类型（可以判断如果不是图片，禁止上传）

                    String dateStr = DateUtils.getCurrDateStr(2);
                    String basePath = "";
                    for (String pathStr : dateStr.split("-")) {
                        basePath += pathStr + "/";
                    }
                    String plazaNo=oweOddNumber.substring(0,4)+"/";//网点文件夹
                    //图片存放路径
                    imagePath = file_path +plazaNo+ basePath;

                    String contentType = file.getContentType();
                    //获得文件后缀名称
                    String fileName = file.getOriginalFilename();

                    //String imageName=contentType.substring(contentType.indexOf("/")+1);
                    /*String imageName = fileName.substring(fileName.indexOf(".") + 1);*/
                    path = imagePath + oweOddNumber + fileName;
                    //imagePath = oweOddNumber + "." + imageName;
                    newFolder(imagePath);

                    file.transferTo(new File(path));

                }
                System.out.println(path);
                vmVehicleService.saveCallReminder(eId, vehicleNo, plateNo, plateColor, vehicleType, oweOddNumber, oweStartYear, checkTime, imagePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";


    }


    public static void newFolder(String folderPath) {
        try {
            File myFilePath = new File(folderPath);
            if (!myFilePath.exists()) {
                //创建多级文件夹
                myFilePath.mkdirs();
                System.out.println("创建文件夹路径：" + folderPath);
            }
        } catch (Exception e) {
            System.out.println("新建文件夹操作出错");
            e.printStackTrace();
        }
    }


    @ResponseBody
    @RequestMapping(value = "/getyearfees", method = RequestMethod.POST)
    public String GetYearFees(@Valid String vVehicleNo) {
        //添加修改催缴单

        return AjaxResponseBodyFactory.createSuccessBody(true, "add success");
    }

    @ResponseBody
    @RequestMapping(value = "/reports", method = RequestMethod.POST)
    public String statisticalReports(VmVehicleQueryParam vmVehicleQueryParam) {
        //添加修改催缴单
        //statisticalReports
        ReportVo reportVo = new ReportVo();
        if (null != vmVehicleQueryParam.getQueryDate()) {
            vmVehicleQueryParam.setQueryDate(DateUtil.getStartDate(vmVehicleQueryParam.getQueryDate()));
        } else {
            vmVehicleQueryParam.setQueryDate(DateUtil.getStartDate(new Date()));
        }
        List<CallReminder> callReminders = vmVehicleService.callReminderlistAll(vmVehicleQueryParam);//当日开单总数

        List<CallReminder> isFeeCallReminders = vmVehicleService.queryIsFeeCallReminder(vmVehicleQueryParam);//当月生效金额

        reportVo.setTotalCallRNum(callReminders.size());

        List<CallReminder> callRemindersIsFee = new ArrayList<CallReminder>();
        Double totalFee = 0d;
        for (CallReminder callReminder : isFeeCallReminders) {
            if (callReminder.getIsFee().equals(1L)) {
                callRemindersIsFee.add(callReminder);//已经缴费列表
                if (null != callReminder.getIsFee()) {
                    totalFee += callReminder.getFee();//已经缴费的总金额
                }
            }
        }
        reportVo.setNumByKinds(setKindQueryParameter(callReminders));
        reportVo.setFeeNumByKinds(setFeeKindQueryParameter(callRemindersIsFee));
        reportVo.setTotalFee(totalFee);
        reportVo.setTotalFeeCallRNum(callRemindersIsFee.size());
/*        vmVehicleQueryParam.setIsFee(1L);
        List<CallReminder> callReminders1=vmVehicleService.callReminderlistAll(vmVehicleQueryParam);//生效单数
        reportVo.setTotalFeeCallRNum(callReminders1.size());
        reportVo.setTotalFee(vmVehicleService.queryTotalFee(vmVehicleQueryParam.geteId(),DateUtil.getStartDate(new Date())));//生效总金额

        List<KindQueryParam> kindQueryParams=vmVehicleService.NumqueryByKind(vmVehicleQueryParam.geteId(),DateUtil.getStartDate(new Date()));
        List<FeeKindQueryParam> feeKindQueryParams=vmVehicleService.FeequeryByKind(vmVehicleQueryParam.geteId(),DateUtil.getStartDate(new Date()));*/

        return JsonMapper.nonEmptyMapper().toJson(reportVo);
    }

    public List<KindQueryParam> setKindQueryParameter(List<CallReminder> objects) {
        List<KindQueryParam> list = new ArrayList<KindQueryParam>();
        List<CallReminder> oneKind = new ArrayList<CallReminder>();
        List<CallReminder> twoKind = new ArrayList<CallReminder>();

        for (CallReminder callReminder : objects) {
            if (callReminder.getVehicleType().equals(1L)) {
                oneKind.add(callReminder);
            }
            if (callReminder.getVehicleType().equals(2L)) {
                twoKind.add(callReminder);
            }
        }

        list.add(new KindQueryParam(1L, oneKind.size()));
        list.add(new KindQueryParam(2L, twoKind.size()));
        return list;
    }

    public List<FeeKindQueryParam> setFeeKindQueryParameter(List<CallReminder> objects) {
        List<FeeKindQueryParam> list = new ArrayList<FeeKindQueryParam>();
        Double oneKind = 0d;
        Double twoKind = 0d;
        for (CallReminder callReminder : objects) {
            if (callReminder.getVehicleType().equals(1L)) {
                if (null != callReminder.getFee()) {
                    oneKind += callReminder.getFee();
                }
            }

            if (callReminder.getVehicleType().equals(2L)) {
                if (null != callReminder.getFee()) {
                    twoKind += callReminder.getFee();
                }
            }
        }

        list.add(new FeeKindQueryParam(1L, oneKind));
        list.add(new FeeKindQueryParam(2L, twoKind));
        return list;
    }


}
