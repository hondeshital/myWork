package excel.utils;

import io.restassured.path.json.JsonPath;

public class JsonPathUtil {
	
	public static String getRequestedKeyFromResponse (String responseBody,
			String key) {
		
		JsonPath jsonPath = new JsonPath(responseBody);
		return jsonPath.getString(key);
	}

}
