package excelDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrive {
	public  static ArrayList<String> getData(String testCaseName) throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\QQA0416\\ExcelSheetForRestAssured\\ExcelDrivenData.xlsx");// for file path
		XSSFWorkbook workbook = new XSSFWorkbook(file); // find workbook
		// count nor of sheet
		int sheetcount = workbook.getNumberOfSheets();
		System.out.println("Nor of sheet =" + sheetcount);
		// goto particular sheet
		ArrayList<String> testdata = new ArrayList<String>(); // to store a row data
		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Sheet1")) // to match particular sheet
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify testcases column by scaning entire first row
				System.out.println(sheet.toString());
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstrow = rows.next();
				// System.out.println(firstrow);
				int cellno = 0; // to traverse through all column present in that row
				int cellIndexForTestcase = 0; // to get index for our input eg. Testcases or data1
				Iterator<Cell> cell = firstrow.cellIterator(); // row was collection of cell
				while (cell.hasNext()) {
					Cell cellvalue = cell.next();
					System.out.println(cellvalue);
					if (cellvalue.getStringCellValue().equalsIgnoreCase("Testcases")) {
						cellIndexForTestcase = cellno;
					}
					cellno++;
				}
				System.out.println(cellIndexForTestcase);

				// Once column was identified then sczn entire testcases column to identify
				// purchase testcase row
				while (rows.hasNext()) {
					Row rowvalue = rows.next();
					if (rowvalue.getCell(cellIndexForTestcase).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// System.out.println(rowvalue.getCell(cellIndexForTestcase));
						// after you find purchase testcase row= pull all data from that row and feed
						// into test
						Iterator<Cell> testcasecellvalue = rowvalue.cellIterator();
						while (testcasecellvalue.hasNext()) {
							// String value = testcasecellvalue.next().getStringCellValue();//to print on
							// System.out.print(" "+value); // print in consol
							Cell gettestcasecellvalue = testcasecellvalue.next();
							
							if(gettestcasecellvalue.getCellType()==CellType.STRING) // to check cell data string if it string then add in arraylist
							{
							testdata.add(gettestcasecellvalue.getStringCellValue()); // adding data in arraylist
						    }
							
							else                     // to convert value from numeric to string
							{
								testdata.add(NumberToTextConverter.toText(gettestcasecellvalue.getNumericCellValue()));
							}
						}

					}

				}

			}
		}
		return testdata;

	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> getData = dataDrive.getData("login");
		Iterator<String> ir = getData.iterator();
		while(ir.hasNext())
		{
			System.out.println(ir.next());
		}
		
		
		
		
		
		
	}

}
