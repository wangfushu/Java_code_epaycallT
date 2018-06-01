package gmms.constants;

/**
 * Created by wangfs on 2017-09-05 helloword.
 */
public class ConfigConstants {
    public static String LastYearDelayRate = "LastYearDelayRate";
    public static String CurrYearDelayRate = "CurrYearDelayRate";

    private static String  appId = "201701220001";       //统一支付平台颁发给源系统的唯一标识，为应用标识字段
    private  static String secret = "xmrbi3967968@2017";      //
    private  static String version = "1.0";     //接口版本号(v0.1,v0.2)
    private  static String osType = "android";      //操作系统类型：ios，android，wp，web，weixin
    private  static String devType = "testcase";     //设备类型，即硬件类型
    private  static String devId = "testcase001";       //设备Id，标识
    private  static String timestamp = null;   //当前时间戳
    private  static String sign = null;        //认证码
    private  static String signType = "md5";    //加密类型，默认md5

}
