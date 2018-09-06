package com.socodd.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.socodd.entities.Zone;

public class XListExcelView extends AbstractExcelView {
	
	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HSSFSheet excelSheet = workbook.createSheet("X List");
		
		setExcelHeader(excelSheet);
		
		
		List<?> xList = (List) model.get("xlist");
		setExcelRows(excelSheet,xList);
		
	}
	
	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Code");
		excelHeader.createCell(2).setCellValue("Nom");
	}
	
	
	public void setExcelRows(HSSFSheet excelSheet, List xList){
		int record = 1;
		
		
		for ( Object lst : xList) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(((Zone)lst).getId());
			excelRow.createCell(1).setCellValue(((Zone)lst).getCode());
			excelRow.createCell(2).setCellValue(((Zone)lst).getNom());
		}
	}
	
}
