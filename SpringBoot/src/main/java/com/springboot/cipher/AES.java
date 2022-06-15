package com.springboot.cipher;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	//AES는 고급 암호화 표준이라는 의미.
	//암호화 및 복호화 시 동일한 키를 사용하는 대칭키 알고리즘입니다.
	//* 대칭키 알고리즘 : 하나의 키로 암호화, 복호화를 모두 수행하는 것
	
	//AES 암호화에 필요한 요소로는 비밀키, 블록 암호 운용 방식, 패딩 기법 이 있습니다.
	//비밀키는 평문을 암호화하는데 사용되며 사용자외에는 절대 외부에 노출되어서는 안됩니다.
	//AES 종류가 무엇이냐에 따라 비밀키의 길이가 달라지게 됩니다.
	
	//- AES128 : 키값 16 bytes(128bit)
	//- AES192 : 키값 24 bytes(192bit)
	//- AES256 : 키값 32 bytes(256bit)
	  
	//AES의 종류는 AES-128(16byte), AED-192(24byte), AES-256(32byte)이 있고, 각각 뒤에 붙은 숫자가 키의 길이를 의미합니다.
	//AES 암호화 알고리즘은 높은 안정성과 빠른 속도로 전세계적으로 사용되고 있습니다.
	
	//1) Secret Key
	//Secret Key는 평문을 암호화하는데 사용되며, 절대로 외부에 노출되어서는 안됩니다.
	//AES 종류가 무엇이냐에 따라 Secret Key의 길이가 달라집니다.
	
	public static String alg = "AES/CBC/PKCS5Padding";
//	private static final String key = "aeskey1234567898";					//AES-128는 128비트(16바이트)의 키
//	private static final String key = "aeskey12345678987654321a";			//AES-192는 192비트(24바이트)의 키
	private static final String key = "aeskey12345678987654321asekey987";	//AES-256는 256비트(32바이트)의 키
    private static final String iv = key.substring(0, 32); // 16byte

    public static void main(String[] args) throws Exception {
    	System.out.println("iv.getBytes() = " + iv.getBytes());
        String text 		= "01022131320";
        String encryption 	= encrypt(text);
        System.out.println("원본 데이터 = " + text);
        System.out.println("암호화 데이터 = " + encrypt(text));
        //FFTP8+Jcxo09W4LVMZl0Vg==
        System.out.println("복호화 데이터 = " + decrypt(encryption));
	}
    
	public static String encrypt(String text) throws Exception {
		//alg = "AES/CBC/PKCS5Padding"
        //AES/ECB/PKCS5Padding 변환은 getInstance 메서드에 Cipher 객체를 AES 암호화, CBC operation mode, PKCS5 padding scheme로 초기화하라고 요청한다.
        Cipher cipher = Cipher.getInstance(alg);
        
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

        byte[] encrypted = cipher.doFinal(text.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception {
        Cipher cipher = Cipher.getInstance(alg);
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

        byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
        byte[] decrypted = cipher.doFinal(decodedBytes);
        return new String(decrypted, "UTF-8");
    }
}
