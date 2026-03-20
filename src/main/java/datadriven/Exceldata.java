package datadriven;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Exceldata {

	@Test
	public void readExcel() {
		try {
			FileInputStream fs = new FileInputStream(
					new File("C:\\Users\\OM SATAPATHY\\Downloads\\employee data.xlsx"));
			
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheetAt(0);
			for(int i=0; i< sh.getLastRowNum();i++) {
				XSSFRow rw = sh.getRow(i);
				
				System.out.println(rw.getCell(i).getStringCellValue());
			}
			
	
		} catch (Exception e) {

		}

	}
}
