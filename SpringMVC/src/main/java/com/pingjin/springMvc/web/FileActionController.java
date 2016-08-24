package com.pingjin.springMvc.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileActionController {

	@RequestMapping("/uploadPage")
	public String uploadPage(){
		return "file/uploadPage";
	}
	
	@RequestMapping("/upload")
	public void fileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) throws Exception{
		System.out.println(name);
		if(file.isEmpty()){
			System.out.println("文件为空");
		}else{
			file.transferTo(new File("F:/"+file.getOriginalFilename()));
			System.out.println("文件上传成功");
		}
	}
	
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws Exception{
		String filename="F:/demo.doc";
		File file=new File(filename);
		HttpHeaders headers = new HttpHeaders();  
		String fileName=new String("test.doc".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName); 
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED);
	}
}
