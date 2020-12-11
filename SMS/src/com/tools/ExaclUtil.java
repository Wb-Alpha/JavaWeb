//package com.tools;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//
//import com.po.Salary;
//import com.service.SalaryService;
//
//public class ExaclUtil {
//	private SalaryService salaryService;
//	
//	public static void exportToExcal(HttpServletResponse response) {
//		response.setCharacterEncoding("UTF-8");
//		List<Salary> list=	salaryService.findAllSalary();
//
//		//创建excel文件
//		HSSFWorkbook wbook=new HSSFWorkbook();
//		//创建sheet页
//		HSSFSheet sheet=wbook.createSheet("工资信息报表");
//		//创建标题行
//		HSSFRow titleRow = sheet.createRow(0);
//		titleRow.createCell(0).setCellValue("工号");
//		titleRow.createCell(1).setCellValue("姓名");
//		titleRow.createCell(2).setCellValue("职位编号");
//		titleRow.createCell(3).setCellValue("职位名称");
//		titleRow.createCell(4).setCellValue("所属部门");
//		titleRow.createCell(5).setCellValue("基本工资");
//		titleRow.createCell(6).setCellValue("奖金");
//		titleRow.createCell(7).setCellValue("总工资");
//
//		//将数据放入excel
//		for (Salary wsalary:list) {
//		   HSSFRow dataRow=sheet.createRow(sheet.getLastRowNum()+1);
//		   dataRow.createCell(0).setCellValue(wsalary.getWno());
//		   dataRow.createCell(1).setCellValue(wsalary.getWname());
//		   dataRow.createCell(2).setCellValue(wsalary.getJno());
//		   dataRow.createCell(3).setCellValue(wsalary.getJname());
//		   dataRow.createCell(4).setCellValue(wsalary.getJdept());
//		   dataRow.createCell(5).setCellValue(wsalary.getJsalary());
//		   dataRow.createCell(6).setCellValue(wsalary.getJbonus());
//		   dataRow.createCell(7).setCellValue(wsalary.getTotal());
//
//		}
//
//		//下载
//		response.setContentType("application/octet-stream;charset=utf-8");
//		//设置文件名
//
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String dateNowStr = sdf.format(d);
//		response.setHeader("Content-Disposition","attachment;filename="+new String((dateNowStr+"工资信息报表").getBytes(),"iso-8859-1")+".xls");
//		OutputStream outputStream=response.getOutputStream();
//		wbook.write(outputStream);
//		outputStream.flush();
//		outputStream.close();
//	}
//}
