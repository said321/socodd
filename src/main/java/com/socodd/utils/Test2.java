package com.socodd.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.socodd.entities.Zone;

public class Test2 {
	
	
	public static void main(String[] args) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet excelSheet = workbook.createSheet("X_List_Zones");
		
		Zone z1 = new Zone("z1","zone1");
		z1.setId(1);
		
		Zone z2 = new Zone("z2","zone2");
		z2.setId(2);
		
		Zone z3 = new Zone("z3","zone3");
		z3.setId(3);
		
		List<Zone> zones = new ArrayList<Zone>();

		zones.add(z1);
		zones.add(z2);
		zones.add(z3);

		
		setExcelHeader(excelSheet);
		setExcelRows(excelSheet, zones);
		
		System.out.println("It's Done : " + workbook.getSheet("X_List_Zones").getRow(1).getCell(2));
		
	}
	
	public static void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Id");
		excelHeader.createCell(1).setCellValue("Code");
		excelHeader.createCell(2).setCellValue("Nom");
	}
	
	
	public static void setExcelRows(HSSFSheet excelSheet, List<Zone> xList){
		
		int record = 1;
		
		for ( Object lst : xList) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(((Zone)lst).getId());
			excelRow.createCell(1).setCellValue(((Zone)lst).getCode());
			excelRow.createCell(2).setCellValue(((Zone)lst).getNom());
		}
	}
	
}
