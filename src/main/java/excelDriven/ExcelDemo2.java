package excelDriven;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo2 {
	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream("C:\\Users\\QQA0416\\ExcelSheetForRestAssured\\BookAPITest.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		int sheetcount = workbook.getNumberOfSheets();
		System.out.println(sheetcount);

		for (int i = 0; i < sheetcount; i++) {
			if (workbook.getSheetName(i).toString().equalsIgnoreCase("Post")) {
				System.out.println("sheet found");
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.rowIterator();

				int cellno = 0, cellIndex = 0;

				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				while (cells.hasNext()) {
					Cell cellvalue = cells.next();

					if (cellvalue.getStringCellValue().equalsIgnoreCase("Testcases")) {
						cellIndex = cellno;
					}
					cellno++;
				}

				// to find test case name from selected column

				while (rows.hasNext()) {
					Row rowvalue = rows.next();
					if (rowvalue.getCell(cellIndex).getStringCellValue().toString().equalsIgnoreCase("bookTwo")) {
						Iterator<Cell> celldata = rowvalue.cellIterator();

						while (celldata.hasNext()) {
							Cell celldatavalue = celldata.next();

							if (celldatavalue.getCellType() == CellType.STRING) {
								System.out.println(celldatavalue.getStringCellValue());
							} else {
								String val = NumberToTextConverter.toText(celldatavalue.getNumericCellValue());
								System.out.println(val);
							}
						}
					}

				}

			}
		}

	}

}
