package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	
	@Test
	public void readExcelfile() throws IOException {

		try {
			String path = "./testData/userDetails.xlsx";
		    FileInputStream fis = new FileInputStream(path);
	        Workbook wb = new XSSFWorkbook(fis);

	        Sheet sh = wb.getSheetAt(0);

	        int rowCount = sh.getLastRowNum();

	        for (int i = 0; i <= rowCount; i++) {

	            Row row = sh.getRow(i);

	            if (row != null) {
	                int colCount = row.getLastCellNum();

	                for (int j = 0; j < colCount; j++) {

	                    Cell cell = row.getCell(j);

	                    if (cell != null) {
	                        System.out.print(cell.toString() + " | ");
	                    }
	                }
	                System.out.println();
	            }
	        }

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
