package com.mmall.controller;

import com.mmall.util.Coder;
import com.mmall.util.FileUtil;
import com.mmall.util.PropertyUtil;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 文件上传
 */
@Slf4j
@Controller
@RequestMapping("/FileController")
public class FileController {
	String  uploadPath;
	String returnUrlHead;
	@ResponseBody
	@RequestMapping(value = "/springUpload")
	public String springUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		String kinds=request.getParameter("kinds");
		//String type=request.getParameter("type");
		//String ID=request.getParameter("ID");
		//String Root=request.getSession().getServletContext().getRealPath("");
		uploadPath= PropertyUtil.getProperty("SystemData.uploadPath");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead");
		
		String finalUpPath=uploadPath+File.separator+kinds;
		String finalURLPath=returnUrlHead+kinds;
		
		FileUtil.makeDirs(finalUpPath);
		log.info("文件上传：开始"+finalUpPath);
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			//Iterator<String> iter = multiRequest.getFileNames();
			while (multiRequest.getFileNames().hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(multiRequest.getFileNames().next().toString());
				if (file != null) {
					finalURLPath=finalURLPath+"/"+file.getOriginalFilename();
					String path = finalUpPath+File.separator+file.getOriginalFilename();
					log.info("文件上传path:" + path);
					log.info("文件上传finalURLPath："+finalURLPath);
					// 上传
					file.transferTo(new File(path));
				}
			}
		}
		log.info("finalURLPath"+finalURLPath);
		return finalURLPath;
	}

	@ResponseBody
	@RequestMapping(value = "/imgUpload.json")
	public Map<String,Object> imgUploadpc(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		String kinds=request.getParameter("kinds");
		log.info("kinds=========="+kinds);

		Map<String,Object> map  =new HashMap<>();
		uploadPath=PropertyUtil.getProperty("SystemData.uploadPath")+"/"+PropertyUtil.getProperty("SystemData.uploadPathImg");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead")+"/"+PropertyUtil.getProperty("SystemData.uploadPathImg");

		String finalUpPath=uploadPath+"/"+kinds;
		String finalURLPath=returnUrlHead+"/"+kinds;

		FileUtil.makeDirs(finalUpPath);
		log.info("文件上传：开始"+finalUpPath);
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					//file.getInputStream();
					if("shop".equals(kinds)){
						try{
//						CommonsMultipartFile cf= (CommonsMultipartFile)file;
//						DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//						File f = fi.getStoreLocation();
							InputStream is = file.getInputStream();
							BufferedImage image = ImageIO.read(is);
							int width = image.getWidth();
							int height = image.getHeight();
							//System.out.println(width+":"+height);
							if(width!=114||height!=100){
								map.put("success",0);
							}
						}catch (Exception e) {
							e.printStackTrace();
						}
					}

					String originalName=file.getOriginalFilename();
					log.info("imgUpload"+originalName);
					if (originalName.length()>0) {
						//String originalNameReal=originalName.substring(0, originalName.lastIndexOf('.'));
						String originalNameExp=originalName.substring(originalName.lastIndexOf('.')+1, originalName.length());
						String NamebyMd5= new Date().getTime()+"";

					/*try {
						NamebyMd5= new String(Coder.getMd5ByFile(file));
					} catch (Exception e) {
						log.error("文件上传：MD5失败"+finalUpPath);
					}*/


						finalURLPath=finalURLPath+"/"+NamebyMd5+"."+originalNameExp;
						String path = finalUpPath+"/"+NamebyMd5+"."+originalNameExp;
						log.info("文件上传path:" + path);
						log.info("文件上传finalURLPath："+finalURLPath);
						// 上传
						file.transferTo(new File(path));
					}
				}

			}

		}
		log.info("finalURLPath================"+finalURLPath);
		map.put("success",1);
		map.put("data",finalURLPath);
		return map;
	}



	@ResponseBody
	@RequestMapping(value = "/imgUpload")
	public String imgUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		log.info("上传============");
