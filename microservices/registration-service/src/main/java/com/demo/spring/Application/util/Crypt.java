package com.demo.spring.Application.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Crypt {

	public static String hashWithPBKDF2(String plainText, byte[] salt) {

		KeySpec spec = new PBEKeySpec(plainText.toCharArray(), salt, 65536, 128);
		// Implementing PBKDF2 in Java
		StringBuilder sb = new StringBuilder();
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

			byte[] hash = factory.generateSecret(spec).getEncoded();

			for (byte b : hash) {

				// https://stackoverflow.com/questions/18438946/format-specifier-02x
				/*
				 * %02x means print at least 2 digits, prepend it with 0's if there's less. In
				 * your case it's 7 digits, so you get no extra 0 in front.
				 * 
				 * Also, %x is for int, but you have a long. Try %08lx instead.
				 */
				sb.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static byte[] generateSalt() {
		// salts are a fundamental principle of password hashing
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		return salt;
	}
}
