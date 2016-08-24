package com.pingjin.springMvc.web;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pingjin.springMvc.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/regist")
	public String regist(){
		return "user/regist";
	}
	
	/*@RequestMapping("{userId}")
	public String showDetail(@PathVariable("userId") String id){
		System.out.println(id);
		return "user/regist";
	}*/
	
	@ResponseBody
	@RequestMapping("/image")
	public byte[] showPicture() throws Exception{
		/*File file=new File("F:\\694323.jpg");*/
		Resource resource=new FileSystemResource("F:/694323.jpg");
		/*FileInputStream in=new FileInputStream(file);*/
		byte[] fileData=FileCopyUtils.copyToByteArray(resource.getFile());
		return fileData;
	}
	
	@RequestMapping("/handleone")
	public String handleOne(HttpEntity<String> httpEntity){
		long contentLen=httpEntity.getHeaders().getContentLength();
		System.out.println(contentLen);
		System.out.println(httpEntity.getBody());
		return "user/regist";
	}
	
	@RequestMapping("/imageOther")
	public ResponseEntity<byte[]> showPictureOther() throws Exception{
		File file=new File("F:\\694323.jpg");
		byte[] data=FileCopyUtils.copyToByteArray(file);
		ResponseEntity<byte[]> responseEntity=new ResponseEntity<byte[]>(data, HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping("/userMessage")
	public String showUserMessage(@ModelAttribute("me") User user){
		user.setId(12);
		user.setUsername("平进");
		user.setPassword("123456");
		System.out.println("ddd");
		System.out.println(user.getPassword());
		return "user/regist";
	}
	
	@RequestMapping("/userMessageOther")
	public String showUserMessageTwo(ModelMap map){
		User user=new User();
		user.setId(2013441477);
		user.setUsername("平进");
		user.setPassword("pingjin100");
		/*map.put("hello", "Hello ddd");
		map.put("xx", "我是你的");*/
		map.addAttribute("hello", "I am very good");
		map.addAttribute("me", user);
		return "user/regist";
	}
	
	//EXCEL
	@RequestMapping("/showUserListByXls")
	public String showUserListInExcel(ModelMap modelMap){
		User user1=new User();
		user1.setUsername("sadcx");
		user1.setRealName("张三");
		user1.setBirthday(new Date());
		User user2=new User();
		user2.setUsername("kjjsd");
		user2.setRealName("李四");
		user2.setBirthday(new Date());
		List<User> userList=new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		modelMap.addAttribute("userList", userList);
		return "userListExcel";
	}
	
	//XML
	@RequestMapping("/showUserListByXml")
	public String showUserListInXML(ModelMap modelMap){
		User user1=new User();
		user1.setUsername("aaa");
		user1.setRealName("李四");
		user1.setBirthday(new Date());
		User user2=new User();
		user2.setUsername("bbb");
		user2.setRealName("王麻子");
		user2.setBirthday(new Date());
		List<User> userList=new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		modelMap.addAttribute("userList", userList);
		return "userListXML";
	}
	
	//JSON
	@RequestMapping("/showUserListByJson")
	public String showUserListInJson(ModelMap modelMap) {
		User user1 = new User();
		user1.setUsername("aaa");
		user1.setRealName("李四");
		user1.setBirthday(new Date());
		User user2 = new User();
		user2.setUsername("bbb");
		user2.setRealName("王麻子");
		user2.setBirthday(new Date());
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		modelMap.addAttribute("userList", userList);
		return "userListJson";
	}
}
