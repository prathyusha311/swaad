package com.foodServices.swaad.Utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureUtility {
	
	
	
	private SecureUtility() {}
	
	public static String  hashPassword(String passwordToHash,String salt) throws NoSuchAlgorithmException {
		
		
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt.getBytes());
		
		byte[] hashedPassword = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder sb = null; 
        sb=new StringBuilder();
        for (int i = 0; i < hashedPassword.length; i++) {
            sb.append(Integer.toString((hashedPassword[i] & 0xff) + 0x100, 16).substring(1));
        }
        
		return sb.toString();
	}

	public static String getSalt() {
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt.toString();
	}
	
	
	public static int generateRandomValue(int power) throws NoSuchAlgorithmException {
		SecureRandom secureRandom = null;
		int seedByteCount = power;
		
			SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG");
			byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

			secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(seed);
		
		int ramdongen = 0;

		ramdongen = secureRandom.nextInt((int) Math.pow(10, power));

		String strRan = "" + ramdongen;
		while (strRan.length() < power) {
			ramdongen = secureRandom.nextInt((int) Math.pow(10, power));
			strRan = "" + ramdongen;
		}
		return ramdongen;

	}
}
