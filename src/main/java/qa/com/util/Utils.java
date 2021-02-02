package qa.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils {
	
	public static String excelfile_path="C:\\Users\\pammi.rani\\Documents\\ExcelSheet.xlsx";
	
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	static XSSFRow row;
	static XSSFCell col;
	static FileInputStream fi;
	
	
	public static Object[][] getReadData(String sheetname) {
		
		try {
			fi=new FileInputStream(excelfile_path);
		    wb=new XSSFWorkbook(fi);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		 ws=wb.getSheet(sheetname);
		 int row=ws.getLastRowNum();
		 int col=ws.getRow(0).getLastCellNum();
		 
		 Object[][] data=new Object[row][col];
		 for(int r=0;r<row;r++) {
			 for(int c=0;c<col;c++) {
				 data[r][c]=ws.getRow(r+1).getCell(c).toString();
			 }
		 }
		 
		 return data;
		
	}

}
