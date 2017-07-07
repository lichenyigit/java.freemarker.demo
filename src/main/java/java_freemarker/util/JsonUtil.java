package java_freemarker.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

@SuppressWarnings("all")
public class JsonUtil {
	Logger logger = LogManager.getLogger(getClass());
	
	public static String writeJson(Object object){
		try {
			return JSON.toJSONString(object);
		} catch (Exception e) {
			throw new JSONException(" writeJson failed. ", e);
		}
	}
	
	public static <T> T readJson(String str, T t){
		try {
			if(StringUtil.isNotBlank(str)){
				return (T) JSON.parseObject(str, t.getClass());
			}
		} catch (Exception e) {
			throw new JSONException(" readJson failed. ", e);
		}
		return null;
	}
	
	public static Map<String, Object> resquestParameter2Map(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String[]> url = request.getParameterMap();
		for (Entry<String, String[]> entry : url.entrySet()) {
			String key = entry.getKey();
			String[] valueArray = entry.getValue();
			String value;
			value = new String(valueArray[0]);
			map.put(key, value);
		}
		return map;
	}
	
}
