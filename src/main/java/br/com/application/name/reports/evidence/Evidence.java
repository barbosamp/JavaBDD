package br.com.application.name.reports.evidence;

import br.com.application.name.reports.LocalDateFormatter;
import cucumber.api.Scenario;
import junit.framework.TestCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class Evidence {

	private final String project = "Your Store";
	private final String environment = "Production";
	private String ctName;
	private String cycle;
	private String tester;
	private String ctNumber;
	protected List<SeleniumEvidence> evidenceList;
	private LocalDateFormatter dateFormatter = new LocalDateFormatter();
	private String errors = null;

	public Evidence(List<SeleniumEvidence> evidenceList) {
		this.evidenceList = evidenceList;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public void setCiclo(String cycle) {
		this.cycle = cycle;

	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public void setCtNumber(String ctNumber) {
		this.ctNumber = ctNumber;
	}

	public void generateEvidence(Scenario scenario) throws IOException {
		EvidenceReport report = new EvidenceReport(evidenceList, "CT - " + ctNumber + "_" + dateFormatter.date(),
				tester, project, errors, environment, ctName, cycle);
		GenerateEvidenceReport.generareEvidenceReport(report, EvidenceType.DOC, scenario);
	}

	/**
	 * Set error if occurs in any catch
	 */
	public void setError(Throwable t, WebDriver driver) {
		try {
			evidenceList.add(new SeleniumEvidence(t.getLocalizedMessage(), getScreenshotAsBase64(driver)));
			errors = t.toString();
			TestCase.fail(t.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns a screenshot in Base64
	 */
	private String getScreenshotAsBase64(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	}

}
