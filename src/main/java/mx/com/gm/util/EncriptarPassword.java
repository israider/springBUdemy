package mx.com.gm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	public static void main(String args[]) {
		var pass="123";
//		encriptarPassword(pass);
		
		System.out.println("password: "+pass);
		System.out.println("password: "+ encriptarPassword(pass));
		
	}
	
	public static String encriptarPassword(String string) {
		BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
		return enc.encode(string);
				
	}
}
