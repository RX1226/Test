package com.rx1226;

import android.util.Base64;

import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    private final static String CBC_PKCS7 = "AES/CBC/PKCS7Padding";
    private final static String key = "8a0GaJDgUIMF42xDMdm7RQvVAp7v8XME";
    private final static String iv = "lui5IYLktHv3AB9f";

    public static String encrypt(String text) throws Exception {
        return Base64.encodeToString(EncryptByte(text.getBytes(StandardCharsets.UTF_8)), Base64.DEFAULT);
    }
    public static byte[] EncryptByte(byte[] text) throws Exception {
        AlgorithmParameterSpec mAlgorithmParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec mSecretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher mCipher = Cipher.getInstance(CBC_PKCS7);
        mCipher.init(Cipher.ENCRYPT_MODE,mSecretKeySpec,mAlgorithmParameterSpec);

        return mCipher.doFinal(text);
    }

    public static String decrypt(String text) throws Exception {
        return new String(DecryptByte(Base64.decode(text.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT)));
    }
    //AES解密，帶入byte[]型態的16位英數組合文字、32位英數組合Key、需解密文字
    public static byte[] DecryptByte(byte[] text) throws Exception {
        AlgorithmParameterSpec mAlgorithmParameterSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec mSecretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher mCipher = Cipher.getInstance(CBC_PKCS7);
        mCipher.init(Cipher.DECRYPT_MODE,
                mSecretKeySpec,
                mAlgorithmParameterSpec);

        return mCipher.doFinal(text);
    }
}
