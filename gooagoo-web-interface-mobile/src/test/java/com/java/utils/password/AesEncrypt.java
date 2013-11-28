package com.java.utils.password;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/**
 * 密码学中的高级加密标准（Advanced Encryption Standard，AES），又称高级加密标准Rijndael加密法，
 * 是美国联邦政府采用的一种区块加密标准。这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用。
 * Rijndael密码的设计力求满足以下3条标准：
 * ① 抵抗所有已知的攻击。
 * ② 在多个平台上速度快，编码紧凑。
 * ③ 设计简单。
 * 因为Rijndael加密法可以支持更大范围的区块和密钥长度：AES的区块长度固定为128 比特，密钥长度则可以是128，192或256比特；
 * 而Rijndael使用的密钥和区块长度可以是32位的整数倍，以128位为下限，256比特为上限。加密过程中使用的密钥是由Rijndael密钥生成方案产生。
 * AES的基本要求是，采用对称分组密码体制，密钥长度的最少支持为128、192、256，分组长度128位，算法应易于各种硬件和软件实现。
 * 与公共密钥密码使用密钥对不同，对称密钥密码使用相同的密钥加密和解密数据。CBC
 */
public class AesEncrypt
{
    public static byte[] iv = new byte[] { 82, 22, 50, 44, -16, 124, -40, -114, -87, -40, 37, 23, -56, 23, -33, 75 };

    private static AesEncrypt aes = null;

    public static byte[] key1 = new byte[] { -42, 35, 67, -86, 19, 29, -11, 84, 94, 111, 75, -104, 71, 46, 86, -21, -119, 110, -11, -32, -28, 91, -33, -46, 99, 49, 2, 66, -101, -11, -8, 56 };

    private AesEncrypt()
    {

    }

    public static synchronized AesEncrypt getInstance()
    {
        if (aes == null)
        {
            aes = new AesEncrypt();
        }
        return aes;
    }

    public String encrypt(String msg)
    {

        String str = "";
        try
        {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(key1));
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            SecretKey key = kgen.generateKey();
            Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            str = this.asHex(ecipher.doFinal(msg.getBytes()));
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        catch (InvalidAlgorithmParameterException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public String decrypt(String value)
    {
        try
        {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(key1));
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            SecretKey key = kgen.generateKey();
            Cipher dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            return new String(dcipher.doFinal(this.asBin(value)));
        }
        catch (BadPaddingException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchPaddingException e)
        {
            e.printStackTrace();
        }
        catch (InvalidKeyException e)
        {
            e.printStackTrace();
        }
        catch (InvalidAlgorithmParameterException e)
        {
            e.printStackTrace();
        }
        catch (IllegalBlockSizeException e)
        {
            e.printStackTrace();
        }
        return "";
    }

    private String asHex(byte buf[])
    {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;

        for (i = 0; i < buf.length; i++)
        {
            if ((buf[i] & 0xff) < 0x10)
            {
                strbuf.append("0");
            }

            strbuf.append(Long.toString(buf[i] & 0xff, 16));
        }

        return strbuf.toString();
    }

    private byte[] asBin(String src)
    {
        if (src.length() < 1)
        {
            return null;
        }
        byte[] encrypted = new byte[src.length() / 2];
        for (int i = 0; i < src.length() / 2; i++)
        {
            int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);

            encrypted[i] = (byte) (high * 16 + low);
        }
        return encrypted;
    }

    public static void main(String args[])
    {
        String str = AesEncrypt.getInstance().encrypt("192.168.30.193.123");
        System.out.println(str);
        System.out.println(AesEncrypt.getInstance().decrypt(str));
    }
}
