package th.co.inet.training.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TestResponseAPI {

	public static void main(String[] args) {
		
		TestResponseAPI testResponseAPI = new TestResponseAPI();
		String jsonStr = testResponseAPI.jsonArrInObj();

	    JsonObject obj = new JsonParser().parse(jsonStr).getAsJsonObject();
	    JsonArray jsonArrStr = obj.get("JsonArrInObj").getAsJsonArray();
	    
	    int round = 0;
	    for (int i = 0; i < jsonArrStr.size(); i++) {
	    	JsonObject rec = (JsonObject) jsonArrStr.get(i);
	    	String param01 = rec.get("param_01").toString();
	        String param02 = rec.get("param_02").toString();
	        String param03 = rec.get("param_03").toString();
	        System.out.println("----------- Round : " + ++round + " ----------------");
	        System.out.println("Check Value 1 in Json Array : " + param01);
	        System.out.println("Check Value 2 in Json Array : " + param02);
	        System.out.println("Check Value 3 in Json Array : " + param03);
	    }
	}
	
	public String jsonObj() {
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("param_01", "data_01");
		jsonObj.addProperty("param_02", "data_02");
		jsonObj.addProperty("param_03", "data_03");
		
		return jsonObj.toString();
	}
	
	public String jsonArr() {
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("param_01", "data_01");
		jsonObj.addProperty("param_02", "data_02");
		jsonObj.addProperty("param_03", "data_03");
		
		JsonArray jArr = new JsonArray();
		jArr.add(jsonObj);
		
		System.out.println(jArr);
		
		return jArr.toString();
	}
	
	public String jsonArrInObj() {
		
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("param_01", "BKK");
		jsonObj.addProperty("param_02", "HDY");
		jsonObj.addProperty("param_03", "KHON");
		
		JsonObject jsonObj2 = new JsonObject();
		jsonObj2.addProperty("param_01", "Limited");
		jsonObj2.addProperty("param_02", "Edition");
		jsonObj2.addProperty("param_03", "Wonderful");
		
		JsonObject jsonObj3 = new JsonObject();
		jsonObj3.addProperty("param_01", "Lotus");
		jsonObj3.addProperty("param_02", "Express");
		jsonObj3.addProperty("param_03", "24 Hr.");
		
		JsonArray jArr = new JsonArray();
		jArr.add(jsonObj);
		jArr.add(jsonObj2);
		jArr.add(jsonObj3);
	
		JsonObject jsonArrInObj = new JsonObject();
		jsonArrInObj.add("JsonArrInObj", jArr);
	
		System.out.println(jsonArrInObj);
		
		return jsonArrInObj.toString();
	}
}
