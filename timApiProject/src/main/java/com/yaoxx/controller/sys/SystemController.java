
package com.yaoxx.controller.sys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yaoxx.base.BaseController;
import com.yaoxx.base.MyUtils;

/**

* Filename:    SystemController.java

* @version:     1.0
* @since:       JDK 1.8.0_91<br>
* @
* Create at:    2018年10月17日 下午2:42:21<br>
* Description:<br>
*	系统控制器：获取返回面包屑导航数据，修改个人信息 等接口
* <br>Modification History:<br>

* Date       |      Author      |      Version    |       Description
* ------------------------------------------------------------------

* 2018年10月17日   |     yao_x_x      |         1.0        |         1.0 Version
 
*/
@RestController
public class SystemController extends BaseController{
	
	public static final String PATH  = "G:\\data";
	
	@Autowired
	private MyUtils myUtils;
	
	@CrossOrigin
	@RequestMapping("/upload/img")
	public String upload(MultipartFile img,String result) throws IllegalStateException, IOException{
		String name = img.getOriginalFilename();
		String subffix = name.substring(name.lastIndexOf(".") + 1, name.length()); //取得文件后缀
		String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()); //文件保存进来，重新命名为当前时间
		//String filepath=request.getServletContext().getRealPath("/")+"files\\";//获取项目路径到webapp
		//指定存储路径
		String filepath = PATH+"\\img\\"+myUtils.getCurrentUserByRedis().getUid();
		File file=new File(filepath);
		if(!file.exists()){
			file.mkdirs();
		}
		result=file+"\\"+fileName+"."+subffix;
		img.transferTo(new File(result));
		return result;
	} 
	
	@CrossOrigin
	@RequestMapping("/getImg/{url}")
	public void img(@PathVariable("url")String url,HttpServletResponse response) throws IOException{
		  
		  //资源目录\img\当前用户主键\资源名称
			FileInputStream img = new FileInputStream(url);      
			int i=img.available(); 
			byte buffer[]=new byte[i];        //读数据
			img.read(buffer);         //得到向客户端输出二进制数据的对象
			response.setContentType("image/jpeg");
			OutputStream os=response.getOutputStream();         //输出数据 
			os.write(buffer);  
			os.flush();  
			os.close();   
			img.close();
	} 
	
	@CrossOrigin
	@RequestMapping("/unauth")
	@ResponseBody
	public String unauth(){
		return "访问失败";
	} 

}
