package com.zac.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * verification CODE
 * @author ZacTang
 *
 */
public class CodeUtil {

	private int width = 90;//width of picture
    private int height = 30;// height of picture
    private int codeCount = 4;// count of number about picture
    private int codeX = 13;
    private int fontHeight = 22;
    private int codeY = 25;
    char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H','J', 'K', 'M', 'N','P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
    
    /**
     * output style EG.<br/>
     	response.setHeader("Pragma", "no-cache");<br/>
	 	response.setHeader("Cache-Control", "no-cache");<br/>
		response.setDateHeader("Expires", 0);<br/>
		response.setContentType("image/jpeg");<br/>
     * @param output HttpServletResponse.getOutputStream()
     * @return String code
     */
    public  String  getCode(OutputStream output){
    	 // picture　buffer
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics gd = buffImg.getGraphics();
        
        Random random = new Random();// 创建一个随机数生成器类
        gd.setColor(Color.WHITE); // 将图像填充为白色
        gd.fillRect(0, 0, width, height);
        gd.setFont(new Font("Fixedsys", Font.BOLD, fontHeight)); // 设置字体。字体的大小应该根据图片的高度来定。
        gd.setColor(Color.BLACK); // 画边框。
        gd.drawRect(0, 0, width - 1, height - 1);
        //gd.setColor(Color.BLACK);
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到。
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            gd.drawLine(x, y, x + xl, y + yl);
        }
        StringBuffer randomCode = new StringBuffer();
        int red = 0, green = 0, blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i = 0; i < codeCount; i++) {
          
            String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length-1)]);  // 得到随机产生的验证码数字。
            //产生随机的颜色构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            Color randomColor=new Color(red, green, blue);
            
            gd.setColor(randomColor);//用随机产生的颜色将验证码绘制到图像中。
            gd.drawString(code, (i + 1) * codeX, codeY);
            randomCode.append(code);// 将产生的随机数组合在一起。
        }
        
        try {
			ImageIO.write(buffImg, "jpeg", output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return randomCode.toString();
    }
}
