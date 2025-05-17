package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import constants.Constant;

public class ExcelUtility {
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	public static FileInputStream f;

	public static String readStringData(int i, int j, String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(i);
		XSSFCell c = r.getCell(j);
		return c.getStringCellValue();
	}

	public static String readIntegerData(int i, int j, String sheet) throws IOException {
		f = new FileInputStream(Constant.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(i);
		XSSFCell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);
	}
}
