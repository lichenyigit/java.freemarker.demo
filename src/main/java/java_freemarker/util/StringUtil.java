package java_freemarker.util;

public class StringUtil {

	public static String setString(String str) {
		return setString(str, "");
	}

	public static String setString(String str, String defaultStr) {
		if (isNotBlank(str)) {
			return str;
		} else {
			return defaultStr;
		}
	}

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	public static boolean isNull(String str){
		if(str == null)
			return true;
		return false;
	}
	
	public static boolean isNotNull(String str){
		return !isNull(str);
	}
	
}
