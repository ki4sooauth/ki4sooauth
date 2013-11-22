package com.gooagoo.common.gus.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class PasswordCardUtils
{

    private final static int imageWidth = 410;

    private final static int imageHeight = 400;

    private final static String[] xindex = { "1", "2", "3", "4", "5", "6", "7", "8" };

    private final static String[] yindex = { "A", "B", "C", "D", "E", "F", "G", "H" };

    public static void main(String[] args) throws Exception
    {
        create(new String("序列号: ".getBytes(), "UTF-8") + getSerialNumber(), getCoordinateData(), null);
    }

    /**
     * 获取序列号
     * @return
     */
    public static String getSerialNumber()
    {
        Random random = new Random();

        return "" + (random.nextInt(8999) + 1000) + (random.nextInt(8999) + 1000) + (random.nextInt(8999) + 1000) + (random.nextInt(8999) + 1000);
    }

    /**
     * 获取坐标数据
     * @return
     */
    public static String[][] getCoordinateData()
    {
        Random random = new Random();
        String[][] coordinateData = new String[10][8];
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                int sj = random.nextInt(999);
                coordinateData[i][j] = "" + sj;
            }
        }

        return coordinateData;
    }

    /**
     * 获取密保卡字节
     * @param serialNumber 序列号
     * @param coordinateData 坐标数据（10行8列）
     * @param output 输出流
     * @throws IOException
     */
    public static void create(String serialNumber, String[][] coordinateData, OutputStream output) throws IOException
    {
        //        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //        String fontNames[] = ge.getAvailableFontFamilyNames();
        //        // Iterate the font family names
        //        for (int i = 0; i < fontNames.length; i++)
        //        {
        //            String fontName = fontNames[i];
        //            GooagooLog.error("LINUX支持的字体：" + fontName, null);
        //        }
        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setBackground(Color.WHITE);
        graphics2D.clearRect(0, 0, imageWidth, imageHeight);
        //1、绘制表格
        drawTable(graphics2D);
        //2、填充序列号
        fillSerialNumber(graphics2D, serialNumber);
        //3、设置坐标
        setCoordinate(graphics2D);
        //4、填充坐标数据
        fillCoordinateData(graphics2D, coordinateData);
        //5、将图片写入流中
        //        ImageIO.write(bufferedImage, "jpg", new File("c:/image.jpg"));
        ImageIO.write(bufferedImage, "jpg", output);
    }

    /**
     * 绘制表格
     * @param graphics2D
     */
    private static void drawTable(Graphics2D graphics2D)
    {
        //1、绘制横向线条、填充横向单元格颜色
        for (int i = 0; i < 11; i++)
        {
            //1.1、绘制横向线条
            graphics2D.setColor(new Color(0x4898D3));
            graphics2D.drawLine(imageWidth - 376, (imageHeight - 380 + i * 30), imageWidth - 16, (imageHeight - 380 + i * 30));
            //1.2、填充横线单元格颜色
            if (i == 0)
            {
                for (int j = 0; j < 9; j++)
                {
                    graphics2D.setColor(new Color(0xB3D6EE));
                    graphics2D.fillRect(imageWidth - 375 + j * 40, imageHeight - 349, 39, 29);
                }
            }
            else if (i < 9 && i % 2 == 0)
            {
                for (int j = 0; j < 9; j++)
                {
                    graphics2D.setColor(new Color(0xE6E6E6));
                    graphics2D.fillRect(imageWidth - 375 + j * 40, imageHeight - 349 + i * 30, 39, 29);
                }
            }
        }
        //2、绘制纵向线条、填充纵向单元格颜色
        for (int i = 0; i < 10; i++)
        {
            //1.1、绘制纵向线条
            graphics2D.setColor(new Color(0x4898D3));
            if (i == 0 || i == 9)
            {
                graphics2D.drawLine(imageWidth - 376 + i * 40, imageHeight - 380, imageWidth - 376 + i * 40, imageHeight - 80);
            }
            else
            {
                graphics2D.drawLine(imageWidth - 376 + i * 40, imageHeight - 350, imageWidth - 376 + i * 40, imageHeight - 80);
            }
            //1.2、填充纵向单元格颜色
            if (i == 0)
            {
                for (int j = 0; j < 9; j++)
                {
                    graphics2D.setColor(new Color(0xB3D6EE));
                    graphics2D.fillRect(imageWidth - 375, imageHeight - 349 + j * 30, 39, 29);
                }
            }
        }
    }

    /**
     * 填充序列号
     * @param graphics2D
     * @param serialNumber
     */
    private static void fillSerialNumber(Graphics2D graphics2D, String serialNumber)
    {
        graphics2D.setPaint(Color.blue);
        graphics2D.setFont(new Font("宋体", Font.BOLD, 16));
        FontRenderContext context = graphics2D.getFontRenderContext();
        Rectangle2D bounds = new Font("宋体", Font.BOLD, 10).getStringBounds(serialNumber, context);
        double x = (imageWidth - 295);
        double y = (imageHeight - 370);
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        graphics2D.drawString(serialNumber, (int) x, (int) baseY);
    }

    /**
     * 设置坐标
     * @param graphics2D
     */
    private static void setCoordinate(Graphics2D graphics2D)
    {
        graphics2D.setColor(new Color(0x045998));
        //1、设置X轴坐标
        for (int i = 0; i < xindex.length; i++)
        {
            double xx = (imageWidth - 360) + 40 * (i + 1);
            double yx = imageHeight - 330;
            graphics2D.drawString(xindex[i], (int) xx, (int) yx);
        }

        //2、设置Y轴坐标
        for (int i = 0; i < yindex.length; i++)
        {
            double xy = imageWidth - 360;
            double yy = (imageHeight - 330) + 30 * (i + 1);
            graphics2D.drawString(yindex[i], (int) xy, (int) yy);
        }
    }

    /**
     * 填充坐标数据
     * @param graphics2D
     * @param coordinateData
     */
    private static void fillCoordinateData(Graphics2D graphics2D, String[][] coordinateData)
    {
        graphics2D.setPaint(Color.BLACK);
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                double xx = (imageWidth - 370) + 40 * (j + 1);
                double yx = (imageHeight - 300) + 30 * i;
                graphics2D.drawString(coordinateData[i][j], (int) xx, (int) yx);
            }
        }
    }

}