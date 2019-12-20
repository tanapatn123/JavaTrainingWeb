package th.co.inet.training.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpPostAPI {

	public String postRequest(String jsonStr, String token) throws ClientProtocolException, IOException {
		  
		  BufferedReader br = null;
		  String output;
		  StringBuilder responseBuilder = null;
		  String response = null;
		  URIBuilder uriBuilder;
		  HttpClient httpClient = HttpClientBuilder.create().build();	  
		  
		  try {
			  //----------------------- Set URL Post Method --------------------------//
			  uriBuilder = new URIBuilder("https://jsonplaceholder.typicode.com/todos/1");
			  
			  //-------------------- Set Method HTTP Get or Post ---------------------//
			  HttpPost postMethod = new HttpPost(uriBuilder.build()); 	
			  	 
			  //-------------------- Set Parameter to StringEntity ---------------------//
			  StringEntity params = new StringEntity(jsonStr);
			   
			  //------------------ Set Header and Body Post Method ------------------//
			  postMethod.addHeader("content-type", "application/json"); 
			  postMethod.addHeader("Authorization","bearer " + token);	   
			  postMethod.setEntity(params); 
			  
			  //------------- Execute HTTP Client Request for response ---------------//
			  HttpResponse httpResponse = httpClient.execute(postMethod);
			  
			  System.out.println("Test Pattern uriBuilder : " + uriBuilder);
			  System.out.println("Test Post Method" + postMethod);
			  
			  //------- Get Response Code 200, 201, 404, 405, 500 from Server --------//
			  int responseCode = httpResponse.getStatusLine().getStatusCode();	
			  
			  if (responseCode == 201 || responseCode == 200) {
				  br = new BufferedReader(new InputStreamReader((httpResponse.getEntity().getContent())));
				  responseBuilder = new StringBuilder();
				  
				  while ((output = br.readLine()) != null) {
					  responseBuilder.append(output);
				  }
				  System.out.println(httpResponse.getStatusLine().getStatusCode());

			  } else {
				  System.out.println("Failed : HTTP error code : " + httpResponse.getStatusLine().getStatusCode());
		   
			  }
		   
			//------- Get Response to String  --------//
		    response = responseBuilder.toString();	    
		    
		  } catch (URISyntaxException e1) {
			  System.out.println("can not connect to URL");
			  e1.printStackTrace();   
		  }	  
	
		return response;
		
	}
}
