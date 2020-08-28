package br.com.application.name.enums;

import br.com.application.name.interfaces.WebApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public enum Web implements WebApplication {
	
	CHROME {

		@Override
		public WebDriver getDriver() {
//			ChromeOptions op = new ChromeOptions();
//			op.setHeadless(true);
			System.setProperty("webdriver.chrome.driver","chromedriver");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			return new ChromeDriver(options);
		}
		
	},
	
	CHROME_WINDOWS {

		@Override
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver","chromewindows/chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			return new ChromeDriver(options);
		}
		
	},
	
	FIREFOX {

		@Override
		public WebDriver getDriver() {
			System.setProperty("webdriver.gecko.driver", "geckodriver");
			return new FirefoxDriver();
		}
		
	}

}
