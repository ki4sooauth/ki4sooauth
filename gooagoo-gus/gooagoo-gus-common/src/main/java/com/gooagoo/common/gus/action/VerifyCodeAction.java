package com.gooagoo.common.gus.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gooagoo.common.action.BaseAction;
import com.gooagoo.common.gus.utils.VerifyCodeUtils;
import com.gooagoo.common.log.GooagooLog;

/**
 * 随机验证码服务类
 * @author GUS
 *
 */
@Controller
@RequestMapping("/verifyCodeAction")
public class VerifyCodeAction extends BaseAction
{

    private final Random random = new Random();
    private final String randString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串

    private final int width = 80;//图片宽
    private final int height = 26;//图片高
    private final int lineSize = 50;//干扰线数量
    private final int stringNum = 4;//随机产生字符数量

    /**
     * 生成随机图片
     */
    @RequestMapping(params = "method=image")
    public void getRandcode(HttpServletRequest request, HttpServletResponse response)
    {
        //BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();//产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, this.width, this.height);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        g.setColor(this.getRandColor(110, 133));
        //绘制干扰线
        for (int i = 0; i <= this.lineSize; i++)
        {
            this.drowLine(g);
        }
        //绘制随机字符
        String randomString = "";
        for (int i = 1; i <= this.stringNum; i++)
        {
            randomString = this.drowString(g, randomString, i);
        }
        //将验证码放入缓存中
        VerifyCodeUtils.setVerifyCode(randomString, request, response);
        g.dispose();
        try
        {
            ImageIO.write(image, "JPEG", response.getOutputStream());//将内存中的图片通过流形式输出到客户端
        }
        catch (Exception e)
        {
            GooagooLog.error("将内存中的图片通过流形式输出到客户端异常", e);
        }
    }

    /**
     * 获得字体
     * @return
     */
    private Font getFont()
    {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /**
     * 获得颜色
     * @param fc
     * @param bc
     * @return
     */
    private Color getRandColor(int fc, int bc)
    {
        if (fc > 255)
        {
            fc = 255;
        }
        if (bc > 255)
        {
            bc = 255;
        }
        int r = fc + this.random.nextInt(bc - fc - 16);
        int g = fc + this.random.nextInt(bc - fc - 14);
        int b = fc + this.random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 绘制字符串
     * @param g
     * @param randomString
     * @param i
     * @return
     */
    private String drowString(Graphics g, String randomString, int i)
    {
        g.setFont(this.getFont());
        g.setColor(new Color(this.random.nextInt(101), this.random.nextInt(111), this.random.nextInt(121)));
        String rand = String.valueOf(this.getRandomString(this.random.nextInt(this.randString.length())));
        randomString += rand;
        g.translate(this.random.nextInt(3), this.random.nextInt(3));
        g.drawString(rand, 15 * i - 5, 16);
        return randomString;
    }

    /**
     * 绘制干扰线
     * @param g
     */
    private void drowLine(Graphics g)
    {
        int x = this.random.nextInt(this.width);
        int y = this.random.nextInt(this.height);
        int xl = this.random.nextInt(13);
        int yl = this.random.nextInt(15);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /**
     * 获取随机的字符
     * @param num
     * @return
     */
    private String getRandomString(int num)
    {
        return String.valueOf(this.randString.charAt(num));
    }
}
