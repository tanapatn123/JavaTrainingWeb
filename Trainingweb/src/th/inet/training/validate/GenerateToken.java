package th.inet.training.validate;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class GenerateToken {
	public String getToken() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[64];
		random.nextBytes(bytes);
		
		byte[] encoded = Base64.getEncoder().encode(bytes);
		String token = new String(encoded);
		
		return token.toLowerCase().replace("+", "");
	}
	
	public String getTokens() {
		Random rd = new Random();
		int numberRandom = rd.nextInt(1000000);
		String token = String.valueOf(numberRandom);
		System.out.println(token);
		return token;
	}

	

}
