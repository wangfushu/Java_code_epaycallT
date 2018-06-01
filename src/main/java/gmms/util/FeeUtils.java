package gmms.util;

import com.google.common.math.DoubleMath;
import gmms.constants.VYearFeeConstants;
import gmms.domain.form.StartAndEndMonthForm;
import gmms.domain.form.YearFee;
import org.apache.commons.lang3.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static gmms.util.DateUtils.daysBetween;

/**
 * Created by wangfs on 2017-09-04 helloword.
 */
public class FeeUtils {

        public static List<YearFee> CreateYearFeeList(String plateNo, String feeStateString, Date feeStartTime, Date registerTime, Double monthFee, Double lastYearDelayRate, Double currentYearDelayRate, Integer feeMonth)throws ParseException {
            List<YearFee> yearFees = new ArrayList<YearFee>();
            Integer firstFeeYear = org.apache.commons.lang3.StringUtils.indexOfAny(feeStateString,new String[] { "1", "2", "3", "4", "5", "6" });
            if (firstFeeYear == -1)
            {
                return null;
            }
            char[] feeState=feeStateString.toCharArray();

            for (int i = 0; i < feeState.length; i++)
            {
                //String  state = feeState.substring(feeState.length() - (i + 1), feeState.length() - i);
                char state = feeState[i];
                if (String.valueOf(state).equals("0") && i >= firstFeeYear)
                {
                     Integer feeYear = VYearFeeConstants.FeeStartYear + i;//feeStartYear=2005 固定值
                    //if (feeYear > DateTime.Now.Year) break;// 只缴交到当年


                    StartAndEndMonthForm startAndEndMonthForm=GetFeeStartAndEndMonth(plateNo, feeYear, new Date(), feeStartTime);

                    if (startAndEndMonthForm.getIsNeedFee())
                    {
                       //计算实收年费
                        Double fYearFeeTemp = Double.valueOf(Math.round(monthFee * (Double.valueOf(String.valueOf(startAndEndMonthForm.getEndMonth())) - Double.valueOf(String.valueOf(startAndEndMonthForm.getStartMonth())) + 1) / 12));
                        BigDecimal bfYearFee   =   new   BigDecimal(fYearFeeTemp);
                        //保留2位小数
                        Double   fYearFee   =   bfYearFee.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算应收年费
                        if (fYearFee > 0)
                        {
                            //计算实收滞纳金
                            Double fDelayFee = GetDelayPayment(feeYear, fYearFee, new Date(), registerTime, feeStartTime, lastYearDelayRate, currentYearDelayRate, feeMonth);

                            yearFees.add(new YearFee(feeYear, startAndEndMonthForm.getStartMonth(), startAndEndMonthForm.getEndMonth(), fYearFee, Math.abs(fDelayFee))
                            );
                        }
                    }
                }
            }
            return yearFees;
        }

    // 计算滞纳金
    private static Double GetDelayPayment(Integer aFeeYear, Double aFee,Date aFeeTime, Date aFeeRegTime,Date aFeeStartTime,Double lastYearDelayRate,Double currYearDelayRate, Integer feeMonth)throws ParseException {
        Integer wYear=null;
        Integer wMonth=null;
        Date limitFeeDay=null;

        Calendar limitFeeDay1 = Calendar.getInstance();


        Calendar caFeeTime = Calendar.getInstance();
        caFeeTime.setTime(aFeeTime);

        Calendar caFeeStartTime = Calendar.getInstance();
        caFeeStartTime.setTime(aFeeStartTime);

        Calendar caFeeRegTime = Calendar.getInstance();
        caFeeRegTime.setTime(aFeeRegTime);


        if (aFeeYear > caFeeTime.get(Calendar.YEAR))
        {
            return 0d; //收费时间早于应收年度，不收滞纳金
        }
        if (null != feeMonth){
            wMonth = feeMonth + 1;
            wYear = aFeeYear;
            if (wMonth > 12)
            {
                wMonth = wMonth - 12;
                wYear = wYear + 1;
            }
            /*************************************************************/

            limitFeeDay1.set(wYear,wMonth-1,1);
            limitFeeDay=limitFeeDay1.getTime();
            // System.out.println("**************************   "+DateUtil.formatDate(date.getTime(),"yyyy-MM-dd"));
            //limitFeeDay = new DateTime(wYear, wMonth, 1);


            if (aFeeYear == caFeeStartTime.get(Calendar.YEAR))
            {
                wYear = aFeeYear;
                wMonth = caFeeStartTime.get(Calendar.MONTH)+1;
                wMonth = wMonth + 2;
                if (wMonth > 12)
                {
                    wMonth = wMonth - 12;
                    wYear = wYear + 1;
                }
                /*************************************************************/
                Calendar limitFeeDay2 = Calendar.getInstance();
                limitFeeDay2.set(wYear,wMonth-1,1);
                //Date limitFeeDay2 = new Date(wYear, wMonth, 1);
                if (limitFeeDay1.compareTo(limitFeeDay2) <0 )
                {
                    limitFeeDay = limitFeeDay2.getTime();
                }
            }
        }else{
            wMonth = aFeeYear == caFeeStartTime.get(Calendar.YEAR) ? caFeeStartTime.get(Calendar.MONTH)+1 : caFeeRegTime.get(Calendar.MONTH)+1;
            if (caFeeStartTime.get(Calendar.YEAR) != aFeeYear)
            {
                wMonth = wMonth + 1;
            }
            else
            {
                wMonth = wMonth + 2; //当年年费下个月底前交
            }
            if (wMonth > 12)
            {
                wMonth = wMonth - 12;
                wYear = aFeeYear + 1;
            }
            else
            {
                wYear = aFeeYear;
            }
            //2005年度滞纳金统一从2006.1.1起算
            Calendar newlimitFeeDay= Calendar.getInstance();
            newlimitFeeDay.set(wYear,wMonth-1,1);
            Calendar startlimitFeeDay= Calendar.getInstance();
            startlimitFeeDay.set(2006, 0, 1);

            limitFeeDay = aFeeYear != 2005 ? newlimitFeeDay.getTime() : startlimitFeeDay.getTime();
        }

        Double result = caFeeTime.get(Calendar.YEAR) == aFeeYear ?
                MyTruncate(currYearDelayRate / 1000 * aFee *   MyTruncate(daysBetween(aFeeTime, limitFeeDay) + 1)) :
                MyTruncate(lastYearDelayRate / 1000 * aFee *   MyTruncate(daysBetween(aFeeTime, limitFeeDay) + 1));
        if (result < 0)
        {
            result = 0d;
        }

        return result;
    }


