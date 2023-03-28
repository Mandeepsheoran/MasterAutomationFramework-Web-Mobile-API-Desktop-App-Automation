package org.igt.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.igt.constants.FrameworkConstant;
import org.igt.customexceptions.FrameworkException;
import org.igt.customexceptions.InvalidExcelFilePathException;

/**
 * Class having methods to extract test data from external sheet.
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class ExcelUtils {

	private ExcelUtils() {		
	}	
	/**
	 * Method to read complete data from excel sheet using apache POI and return a list of this test data.
	 * @param sheetname
	 * @return
	 */
	public static List<Map<String,String>> getTestDetails(String sheetname){
		List<Map<String,String>> list = null;
		try(FileInputStream fs= new FileInputStream(FrameworkConstant.getExcelpath())) {	
			XSSFWorkbook workbook = new XSSFWorkbook(fs);		
			XSSFSheet sheet = workbook.getSheet(sheetname);
			int rownum = sheet.getLastRowNum();
			int colmncount = sheet.getRow(0).getLastCellNum();
			Map<String,String> map = null;
			list = new ArrayList<>();
			for(int i=1;i<=rownum;i++) { 
				map = new HashMap<>();
				for(int j=0;j<colmncount;j++) {
					String key= sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key,value);					 					 
				}
				list.add(map);
			}			 
		} catch (FileNotFoundException  e) {
			StackTraceElement[] exc = e.getStackTrace();
			exc[0] = new StackTraceElement("org.igt.utils.ExcelUtils", "getTestDetails", "ExcelUtils.java", 24);
			e.setStackTrace(exc);
			throw new InvalidExcelFilePathException("Error while reading the excel file", e);
		} catch (IOException e) {		
			throw new FrameworkException("Input output exception while reading the file", e);
		}
		return list;			
	}

}
