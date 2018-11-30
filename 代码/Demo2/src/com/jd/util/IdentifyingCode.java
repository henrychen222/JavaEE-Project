package com.jd.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

/** 
 * 验证码图片生成器 
 *  
 */  
public class IdentifyingCode {  
	 // 图片的宽度。   
    private int width = 160;   
    // 图片的高度。   
    private int height = 40;   
    // 验证码字符个数   
    private int charCodeCount = 3; 
    // 验证码字符个数   
    private int numCodeCount = 2; 
    // 验证码干扰线数   
    private int lineCount = 150;   
    // 验证码   
    private String code = null;   
    
    //字母验证码
    private String charCode = null;
    
    //数字验证码
    private String numCode = null;
    // 验证码图片Buffer   
    private BufferedImage buffImg=null;   
  
    private char[] charCodeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',   
            'K', 'L', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',   
            'X', 'Y', 'Z' };
    
    private char[] numCodeSequence = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9' };  
  
    public  IdentifyingCode() {   
        this.createCode();   
    }   
  
    /**  
     *   
     * @param width 图片宽  
     * @param height 图片高  
     */  
    public  IdentifyingCode(int width,int height) {   
        this.width=width;   
        this.height=height;   
        this.createCode();   
    }   
    /**  
     *   
     * @param width 图片宽  
     * @param height 图片高  
     * @param codeCount 字符个数  
     * @param lineCount 干扰线条数  
     */  
    public  IdentifyingCode(int width,int height,int charCodeCount,int numCodeCount,int lineCount) {   
        this.width=width;   
        this.height=height;   
        this.charCodeCount=charCodeCount;   
        this.numCodeCount=numCodeCount;   
        this.lineCount=lineCount;   
        this.createCode();   
    }   
       
    public void createCode() {   
        int x = 0,fontHeight=0,codeY=0;   
        int red = 0, green = 0, blue = 0;   
           
        x = width / (charCodeCount + numCodeCount +2);//每个字符的宽度   
        fontHeight = height - 2;//字体的高度   
        codeY = height - 4;   
           
        // 图像buffer   
        buffImg = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);   
        Graphics2D g = buffImg.createGraphics();   
        // 生成随机数   
        Random random = new Random();   
        // 将图像填充为白色   
        g.setColor(Color.WHITE);   
        g.fillRect(0, 0, width, height);   
        // 创建字体   
        ImgFontByte imgFont=new ImgFontByte();   
        Font font =imgFont.getFont(fontHeight);   
        g.setFont(font);   
           
        for (int i = 0; i < lineCount; i++) {   
            int xs = random.nextInt(width);   
            int ys = random.nextInt(height);   
            int xe = xs+random.nextInt(width/8);   
            int ye = ys+random.nextInt(height/8);   
            red = random.nextInt(255);   
            green = random.nextInt(255);   
            blue = random.nextInt(255);   
            g.setColor(new Color(red, green, blue));   
            g.drawLine(xs, ys, xe, ye);   
        }   
           
        // randomCode记录随机产生的验证码   
        StringBuffer randomCode = new StringBuffer(); 
        
        List<String> codeList = new ArrayList<String>();
       
        // 随机产生codeCount个字符的验证码。   
        for (int i = 0; i < charCodeCount; i++) {   
            String strRand = String.valueOf(charCodeSequence[random.nextInt(charCodeSequence.length)]);   
            codeList.add(strRand);
        }  
        
        // 随机产生codeCount个字符的验证码。   
        for (int i = 0; i < numCodeCount; i++) {   
            String strRand = String.valueOf(numCodeSequence[random.nextInt(numCodeSequence.length)]);   
            codeList.add(strRand);
        }  
        
        Collections.shuffle(codeList);
        
        for(int i=0;i<codeList.size();i++){
        	  // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。   
            red = random.nextInt(255);   
            green = random.nextInt(255);   
            blue = random.nextInt(255);   
            g.setColor(new Color(red, green, blue));   
            g.drawString(codeList.get(i), (i + 1) * x, codeY);  
            randomCode.append(codeList.get(i));
        }
        code=randomCode.toString(); 
        // 将四位数字的验证码保存到Session中。   
        charCode = StringUtil.countChar(code);
    }   
       
    public void write(String path) throws IOException {   
        OutputStream sos = new FileOutputStream(path);   
        this.write(sos);   
    }   
       
    public void write(OutputStream sos) throws IOException {   
            ImageIO.write(buffImg, "png", sos);   
            sos.close();   
    }   
    public BufferedImage getBuffImg() {   
        return buffImg;   
    }   
       
    public String getCode() {   
        return code;   
    }

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}   
}
