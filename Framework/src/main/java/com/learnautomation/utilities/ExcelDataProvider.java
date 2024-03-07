package com.learnautomation.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook xw;

	// need apache poi and apache poi ooxml
	public ExcelDataProvider() {
		File src = new File("File path");
		try {
			FileInputStream f = new FileInputStream(src);
			xw = new XSSFWorkbook(f);
		} catch (Exception e) {

			System.out.println("Unable to read excel file " + e.getMessage());
		}

	}

	public String getStringData(String sheetName, int rownum, int cellnum) {
		return xw.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

	public String getStringData(int sheetname, int rownum, int cellnum) {
		return xw.getSheetAt(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	}

	public double getNumericData(String sheetName, int rownum, int cellnum) {
		return xw.getSheet(sheetName).getRow(rownum).getCell(cellnum).getNumericCellValue();
	}

}
