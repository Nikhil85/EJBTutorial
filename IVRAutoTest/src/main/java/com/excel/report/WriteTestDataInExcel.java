package com.excel.report;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteTestDataInExcel {

	HSSFWorkbook workbook;
	HSSFSheet sheet;
	private static Logger logger = Logger.getLogger(WriteTestDataInExcel.class);
	String excelName;

	public WriteTestDataInExcel() {
		// TODO Auto-generated constructor stub
	}

	public WriteTestDataInExcel(String excelName) {

		// TODO Auto-generated constructor stub
		logger.debug("-------------Initialized WriteTestDataInExcel Class-----------");
		workbook = new HSSFWorkbook();
		this.excelName = excelName;
		sheet = workbook.createSheet("Sample sheet");
	}

	public void setDataInRowAndColumn(List<Map<String, Object[]>> list) {

		logger.debug("-------------Inside WriteTestDataInExcel start setDataInRowAndColumn Method -----------");

		try {

			for (Map<String, Object[]> mapData : list) {

				Set<String> keyset = mapData.keySet();

				int rownum = 0;

				for (String key : keyset) {
					HSSFRow row = sheet.createRow(rownum++);
					Object[] objArr = mapData.get(key);
					short cellnum = 0;
					for (Object obj : objArr) {
						HSSFCell cell = row.createCell(cellnum++);
						if (obj instanceof Date)
							cell.setCellValue((Date) obj);
						else if (obj instanceof Boolean)
							cell.setCellValue((Boolean) obj);
						else if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Double)
							cell.setCellValue((Double) obj);

					}
				}

			}

			FileOutputStream out = new FileOutputStream(new File("D:\\"
					+ excelName + ".xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");

		} catch (Exception e) {
			logger.debug("-------------Inside WriteTestDataInExcel Inside Catch block -----------");
			logger.debug(e.getStackTrace());
			System.out.println(e.getStackTrace());
			e.printStackTrace();
		}
		logger.debug("-------------Inside WriteTestDataInExcel start setDataInRowAndColumn Method -----------");
	}

}
