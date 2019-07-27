package BoraTech;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {

	public static void main(String[] args) {
		
		String fileName = "Another File";
		
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("CheatSheet");
			
			XSSFRow row;
			for (int i = 0; i < 12; i++) {
				row = sheet.createRow(i);
				for (int j = 0; j < 6; j++) {
					row.createCell(j).setCellValue("Hello");;
				}
			}
			
			workbook.write(fos);
			fos.close();
			System.out.println("File created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void createSheet(String fileName) {
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			// created bunch of sheets, rows, cells, and inputed data
			workbook.write(fos);
			fos.close();
			System.out.println("File created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createWorkbook(String fileName) {
		try {
			File file = new File("target/ExcelFiles/" + fileName + ".xlsx");
			FileOutputStream fos = new FileOutputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook();
			// created bunch of sheets, rows, cells, and inputed data
			workbook.write(fos);
			fos.close();
			System.out.println("File created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
