package br.com.application.name.reports;

import br.com.application.name.reports.model.TestData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Query {

	public static List<TestData> listaTestData = new ArrayList<>();

	public static void insert(){

		HSSFWorkbook workbook = new HSSFWorkbook();

		HSSFSheet sheet = workbook.createSheet("Regressivo");
		Row row = sheet.createRow((short) 0);
		row.createCell(0).setCellValue("Project");
		row.createCell(1).setCellValue("Date");
		row.createCell(2).setCellValue("Step Name");
		row.createCell(3).setCellValue("Status");
		row.createCell(5).setCellValue("Total Passed");
		row.createCell(6).setCellValue("Total Failed");
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		int rowlength = 1;
		int totalPassed = 0;
		int totalFailed = 0;
		
		for (TestData teste : listaTestData) {

			row = sheet.createRow(rowlength++);
			int cellnum = 0;
			Cell cellDataExecucao = row.createCell(cellnum++);
			cellDataExecucao.setCellValue(teste.getProject());

			Cell dateExecution = row.createCell(cellnum++);
			dateExecution.setCellValue(dateFormat.format(date));

			Cell stepName = row.createCell(cellnum++);
			stepName.setCellValue(teste.getStepName());

			switch (teste.getStatus().toUpperCase()) {
			case "PASSED":
				Cell cellPassed = row.createCell(cellnum++);
				cellPassed.setCellValue(teste.getStatus().toUpperCase());
				totalPassed ++;
				break;
			case "FAILED":
				Cell cellFailed = row.createCell(cellnum++);
				cellFailed.setCellValue(teste.getStatus().toUpperCase());
				totalFailed ++;
				break;
			}

		}
		Cell passed = row.createCell(5);
		passed.setCellValue(totalPassed);
		Cell failed = row.createCell(6);
		failed.setCellValue(totalFailed);
		
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String path = "report/excel-report/RelatorioRegressivo_"+date+"_.xls";
		ExcelReport.path = path;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File(path));
			workbook.write(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
