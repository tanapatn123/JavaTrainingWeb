package th.co.inet.training.api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public class TestGetAPI {
	
	public static void main(String[] args) {
		
		String mockupUsername = "testusername";
		String mockupPassword = "testpassword";
		
		HttpGetAPI getApi = new HttpGetAPI();
		try {
			String responseGetAPI = getApi.getRequest(mockupUsername, mockupPassword);
			System.out.println(responseGetAPI);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
