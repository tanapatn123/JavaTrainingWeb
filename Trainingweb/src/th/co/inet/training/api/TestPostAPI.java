package th.co.inet.training.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.JsonObject;

public class TestPostAPI {

	public static void main(String[] args) {
		
		//--- Set Property JSON Object ---//
		JsonObject json = new JsonObject();
		json.addProperty("name", "Jirawat");
		json.addProperty("address", "BKK");
		json.addProperty("tel", "080-xxx-xxxx");
		
		String jsonStr = json.toString();
		String mockupToken = "jdkfljdskfn1=dkmlvkr";
	
		System.out.println("Test Json String format : " + jsonStr);
		
		HttpPostAPI getApi = new HttpPostAPI();
		
		try {
			
			String responseGetAPI = getApi.postRequest(jsonStr, mockupToken);
			System.out.println(responseGetAPI);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
