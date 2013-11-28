package com.java.utils.password;

import java.io.UnsupportedEncodingException;

import com.gooagoo.common.log.GooagooLog;

public class Md5Utils
{
    private static final int S11 = 7;
    private static final int S12 = 12;
    private static final int S13 = 17;
    private static final int S14 = 22;

    private static final int S21 = 5;
    private static final int S22 = 9;
    private static final int S23 = 14;
    private static final int S24 = 20;

    private static final int S31 = 4;
    private static final int S32 = 11;
    private static final int S33 = 16;
    private static final int S34 = 23;

    private static final int S41 = 6;
    private static final int S42 = 10;
    private static final int S43 = 15;
    private static final int S44 = 21;

    private static final byte[] PADDING = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    private final long[] state = new long[4];
    private final long[] count = new long[2];
    private final byte[] buffer = new byte[64];

    private final byte[] digest = new byte[16];

    public Md5Utils()
    {
        this.md5Init();
    }

    /**
     * 32位Md5加密
     * @param src       待加密的字符串
     * @return          加密后的字符串
     */
    public String encrypt(String src)
    {
        GooagooLog.debug("加密前=" + src);
        this.md5Init();
        try
        {
            this.md5Update(src.getBytes("UTF-8"), src.length());
        }
        catch (UnsupportedEncodingException e)
        {
            return null;
        }
        this.md5Final();
        StringBuffer digestHexStr = new StringBuffer(32);
        for (int i = 0; i < 16; i++)
        {
            digestHexStr.append(byteHEX(this.digest[i]));
        }
        return digestHexStr.toString();
    }

    /**
     * 32位Md5加密
     * @param src       待加密的信息
     * @return          加密后的字符串
     */
    public String encrypt(byte[] src)
    {
        this.md5Init();
        this.md5Update(src, src.length);
        this.md5Final();
        StringBuffer digestHexStr = new StringBuffer(32);
        for (int i = 0; i < 16; i++)
        {
            digestHexStr.append(byteHEX(this.digest[i]));
        }
        return digestHexStr.toString();
    }

    private void md5Init()
    {
        this.count[0] = 0L;
        this.count[1] = 0L;
        this.state[0] = 0x67452301L;
        this.state[1] = 0xefcdab89L;
        this.state[2] = 0x98badcfeL;
        this.state[3] = 0x10325476L;
    }

    private long F(long x, long y, long z)
    {
        return (x & y) | ((~x) & z);
    }

    private long G(long x, long y, long z)
    {
        return (x & z) | (y & (~z));
    }

    private long H(long x, long y, long z)
    {
        return x ^ y ^ z;
    }

    private long I(long x, long y, long z)
    {
        return y ^ (x | (~z));
    }

