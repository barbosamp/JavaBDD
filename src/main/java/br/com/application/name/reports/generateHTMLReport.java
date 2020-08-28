package br.com.application.name.reports;

import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class generateHTMLReport {


	public static void main(String[] args) throws Exception {

		// Create ReportBuilder Object
		ReportBuilder reportBuilder = new ReportBuilder();

		String path = System.getProperty("user.dir");

		// Set output Report Dir
		reportBuilder.setReportDirectory(path + "//target//");

		// Set output report file name
		reportBuilder.setReportFileName("CucumberHTML");

		// Set Report Title
		reportBuilder.setReportTitle("My Test Report");

		reportBuilder.setReportColor("orange");

		// Enable voice control for report
		reportBuilder.enableVoiceControl();

		// Add additional info for Report
		reportBuilder.setAdditionalInfo("Environment", "My Environment");

		// Create list or report Files or Directories or URLs or JSONObject or
		// JSONString
		List<Object> cucumberJsonReports = new ArrayList<>();
		cucumberJsonReports.add(new File(path + "//target//cucumber.json"));
		cucumberJsonReports.add(new File(path + "//target//"));

		// Build your report
		reportBuilder.build(cucumberJsonReports);

	}

}

