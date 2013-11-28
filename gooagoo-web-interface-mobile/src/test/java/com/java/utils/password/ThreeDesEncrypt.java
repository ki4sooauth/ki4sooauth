package com.java.utils.password;


/**
*3DES（或称为Triple DES）是三重数据加密算法（TDEA，Triple Data Encryption Algorithm）块密码的通称
*
* 使用DES加密与解密,可对byte[],String类型进行加密与解密 密文可使用String,byte[]存储.
*
* 方法: void getKey(String strKey)从strKey的字条生成一个Key
*
* String getEncString(String strMing)对strMing进行加密,返回String密文 String
* getDesString(String strMi)对strMin进行解密,返回String明文
*
* byte[] getEncCode(byte[] byteS)byte[]型的加密 byte[] getDesCode(byte[]
* byteD)byte[]型的解密
*/
@SuppressWarnings("restriction")
public class ThreeDesEncrypt
{
    //    Key key;
    //
    //    /**
    //    * 根据参数生成KEY
    //    *
    //    * @param strKey
    //    */
    //    public void getKey(String strKey)
    //    {
    //        try
    //        {
    //            KeyGenerator _generator = KeyGenerator.getInstance("DES");
    //            _generator.init(new SecureRandom(strKey.getBytes()));
    //            this.key = _generator.generateKey();
    //            _generator = null;
    //        }
    //        catch (Exception e)
    //        {
    //            e.printStackTrace();
    //        }
    //    }
    //
    //    /**
    //    * 加密String明文输入,String密文输出
    //    *
    //    * @param strMing
    //    * @return
    //    */
    //    public String getEncString(String strMing)
    //    {
    //        byte[] byteMi = null;
    //        byte[] byteMing = null;
    //        String strMi = "";
    //        BASE64Encoder base64en = new BASE64Encoder();
    //        try
    //        {
    //            byteMing = strMing.getBytes("UTF8");
    //            byteMi = this.getEncCode(byteMing);
    //            strMi = base64en.encode(byteMi);
    //        }
    //        catch (Exception e)
    //        {
    //            e.printStackTrace();
    //        }
    //        finally
    //        {
    //            base64en = null;
    //            byteMing = null;
    //            byteMi = null;
    //        }
    //        return strMi;
    //    }
    //
    //    /**
    //    * 解密 以String密文输入,String明文输出
    //    * @param strMi
    //    * @return
    //    */
    //    public String getDesString(String strMi)
    //    {
    //        BASE64Decoder base64De = new BASE64Decoder();
    //        byte[] byteMing = null;
    //        byte[] byteMi = null;
    //        String strMing = "";
    //        try
    //        {
    //            byteMi = base64De.decodeBuffer(strMi);
    //            byteMing = this.getDesCode(byteMi);
    //            strMing = new String(byteMing, "UTF8");
    //        }
    //        catch (Exception e)
    //        {
    //            e.printStackTrace();
    //        }
    //        finally
    //        {
    //            base64De = null;
    //            byteMing = null;
    //            byteMi = null;
    //        }
    //        return strMing;
    //    }
    //
    //    /**
    //      　　* 加密以byte[]明文输入,byte[]密文输出
    //      　　*
    //      　　* @param byteS
    //      　　* @return
    //      　　*/
    //    private byte[] getEncCode(byte[] byteS)
    //    {
    //        byte[] byteFina = null;
    //        Cipher cipher;
    //        try
    //        {
    //            cipher = Cipher.getInstance("DES");
    //            cipher.init(Cipher.ENCRYPT_MODE, this.key);
    //            byteFina = cipher.doFinal(byteS);
    //        }
    //        catch (Exception e)
    //        {
    //            e.printStackTrace();
    //        }
    //        finally
    //        {
    //            cipher = null;
    //        }
    //        return byteFina;
    //    }
    //
    //    /**
    //      　　* 解密以byte[]密文输入,以byte[]明文输出
    //      　　*
    //      　　* @param byteD
    //      　　* @return
    //      　　*/
    //    private byte[] getDesCode(byte[] byteD)
    //    {
    //        Cipher cipher;
    //        byte[] byteFina = null;
    //        try
    //        {
    //            cipher = Cipher.getInstance("DES");
    //            cipher.init(Cipher.DECRYPT_MODE, this.key);
    //            byteFina = cipher.doFinal(byteD);
    //        }
    //        catch (Exception e)
    //        {
    //            e.printStackTrace();
    //        }
    //        finally
    //        {
    //            cipher = null;
    //        }
    //        return byteFina;
    //    }
    //
    //    public static void main(String[] args)
    //    {
    //        ThreeDesEncrypt des = new ThreeDesEncrypt();// 实例化一个对像
    //        des.getKey("fenglingcompany");// 生成密匙
    //        String strEnc = des.getEncString("fengye666666666");// 加密字符串,返回String的密文
    //        System.out.println(strEnc);
    //        String strDes = des.getDesString(strEnc);// 把String 类型的密文解密
    //        System.out.println(strDes);
    //    }
}