    private long FF(long a, long b, long c, long d, long x, long s, long ac)
    {
        a += this.F(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));
        a += b;
        return a;
    }

    private long GG(long a, long b, long c, long d, long x, long s, long ac)
    {
        a += this.G(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));
        a += b;
        return a;
    }

    private long HH(long a, long b, long c, long d, long x, long s, long ac)
    {
        a += this.H(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));
        a += b;
        return a;
    }

    private long II(long a, long b, long c, long d, long x, long s, long ac)
    {
        a += this.I(b, c, d) + x + ac;
        a = ((int) a << s) | ((int) a >>> (32 - s));
        a += b;
        return a;
    }

    private void md5Update(byte[] inbuf, int inputLen)
    {
        int i, index, partLen;
        byte[] block = new byte[64];
        index = (int) (this.count[0] >>> 3) & 0x3F;
        if ((this.count[0] += (inputLen << 3)) < (inputLen << 3))
        {
            this.count[1]++;
        }
        this.count[1] += (inputLen >>> 29);
        partLen = 64 - index;
        if (inputLen >= partLen)
        {
            this.md5Memcpy(this.buffer, inbuf, index, 0, partLen);
            this.md5Transform(this.buffer);
            for (i = partLen; i + 63 < inputLen; i += 64)
            {
                this.md5Memcpy(block, inbuf, 0, i, 64);
                this.md5Transform(block);
            }
            index = 0;
        }
        else
        {
            i = 0;
        }
        this.md5Memcpy(this.buffer, inbuf, index, i, inputLen - i);
    }

    private void md5Final()
    {
        byte[] bits = new byte[8];
        int index, padLen;
        this.Encode(bits, this.count, 8);
        index = (int) (this.count[0] >>> 3) & 0x3f;
        padLen = (index < 56) ? (56 - index) : (120 - index);
        this.md5Update(PADDING, padLen);
        this.md5Update(bits, 8);
        this.Encode(this.digest, this.state, 16);
    }

    private void md5Memcpy(byte[] output, byte[] input, int outpos, int inpos, int len)
    {
        for (int i = 0; i < len; i++)
        {
            output[outpos + i] = input[inpos + i];
        }
    }

    private void md5Transform(byte block[])
    {
        long a = this.state[0], b = this.state[1], c = this.state[2], d = this.state[3];
        long[] x = new long[16];
        this.Decode(x, block, 64);
        a = this.FF(a, b, c, d, x[0], S11, 0xd76aa478L); /* 1 */
        d = this.FF(d, a, b, c, x[1], S12, 0xe8c7b756L); /* 2 */
        c = this.FF(c, d, a, b, x[2], S13, 0x242070dbL); /* 3 */
        b = this.FF(b, c, d, a, x[3], S14, 0xc1bdceeeL); /* 4 */
        a = this.FF(a, b, c, d, x[4], S11, 0xf57c0fafL); /* 5 */
        d = this.FF(d, a, b, c, x[5], S12, 0x4787c62aL); /* 6 */
        c = this.FF(c, d, a, b, x[6], S13, 0xa8304613L); /* 7 */
        b = this.FF(b, c, d, a, x[7], S14, 0xfd469501L); /* 8 */
        a = this.FF(a, b, c, d, x[8], S11, 0x698098d8L); /* 9 */
        d = this.FF(d, a, b, c, x[9], S12, 0x8b44f7afL); /* 10 */
        c = this.FF(c, d, a, b, x[10], S13, 0xffff5bb1L); /* 11 */
        b = this.FF(b, c, d, a, x[11], S14, 0x895cd7beL); /* 12 */
        a = this.FF(a, b, c, d, x[12], S11, 0x6b901122L); /* 13 */
        d = this.FF(d, a, b, c, x[13], S12, 0xfd987193L); /* 14 */
        c = this.FF(c, d, a, b, x[14], S13, 0xa679438eL); /* 15 */
        b = this.FF(b, c, d, a, x[15], S14, 0x49b40821L); /* 16 */

        a = this.GG(a, b, c, d, x[1], S21, 0xf61e2562L); /* 17 */
        d = this.GG(d, a, b, c, x[6], S22, 0xc040b340L); /* 18 */
        c = this.GG(c, d, a, b, x[11], S23, 0x265e5a51L); /* 19 */
        b = this.GG(b, c, d, a, x[0], S24, 0xe9b6c7aaL); /* 20 */
        a = this.GG(a, b, c, d, x[5], S21, 0xd62f105dL); /* 21 */
        d = this.GG(d, a, b, c, x[10], S22, 0x2441453L); /* 22 */
        c = this.GG(c, d, a, b, x[15], S23, 0xd8a1e681L); /* 23 */
        b = this.GG(b, c, d, a, x[4], S24, 0xe7d3fbc8L); /* 24 */
        a = this.GG(a, b, c, d, x[9], S21, 0x21e1cde6L); /* 25 */
        d = this.GG(d, a, b, c, x[14], S22, 0xc33707d6L); /* 26 */
        c = this.GG(c, d, a, b, x[3], S23, 0xf4d50d87L); /* 27 */
        b = this.GG(b, c, d, a, x[8], S24, 0x455a14edL); /* 28 */
        a = this.GG(a, b, c, d, x[13], S21, 0xa9e3e905L); /* 29 */
        d = this.GG(d, a, b, c, x[2], S22, 0xfcefa3f8L); /* 30 */
        c = this.GG(c, d, a, b, x[7], S23, 0x676f02d9L); /* 31 */
        b = this.GG(b, c, d, a, x[12], S24, 0x8d2a4c8aL); /* 32 */

        a = this.HH(a, b, c, d, x[5], S31, 0xfffa3942L); /* 33 */
        d = this.HH(d, a, b, c, x[8], S32, 0x8771f681L); /* 34 */
        c = this.HH(c, d, a, b, x[11], S33, 0x6d9d6122L); /* 35 */
        b = this.HH(b, c, d, a, x[14], S34, 0xfde5380cL); /* 36 */
        a = this.HH(a, b, c, d, x[1], S31, 0xa4beea44L); /* 37 */
        d = this.HH(d, a, b, c, x[4], S32, 0x4bdecfa9L); /* 38 */
        c = this.HH(c, d, a, b, x[7], S33, 0xf6bb4b60L); /* 39 */
        b = this.HH(b, c, d, a, x[10], S34, 0xbebfbc70L); /* 40 */
        a = this.HH(a, b, c, d, x[13], S31, 0x289b7ec6L); /* 41 */
        d = this.HH(d, a, b, c, x[0], S32, 0xeaa127faL); /* 42 */
        c = this.HH(c, d, a, b, x[3], S33, 0xd4ef3085L); /* 43 */
        b = this.HH(b, c, d, a, x[6], S34, 0x4881d05L); /* 44 */
        a = this.HH(a, b, c, d, x[9], S31, 0xd9d4d039L); /* 45 */
        d = this.HH(d, a, b, c, x[12], S32, 0xe6db99e5L); /* 46 */
        c = this.HH(c, d, a, b, x[15], S33, 0x1fa27cf8L); /* 47 */
        b = this.HH(b, c, d, a, x[2], S34, 0xc4ac5665L); /* 48 */

        a = this.II(a, b, c, d, x[0], S41, 0xf4292244L); /* 49 */
        d = this.II(d, a, b, c, x[7], S42, 0x432aff97L); /* 50 */
        c = this.II(c, d, a, b, x[14], S43, 0xab9423a7L); /* 51 */
        b = this.II(b, c, d, a, x[5], S44, 0xfc93a039L); /* 52 */
        a = this.II(a, b, c, d, x[12], S41, 0x655b59c3L); /* 53 */
        d = this.II(d, a, b, c, x[3], S42, 0x8f0ccc92L); /* 54 */
        c = this.II(c, d, a, b, x[10], S43, 0xffeff47dL); /* 55 */
        b = this.II(b, c, d, a, x[1], S44, 0x85845dd1L); /* 56 */
        a = this.II(a, b, c, d, x[8], S41, 0x6fa87e4fL); /* 57 */
        d = this.II(d, a, b, c, x[15], S42, 0xfe2ce6e0L); /* 58 */
        c = this.II(c, d, a, b, x[6], S43, 0xa3014314L); /* 59 */
        b = this.II(b, c, d, a, x[13], S44, 0x4e0811a1L); /* 60 */
        a = this.II(a, b, c, d, x[4], S41, 0xf7537e82L); /* 61 */
        d = this.II(d, a, b, c, x[11], S42, 0xbd3af235L); /* 62 */
        c = this.II(c, d, a, b, x[2], S43, 0x2ad7d2bbL); /* 63 */
        b = this.II(b, c, d, a, x[9], S44, 0xeb86d391L); /* 64 */

        this.state[0] += a;
        this.state[1] += b;
        this.state[2] += c;
        this.state[3] += d;
    }

    private void Encode(byte[] output, long[] input, int len)
    {
        for (int i = 0, j = 0; j < len; i++, j += 4)
        {
            output[j] = (byte) (input[i] & 0xffL);
            output[j + 1] = (byte) ((input[i] >>> 8) & 0xffL);
            output[j + 2] = (byte) ((input[i] >>> 16) & 0xffL);
            output[j + 3] = (byte) ((input[i] >>> 24) & 0xffL);
        }
    }

    private void Decode(long[] output, byte[] input, int len)
    {
        for (int i = 0, j = 0; j < len; i++, j += 4)
        {
            output[i] = b2iu(input[j]) | (b2iu(input[j + 1]) << 8) | (b2iu(input[j + 2]) << 16) | (b2iu(input[j + 3]) << 24);
        }
    }

    private static long b2iu(byte b)
    {
        return b < 0 ? b & 0x7F + 128 : b;
    }

    private static String byteHEX(byte ib)
    {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

}
