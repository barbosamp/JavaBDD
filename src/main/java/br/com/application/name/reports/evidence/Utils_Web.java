package br.com.application.name.reports.evidence;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Utils_Web {
	
	/**
	 * @throws Exception 
	 */


	public void addReport (List<SeleniumEvidence> evidenceList, WebDriver driver) throws Exception {
		evidenceList.add(new SeleniumEvidence("", takeScreenshot(driver)));
		
	}
	
	public void addReportScroll (List<SeleniumEvidence> evidenceList, WebDriver driver) throws Exception {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,720)", "");	
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("id('topButtonRow')/input[3]")));
		evidenceList.add(new SeleniumEvidence("", takeScreenshot(driver)));
	}
	
	
	public void addReportMS (List<SeleniumEvidence> evidenceList, WebDriver driver, String mensagem) throws Exception {
		evidenceList.add(new SeleniumEvidence("RESULTADO OBTIDO: "+mensagem+"", takeScreenshot(driver)));
		
	}
	
	public void addReportScrollMS (List<SeleniumEvidence> evidenceList, WebDriver driver, String mensagem) throws Exception {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,720)", "");	
//		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("id('topButtonRow')/input[3]")));
		evidenceList.add(new SeleniumEvidence("RESULTADO OBTIDO: "+mensagem+"", takeScreenshot(driver)));
	}

	
	public String takeScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}


}
