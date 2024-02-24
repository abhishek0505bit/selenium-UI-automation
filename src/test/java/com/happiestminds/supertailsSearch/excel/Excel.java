package com.happiestminds.supertailsSearch.excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//This class is responsible for reading data from an Excel file
public class Excel {

	// method to get data from excel file
	public static String getDataFromExcel() {
		String phoneNumber = "";
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Book 7.xlsx";// path of excel file

		String sheetName = "Sheet1";// name of the sheet containing the data

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);// get the sheet

			DataFormatter dataFormatter = new DataFormatter();// data formatter to format cell values

			// the phone number is in a 0th column
			int phoneColumnIndex = 0; // index of the phone number column

			// Get the phone number from the first data row
			Row dataRow = sheet.getRow(1); // the data starts from the second row

			// if row 1 contains any data then
			if (dataRow != null) {

				// phone cell = get the data from first row with column index = 0
				Cell phoneCell = dataRow.getCell(phoneColumnIndex);

				// if phone cell data is not null then format its cell value
				if (phoneCell != null) {

					// dataFormatter ensures that the retreived cell values are appropriately
					// formatted and presented as a string regardless of the original data type in
					// the excel
					phoneNumber = dataFormatter.formatCellValue(phoneCell);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return phoneNumber;
	}

}

// if want to include header row
// after line 25 : Row headerRow = sheet.getRow(0);// get the header row 
