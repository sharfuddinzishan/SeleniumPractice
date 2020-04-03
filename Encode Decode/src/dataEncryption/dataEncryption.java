package dataEncryption;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class dataEncryption 
{
	public static void main(String[] args) throws Throwable 
	{
		String pass = "LiarZishan003";
		byte[] byteEnc= pass.getBytes(StandardCharsets.UTF_8);
		
		String enc = Base64.getEncoder().encodeToString(byteEnc);

		System.out.println("Enco Pass in byte : "+byteEnc);
		System.out.println("After Encoded Pass : "+enc);
		
		System.out.println("--------------");
		
		byte[] byteDec = Base64.getDecoder().decode(enc);
		String dec = new String(byteDec,StandardCharsets.UTF_8);
		System.out.println("Decote Byte Pass : "+byteDec);
		System.out.println("Decod Pass : "+dec);
		
	}
	
}