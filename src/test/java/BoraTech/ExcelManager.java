package BoraTech;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class ExcelManager {

	public static void main(String[] args) {
				
		
		XSSFWorkbook workbook = openWorkbook("TestData20190730194121277");
		XSSFSheet sheet = workbook.getSheetAt(0);
//		int rowNum1 = sheet.getLastRowNum();
		int rowNum = sheet.getPhysicalNumberOfRows();
		
		boolean found = false;
		String newLastname = "Talantov";
		for (int i = 0; i < rowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			
			for (int j = 0; j < cellNum; j++) {
				XSSFCell cell = row.getCell(j);
				String cellValue = cell.getStringCellValue();
				if (cellValue.equalsIgnoreCase("Emmerich")) {
					cell.setCellValue(newLastname);
					row.getCell(j + 1).setCellValue(row.getCell(j - 1).getStringCellValue() + "." + newLastname + "@gmail.com");
					found = true;
					break;
				}
			}	
			if (found) break;
		}
		
		saveAndCloseWorkbook("TestData20190730194121277", workbook);
		
	}

	
	
	
	public static void createTestDataToExcel() {
		Faker faker = new Faker();
		String timeStamp = getTimeStamp();
		String fileName = "TestData" + timeStamp;
		
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("CheatSheet");
			
			XSSFRow row;
			// Generating column names
			row = sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("First name");
			row.createCell(2).setCellValue("Last name");
			row.createCell(3).setCellValue("Email");
			row.createCell(4).setCellValue("Phone number");
			
			for (int i = 1; i < 21; i++) {
				String firstName = faker.name().firstName();
				String lastName = faker.name().lastName();
				String phoneNumber = faker.phoneNumber().phoneNumber();
				String email = firstName + "." + lastName + "@gmail.com";
				row = sheet.createRow(i);
				row.createCell(0).setCellValue(i+"");
				row.createCell(1).setCellValue(firstName);
				row.createCell(2).setCellValue(lastName);
				row.createCell(3).setCellValue(email);
				row.createCell(4).setCellValue(phoneNumber);
			}
			
			workbook.write(fos);
			fos.close();
			System.out.println("File created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTimeStamp() {
		Date myDate = new Date();
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(myDate);
		return timeStamp;
	}
	
	public static XSSFWorkbook openWorkbook(String fileName) {
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			System.out.println("File opened successfully");
			return workbook;
		} catch (Exception e) {
			System.out.println("Something went wrong while opening the file - "+ fileName);
			e.printStackTrace();
			return null;
		}
	}
	
	public static XSSFSheet getSheetFromBook(String fileName, String sheetName) {
		XSSFWorkbook workbook = openWorkbook(fileName);
		return workbook.getSheet(sheetName);
	}
	
	public static void saveAndCloseWorkbook(String fileName, XSSFWorkbook workbook) {
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
			System.out.println("File saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createWorkbook(String fileName) {
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook.write(fos);
			fos.close();
			System.out.println("File created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
