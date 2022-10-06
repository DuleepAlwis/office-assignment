package com.StudentManagementSystem.utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtility {

	public static String getHashPassword(String passwordTxt) {
		
		String hashtext = "";
		
		try   
		{  
			MessageDigest md = MessageDigest.getInstance("MD5");  
			byte[] messageDigest = md.digest(passwordTxt.getBytes());  
			BigInteger no = new BigInteger(1, messageDigest);  
			 hashtext = no.toString(16);  
			while (hashtext.length() < 32)   
			{  
				hashtext = "0" + hashtext;  
			}
		}
		catch (NoSuchAlgorithmException e)   
		{  
			System.out.println(e.getMessage());  
		}  
		return hashtext;  
	}
}
