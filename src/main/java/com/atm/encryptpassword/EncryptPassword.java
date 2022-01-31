package com.atm.encryptpassword;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptPassword
{
	
    static String plainText = "oracle";
    public static final int AES_KEY_SIZE = 256;
    public static final int GCM_IV_LENGTH = 12;
    public static final int GCM_TAG_LENGTH = 16;

private EncryptPassword() {
	
}

    public static byte[] encrypt(byte[] plaintext, SecretKey key, byte[] iv) throws IllegalBlockSizeException, BadPaddingException 
    {
        // Get Cipher Instance
        Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/GCM/NoPadding");
		     // Create SecretKeySpec
	        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
	        
	        // Create GCMParameterSpec
	        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
	        
	        // Initialize Cipher for ENCRYPT_MODE
	        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
	        return cipher.doFinal(plaintext);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.getMessage();
		}
        
        
  return new byte[0];
        
    }

    public static String decrypt()  
    {
    	
    	  KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			 keyGenerator.init(AES_KEY_SIZE);
	          // Generate Key
	          SecretKey key = keyGenerator.generateKey();
	          byte[] iv = new byte[GCM_IV_LENGTH];
	          SecureRandom random = new SecureRandom();
	          random.nextBytes(iv);
	          byte[] cipherText = encrypt("oracle".getBytes(), key, iv);
	        // Get Cipher Instance
	        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
	        
	        // Create SecretKeySpec
	        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
	        
	        // Create GCMParameterSpec
	        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
	        
	        // Initialize Cipher for DECRYPT_MODE
	        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
	        
	        // Perform Decryption
	        byte[] decryptedText = cipher.doFinal(cipherText);
	        return new String(decryptedText);
		} catch (NoSuchAlgorithmException e) {
			e.getMessage();
		} catch (IllegalBlockSizeException e) {

			e.printStackTrace();
		} catch (BadPaddingException e1) {

			e1.printStackTrace();
		} catch (NoSuchPaddingException e2) {

			e2.printStackTrace();
		} catch (InvalidKeyException e3) {

			e3.printStackTrace();
		} catch (InvalidAlgorithmParameterException e4) {
			e4.printStackTrace();
		}
         
        return null;
        
    }
}
