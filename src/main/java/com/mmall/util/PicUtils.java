package com.mmall.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public  class PicUtils {
	
	private String pathStr = this.getClass().getClassLoader().getResource("").getPath();

	private Font font = new Font("华文彩云", Font.PLAIN, 40);// 添加字体的属性设置

	private static Graphics2D g = null;

	private int fontsize = 0;

	private int x = 0;

	private int y = 0;
	
	public static void main(String[] args) throws Exception {	
		new PicUtils().getUrl("123456");
	}
	
	
	public String getUrl(String code) throws Exception{
		
		String uploadPath = PropertyUtil.getProperty("SystemData.uploadPath");
		String UrlPath = PropertyUtil.getProperty("SystemData.returnUrlHead");	
		String codeUrl = PropertyUtil.getProperty("SystemData.CodeUrl");	
		
		String filepath = uploadPath + File.separator + "img";
		//BufferedImage d = PicUtils.loadImageLocal(filepath+File.separator+"1.png");
		makeDirs(filepath);
		filepath = filepath +File.separator+ code + ".png";
		String urlpath = UrlPath + "/img/" + code + ".png";
		
		File file = new File(filepath);
		if(file.exists()){
			file.delete();
		}
		
		//生成二维码
//		<SystemData.CodeUrl>http://temp.9shadow.com/box/index.html?code=</SystemData.CodeUrl>
		PicUtils.writeImageLocal(filepath, QrCodeCreateUtil.createQrCode(codeUrl+code,300,"JPEG"));
		//	PicUtils.writeImageLocal(filepath, PicUtils.modifyImagetogeter(CreateQRCode.createQRCodeBuff("http://h5.9shadow.com/fkjn/index.html?phone="+tel), d));
		System.out.println(filepath);
		System.out.println(urlpath);
		
		return urlpath;
	}
	
	public static boolean makeDirs(String filePath) {
		if (filePath == null || filePath.isEmpty()) {
			return false;
		}
		File folder = new File(filePath);
		return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	}

	/**
	 * 导入本地图片到缓冲区
	 */
	public static BufferedImage loadImageLocal(String imgName) {
		try {
			return ImageIO.read(new File(imgName));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 导入网络图片到缓冲区
	 */
	public BufferedImage loadImageUrl(String imgName) {
		try {
			URL url = new URL(imgName);
			return ImageIO.read(url);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * 生成新图片到本地
	 */
	public static void writeImageLocal(String newImage, BufferedImage img) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, "png", outputfile);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * 设定文字的字体等
	 */
	public void setFont(String fontStyle, int fontSize) {
		this.fontsize = fontSize;
		this.font = new Font(fontStyle, Font.PLAIN, fontSize);
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public BufferedImage modifyImage(BufferedImage img, Object content, int x,
			int y) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.CYAN);//设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (content != null) {
				g.drawString(content.toString(), this.x, this.y);
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出
	 */
	public BufferedImage modifyImage(BufferedImage img, Object[] contentArr,
			int x, int y, boolean xory) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.RED);
			if (this.font != null)
				g.setFont(this.font);
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				this.x = h - this.fontsize + 2;
				this.y = w;
			} else {
				this.x = x;
				this.y = y;
			}
			if (contentArr != null) {
				int arrlen = contentArr.length;
				if (xory) {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.x += contentArr[i].toString().length()
								* this.fontsize / 2 + 5;// 重新计算文本输出位置
					}
				} else {
					for (int i = 0; i < arrlen; i++) {
						g.drawString(contentArr[i].toString(), this.x, this.y);
						this.y += this.fontsize + 2;// 重新计算文本输出位置
					}
				}
			}
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 * 
	 * 时间:2007-10-8
	 * 
	 * @param img
	 * @return
	 */
	public BufferedImage modifyImageYe(BufferedImage img) {

		try {
			int w = img.getWidth();
			int h = img.getHeight();
			g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(Color.blue);//设置字体颜色
			if (this.font != null)
				g.setFont(this.font);
			g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return img;
	}

	public static BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d) {
		try {
			int w = b.getWidth();
			int h = b.getHeight();
			g = d.createGraphics();
			g.drawImage(b, 217, 582, w, h, null);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return d;
	}


}