    public static StartAndEndMonthForm GetFeeStartAndEndMonth(String aPlateNo,int aFeeYear, Date aFeeTime,Date aFeeStartTime)
    {
        Integer aStartMonth=0;Integer aEndMonth=0;
        StartAndEndMonthForm startAndEndMonthForm = new StartAndEndMonthForm();
/*
        aStartMonth = 0;
        aEndMonth = 0;
*/

        aPlateNo = aPlateNo.toUpperCase();

        Calendar caFeeTime = Calendar.getInstance();
        caFeeTime.setTime(aFeeTime);

        // 外地车交费
        if (aPlateNo.indexOf("闽D") == -1 && aPlateNo.indexOf("闽OD") == -1)
        {
            if (aFeeYear < caFeeTime.get(Calendar.YEAR)) //外地车不能交以往年度年费
            {
                startAndEndMonthForm.setStartMonth(aStartMonth);
                startAndEndMonthForm.setEndMonth(aEndMonth);
                startAndEndMonthForm.setIsNeedFee(false);
                return startAndEndMonthForm;
            }
            if (aFeeYear == caFeeTime.get(Calendar.YEAR)) //外地车当年从缴费月开始交费
            {
                aStartMonth = caFeeTime.get(Calendar.MONTH);
                aEndMonth = 12;
                startAndEndMonthForm.setStartMonth(aStartMonth);
                startAndEndMonthForm.setEndMonth(aEndMonth);
                startAndEndMonthForm.setIsNeedFee(true);
                return startAndEndMonthForm;
               // return true;
            }
            //外地车，次年后交整年年费
            aStartMonth = 1;
            aEndMonth = 12;
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(true);
            return startAndEndMonthForm;
           // return true;
        }


        Calendar caFeeStartTime = Calendar.getInstance();
        caFeeStartTime.setTime(aFeeStartTime);
        // 以下为本地车交费
        if (aFeeYear < caFeeStartTime.get(Calendar.YEAR))
        {
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(false);
            return startAndEndMonthForm;
           // return false; //交费年度早于年费开始日期的年度，不需交费
        }
        if (aFeeYear < 2005)
        {
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(false);
            return startAndEndMonthForm;
           // return false; //2005年前不需交年费
        }
        if (aFeeYear == caFeeStartTime.get(Calendar.YEAR) && caFeeStartTime.get(Calendar.MONTH) == 12)
        {
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(false);
            return startAndEndMonthForm;
            //return false; //12月份购车,当年不需交年费
        }

        if (aFeeYear == 2005)
        {
            //2005年9月份前购车，需交2005年9到12月份年费
            if (caFeeStartTime.get(Calendar.YEAR) < 2005 || (caFeeStartTime.get(Calendar.YEAR) == 2005 || caFeeStartTime.get(Calendar.MONTH) < 9))
            {
                aStartMonth = 9;
                aEndMonth = 12;
                startAndEndMonthForm.setStartMonth(aStartMonth);
                startAndEndMonthForm.setEndMonth(aEndMonth);
                startAndEndMonthForm.setIsNeedFee(true);
                return startAndEndMonthForm;
               // return true;
            }
            //2005年9-->12月份购车，从购车后第二个月开始交费
            aStartMonth = caFeeStartTime.get(Calendar.MONTH) + 1;
            aEndMonth = 12;
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(true);
            return startAndEndMonthForm;
           // return true;
        }

        //购车当年，从购车第2个开始交费，交到12月份
        if (aFeeYear == caFeeStartTime.get(Calendar.YEAR))
        {
            aStartMonth = caFeeStartTime.get(Calendar.MONTH) + 1;
            aEndMonth = 12;
            startAndEndMonthForm.setStartMonth(aStartMonth);
            startAndEndMonthForm.setEndMonth(aEndMonth);
            startAndEndMonthForm.setIsNeedFee(true);
            return startAndEndMonthForm;
           // return true;
        }

        //购车次年开始，需交整年年费
        aStartMonth = 1;
        aEndMonth = 12;
        startAndEndMonthForm.setStartMonth(aStartMonth);
        startAndEndMonthForm.setEndMonth(aEndMonth);
        startAndEndMonthForm.setIsNeedFee(true);
        return startAndEndMonthForm;
        //return true;
    }





    private static Double MyTruncate(Double value)
    {
        if(value < 0)
        {
            return Math.ceil(value);
        }
        else
        {
            return Math.floor(value);
        }
    }
}
