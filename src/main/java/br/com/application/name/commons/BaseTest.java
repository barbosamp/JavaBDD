package br.com.application.name.commons;

import br.com.application.name.configuration.WebApplication;
import br.com.application.name.reports.evidence.Evidence;
import br.com.application.name.reports.evidence.SeleniumEvidence;
import cucumber.api.Scenario;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class BaseTest {

	protected static WebDriver webDriver;
	protected static List<SeleniumEvidence> evidenceList = new ArrayList<SeleniumEvidence>();
	protected static WebDriverWait wait;
	protected static WebDriverWait shortWait;
	protected static boolean initialized;
	protected static DataGenerator dataGenerator = new DataGenerator();

	public static Evidence evidence;

	public void setCtName(String ctName) {
		evidence.setCtName(ctName);
	}

	public void setCiclo(String cycle) {
		evidence.setCiclo(cycle);

	}

	public void setTester(String tester) {
		evidence.setTester(tester);
	}

	public void setCtNumber(String ctNumber) {
		evidence.setCtNumber(ctNumber);
	}

	public void initializeEvidence() {
		BaseTest.evidence = new Evidence(evidenceList);
	}

	/**
	 * Inicializa o {@code WebDriver} e o {@code WebDriverWait}
	 */
	protected void initializeWebApplication(WebApplication webApplication) {

		webDriver = webApplication.getDriver();
		webDriver.manage().window().fullscreen();
		webDriver.get(PropertiesManager.getPropertiesValue("URL_QA"));
		wait = new WebDriverWait(webDriver, 80);
	}

	/**
	 * Método para adicionar na evidência web
	 * 
	 * @param mensagem
	 */
	protected void addEvidenciaWeb(String mensagem) {
		try {
			evidenceList.add(new SeleniumEvidence("RESULTADO OBTIDO: " + mensagem + "", takeScreenshot(webDriver)));
		} catch (Exception e) {
			System.out.println("Erro ao adicionar na evidência: " + e.getMessage());
			e.printStackTrace();
		}

	}

	protected void clearEvidenceList() {
		evidenceList.clear();
	}

	/**
	 * Gera evidência
	 */
	protected void generateEvidence(Scenario scenario) {
		try {
			evidence.generateEvidence(scenario);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * fecha o driver web
	 */
	protected static void closeWeb() {
		webDriver.quit();
	}

	/**
	 * tira prints
	 * 
	 * @param driver
	 * @return
	 */
	private String takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}

}