//		String kinds=request.getParameter("kinds");
		String kinds=request.getParameter("kinds");
		log.info("======="+kinds);
		uploadPath=PropertyUtil.getProperty("SystemData.uploadPath")+File.separator+PropertyUtil.getProperty("SystemData.uploadPathImg");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead")+"/"+PropertyUtil.getProperty("SystemData.uploadPathImg");

		System.out.println("拼出来的上传路径："+uploadPath);
		System.out.println("拼出来的下载路径："+returnUrlHead);

		/*String finalUpPath=uploadPath+File.separator+kinds;
		String finalURLPath=returnUrlHead+"/"+kinds;*/
		String finalUpPath=uploadPath;
		String finalURLPath=returnUrlHead;

		makeDirs(finalUpPath);
		log.info("文件上传：开始"+finalUpPath);
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					String originalName=file.getOriginalFilename();
					log.info("imgUpload"+originalName);
					if (originalName.length()>0) {
						//String originalNameReal=originalName.substring(0, originalName.lastIndexOf('.'));
						String originalNameExp=originalName.substring(originalName.lastIndexOf('.')+1, originalName.length());
						String NamebyMd5="game";
						try {
							NamebyMd5= new String(Coder.getMd5ByFile(file));
						} catch (Exception e) {
							log.error("文件上传：MD5失败"+finalUpPath);
						}

						finalURLPath=finalURLPath+"/"+NamebyMd5+"."+originalNameExp;
						String path = finalUpPath+File.separator+NamebyMd5+"."+originalNameExp;
						log.info("文件上传path:" + path);
						log.info("文件上传finalURLPath："+finalURLPath);
						// 上传
						file.transferTo(new File(path));
						//压缩
						if("Identity".equals(kinds)){
							try {
								Thumbnails.of(path).width(300).height(300).toFile(path);
							} catch (Exception e) {
								log.info("压缩异常。。。。。。。");
							}
						}
					}
				}
			}
		}
		return finalURLPath;
	}


	public static boolean makeDirs(String filePath) {
		if (filePath == null || filePath.isEmpty()) {
			return false;
		}
		File folder = new File(filePath);
		return (folder.exists() && folder.isDirectory()) ? true : folder.mkdirs();
	}

	@ResponseBody
	@RequestMapping(value = "/mp4Upload")
	public String mp4Upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {
		
		String kinds=request.getParameter("kinds");
		String type=request.getParameter("type");
		String ID=request.getParameter("ID");
		String Product=request.getParameter("Product");
		//String Root=request.getSession().getServletContext().getRealPath("");
		uploadPath=PropertyUtil.getProperty("SystemData.uploadPath")+File.separator+PropertyUtil.getProperty("SystemData.uploadPathMp4");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead")+"/"+PropertyUtil.getProperty("SystemData.uploadPathMp4");
		
		String finalUpPath=uploadPath+File.separator+kinds;
		String finalURLPath=returnUrlHead+"/"+kinds;
		
		FileUtil.makeDirs(finalUpPath);
		log.info("mp4Upload：开始"+finalUpPath);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				log.info("mp4Upload：开始"+finalUpPath);
				if (file != null) {
					String originalName=file.getOriginalFilename();
					log.info("mp4Upload：originalName"+originalName);
					if (originalName.length()>0) {
						//String originalNameReal=originalName.substring(0, originalName.lastIndexOf('.'));
						String originalNameExp=originalName.substring(originalName.lastIndexOf('.')+1, originalName.length());
						String finalName="";
						
						finalName=ID+"_"+type;
						if (Product!=null&&!Product.equals("null")&&Product.length()>0) {
							finalName+="_"+Product;
						}

						finalURLPath=finalURLPath+"/"+finalName+"."+originalNameExp;
						String path = finalUpPath+File.separator+finalName+"."+originalNameExp;
						log.info("文件上传path:" + path);
						log.info("文件上传finalURLPath："+finalURLPath);
						// 上传
						file.transferTo(new File(path));
					}
					log.info("mp4Upload：originalName:"+originalName);
					
				}

			}

		}
		return finalURLPath;
	}



	@ResponseBody
	@RequestMapping(value = "/newImgUpload.json")
	public Map<String,Object> newImgUpload(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		String kinds=request.getParameter("kinds");
		String suffixName = request.getParameter("suffixName");
		log.info("kinds=========="+kinds);

		Map<String,Object> map  =new HashMap<>();
		uploadPath=PropertyUtil.getProperty("SystemData.uploadPath")+File.separator+PropertyUtil.getProperty("SystemData.uploadPathImg");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead")+"/"+PropertyUtil.getProperty("SystemData.uploadPathImg");

		String finalUpPath=uploadPath+File.separator+kinds;
		String finalURLPath=returnUrlHead+"/"+kinds;

		FileUtil.makeDirs(finalUpPath);
		log.info("文件上传：开始"+finalUpPath);
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					//file.getInputStream();
					if("shop".equals(kinds)){
						try{
//						CommonsMultipartFile cf= (CommonsMultipartFile)file;
//						DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//						File f = fi.getStoreLocation();
							InputStream is = file.getInputStream();
							BufferedImage image = ImageIO.read(is);
							int width = image.getWidth();
							int height = image.getHeight();
							//System.out.println(width+":"+height);
							if(width!=114||height!=100){
								map.put("success",0);
							}
						}catch (Exception e) {
							e.printStackTrace();
						}
					}

					String originalName=file.getOriginalFilename();
					log.info("imgUpload"+originalName);
					if (originalName.length()>0) {
						//String originalNameReal=originalName.substring(0, originalName.lastIndexOf('.'));
						String originalNameExp=originalName.substring(originalName.lastIndexOf('.')+1, originalName.length());
						String NamebyMd5= new Date().getTime()+"";
						finalURLPath=finalURLPath+"/"+NamebyMd5+suffixName;
						String path = finalUpPath+File.separator+NamebyMd5+suffixName;
						log.info("文件上传path:" + path);
						log.info("文件上传finalURLPath："+finalURLPath);
						// 上传
						file.transferTo(new File(path));
					}
				}
			}

		}
		log.info("finalURLPath================"+finalURLPath);
		map.put("success",1);
		map.put("data",finalURLPath);
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/newMp4Upload.json")
	public Map<String,Object> newMp4Upload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {

		String kinds=request.getParameter("kinds");
		String suffixName = request.getParameter("suffixName");

		Map<String,Object> map  =new HashMap<>();
		//String Root=request.getSession().getServletContext().getRealPath("");
		uploadPath=PropertyUtil.getProperty("SystemData.uploadPath")+File.separator+PropertyUtil.getProperty("SystemData.uploadPathMp4");
		returnUrlHead=PropertyUtil.getProperty("SystemData.returnUrlHead")+"/"+PropertyUtil.getProperty("SystemData.uploadPathMp4");

		String finalUpPath=uploadPath+File.separator+kinds;
		String finalURLPath=returnUrlHead+"/"+kinds;

		FileUtil.makeDirs(finalUpPath);
		log.info("mp4Upload：开始"+finalUpPath);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				log.info("mp4Upload：开始"+finalUpPath);
				if (file != null) {
					String originalName=file.getOriginalFilename();
					log.info("mp4Upload：originalName"+originalName);
					if (originalName.length()>0) {
						//String originalNameReal=originalName.substring(0, originalName.lastIndexOf('.'));
						String originalNameExp=originalName.substring(originalName.lastIndexOf('.')+1, originalName.length());

						String finalName= new Date().getTime()+"";


						finalURLPath=finalURLPath+"/"+finalName+suffixName;
						String path = finalUpPath+File.separator+finalName+suffixName;
						log.info("文件上传path:" + path);
						log.info("文件上传finalURLPath："+finalURLPath);
						// 上传
						file.transferTo(new File(path));
					}
					log.info("mp4Upload：originalName:"+originalName);

				}

			}

		}
		log.info("finalURLPath================"+finalURLPath);
		map.put("success",1);
		map.put("data",finalURLPath);
		return map;
	}

