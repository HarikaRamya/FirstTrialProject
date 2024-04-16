package com.cucumber.BDDFramework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {
	
public static void main(String args[]) throws Exception {
	
	  File file=new File("C:\\Users\\Ramya Harika\\OneDrive\\Desktop\\testing\\excelValidation.xlsx");
	  
	  FileInputStream ip=new FileInputStream(file); 
	  
	  
	  
	XSSFWorkbook wb=new XSSFWorkbook(ip); 
	  XSSFSheet sh=wb.getSheet("Sheet1");
	  
	  int lastRow=sh.getLastRowNum()-sh.getFirstRowNum(); 
	  int colNo=sh.getRow(0).getLastCellNum();
	 
	  //to get cell value
	  
	  for(int i=1; i<lastRow;i++) {
		  for(int j=1;j<colNo;j++) {
			  Cell cell=sh.getRow(i).getCell(j);
			  switch(cell.getCellType()) {
			  case NUMERIC:
				  System.out.println(cell.getNumericCellValue());
				  break;
			  case STRING:
				  System.out.println(cell.getStringCellValue());
				  break;	
			  }
		  }
	  }
	  
	  //to create a cell with some color
	  XSSFCell cell;
	  XSSFRow row=sh.createRow(2);
	  XSSFCellStyle cellStyle=wb.createCellStyle();
	  cellStyle.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
	  cellStyle.setFillPattern(FillPatternType.DIAMONDS);
	  
	 cell= row.createCell(1);
	 cell.setCellValue("Excel Value");
	 cell.setCellStyle(cellStyle);
	  
	  
}

}
