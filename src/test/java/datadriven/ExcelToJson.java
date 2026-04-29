package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ExcelToJson {

	@Test
	public void readexcelToJson() {

		try {
			String excelPath = "./testData/userDetails.xlsx";
			String jsonPath = "./testData/userDetails.json";

			FileInputStream fis = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);

			JSONArray jsonArray = new JSONArray();
			DataFormatter formatter = new DataFormatter(); // ⭐ Important

			Row headerRow = sheet.getRow(0);
			int colCount = headerRow.getLastCellNum();
			JSONObject obj = new JSONObject();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				for (int j = 0; j < colCount; j++) {

					String key = formatter.formatCellValue(headerRow.getCell(j)).trim();
					String value = formatter.formatCellValue(row.getCell(j)).trim();

					obj.put(key, value);
				}

				jsonArray.put(obj);
			}

			jsonArray.put(obj);
			FileWriter file = new FileWriter(jsonPath);
			file.write(jsonArray.toString(4)); // pretty print
			file.close();

			wb.close();
			fis.close();

			System.out.println("✅ Excel converted to JSON successfully!");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