//		@ResponseBody
//	    @RequestMapping("/wxpayBuy")
//		public void wxpayBuy(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//			 System.out.println("----收到回调---");
//			  BufferedReader reader = request.getReader();
//		         String line = "";
//		        StringBuffer inputString = new StringBuffer();
//		        try{
//		        	while ((line = reader.readLine()) != null) {
//		    	        inputString.append(line);
//		    	        }
//		    	        request.getReader().close();
//		    	        System.out.println("----接收到的报文---"+inputString.toString());
//		    	        Map<String, String> map = WXPayUtil.xmlToMap(inputString.toString());
//		    	    for(Object keyValue : map.keySet()){
//		    	        System.out.println(keyValue+"="+map.get(keyValue));
//		    	    }
//		    	    if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
//		    	        //TODO 对数据库的操作
//		    	    	Map<String,String >m=new HashMap<>();
//		    	    	m.put("return_code", "SUCCESS");
//		    	    	m.put("return_msg", "OK");
//		    	        response.getWriter().write(WXPayUtil.mapToXml(m));   //告诉微信服务器，我收到信息了，不要在调用回调action了
//		    	        System.out.println("-------------"+WXPayUtil.mapToXml(m));
//		    	    }
//		        }catch(Exception e){
//		        	e.printStackTrace();
//		        }
//		}
		
	

}
