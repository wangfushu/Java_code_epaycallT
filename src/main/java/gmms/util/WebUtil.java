package gmms.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/**
 * User: wangfs Date: 16-3-23
 */
public final class WebUtil {

	/**
	 * 向指定URL发送GET方法的请求
	 *
	 * @param url
	 *            发送请求的URL
	 * @param params
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static JSONObject sendGet(String url, Map<String, String> params) {

		String result = "";
		BufferedReader in = null;
		StringBuffer buffer = new StringBuffer();
		JSONObject jsonResult = null;
		try {
			if (params != null && params.size() > 0) {
				for (String key : params.keySet()) {

					buffer.append(key).append("=").append(URLEncoder.encode(params.get(key), "utf-8"));
					buffer.append("&");
				}
			}
			if (buffer.toString().length() > 0) {
				buffer.deleteCharAt(buffer.length() - 1);
			}

			System.out.println(" url 的参数 ： " + buffer);
			// String urlNameString = null;
			String urlNameString = url + "?" + buffer;
			// get请求返回结果
			System.out.println(" url 的参数 ： " + urlNameString);
			CloseableHttpClient client = HttpClients.createDefault();
			;
			// 发送get请求
			HttpGet request = new HttpGet(urlNameString);
			HttpResponse response = client.execute(request);

			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				/** 读取服务器返回过来的json字符串数据 **/

				String strResult = EntityUtils.toString(response.getEntity(), "UTF-8");
				// System.out.println("strResult = "+strResult);
				// URLDecoder.decode(response.getEntity(),"UTF-8");
				/** 把json字符串转换成json对象 **/
				jsonResult = JSONObject.fromObject(strResult);
				// 对url进行反编码，一般是服务器写的
				url = URLDecoder.decode(urlNameString, "UTF-8");
			} else {
				System.out.println("get请求提交失败:" + urlNameString);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// logger.error("get请求提交失败:" + urlNameString, e);
		}
		return jsonResult;

	}

	/**
	 * 发送Post请求
	 *
	 * @param url
	 *            请求地址
	 * @param jsonParam
	 *            请求参数
	 * @return 请求结果
	 * @throws java.io.IOException
	 */
	public static JSONObject postJson(String url, String jsonParam) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		JSONObject jsonResult = null;
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			HttpResponse result = httpClient.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					/** 把json字符串转换成json对象 **/
					jsonResult = JSONObject.fromObject(str);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}
}
