package com.pingjin.springMvc.web;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.pingjin.springMvc.model.User;

public class UserListExcelView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//Excel文档名称必须编码为iso8859-1，否则为显示乱码
		//不同浏览器不同效果 可能是下载也可能是直接页面显示
		response.setHeader("Content-Disposition", "inline;filename="+new String("用户列表.xls".getBytes(),"iso8859-1"));
		List<User> userList=(List<User>) model.get("userList");
		HSSFSheet sheet=workbook.createSheet("users");
		HSSFRow header=sheet.createRow(0);
		header.createCell(0).setCellValue("账号");
		header.createCell(1).setCellValue("姓名");
		header.createCell(2).setCellValue("生日");
		int rowNum=1;
		for(User user:userList){
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(user.getUsername());
			row.createCell(1).setCellValue(user.getRealName());
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			row.createCell(2).setCellValue(format.format(user.getBirthday()));
		}
	}

}
