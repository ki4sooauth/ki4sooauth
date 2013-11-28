package com.java.utils.password;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;

public class DesUtils
{

    private static String strDefaultKey = "gooagoo";
    private Cipher encryptCipher = null;
    private Cipher decryptCipher = null;

    public DesUtils() throws Exception
    {
        this(strDefaultKey);
    }

    @SuppressWarnings("restriction")
    public DesUtils(String strKey) throws Exception
    {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = this.getKey(strKey.getBytes("UTF-8"));
        this.encryptCipher = Cipher.getInstance("DES");
        this.encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        this.decryptCipher = Cipher.getInstance("DES");
        this.decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    private static String byteArr2HexStr(byte[] arrB) throws Exception
    {
        int iLen = arrB.length;
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++)
        {
            int intTmp = arrB[i];
            while (intTmp < 0)
            {
                intTmp = intTmp + 256;
            }
            if (intTmp < 16)
            {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    private static byte[] hexStr2ByteArr(String strIn) throws Exception
    {
        byte[] arrB = strIn.getBytes("UTF-8");
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2)
        {
            String strTmp = new String(arrB, i, 2, "UTF-8");
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    public byte[] encrypt(byte[] arrB) throws Exception
    {
        return this.encryptCipher.doFinal(arrB);
    }

    public String encrypt(String strIn) throws Exception
    {
        return byteArr2HexStr(this.encrypt(strIn.getBytes("UTF-8")));
    }

    public byte[] decrypt(byte[] arrB) throws Exception
    {
        return this.decryptCipher.doFinal(arrB);
    }

    public String decrypt(String strIn) throws Exception
    {
        return new String(this.decrypt(hexStr2ByteArr(strIn)), "UTF-8");
    }

    private Key getKey(byte[] arrBTmp) throws Exception
    {
        byte[] arrB = new byte[8];
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++)
        {
            arrB[i] = arrBTmp[i];
        }
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }
}
