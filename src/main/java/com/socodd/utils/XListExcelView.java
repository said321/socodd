//package com.socodd.utils;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.web.servlet.view.document.AbstractExcelView;
//
//public class XListExcelView extends AbstractExcelView {
//
//	@Override
//	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
//			HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//
//		HSSFSheet excelSheet = workbook.createSheet("X List");
//		setExcelHeader(excelSheet);
//		
//		List xList = (List) model.get("xlist");
//		setExcelRows(excelSheet,xList);
//		
//	}
