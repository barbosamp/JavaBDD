
package br.com.application.name.configuration;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.enums.Web;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest {

	@Before(value = "@web")
	public void beforeScenarioWebWindows() {
		System.out.println("Teste execução Hooks Web");
		initializeWebApplication();
	}


	@After(value = "@web")
	public void afterScenarioWeb(Scenario scenario) {
		closeWeb();
		System.out.println("Gerando Evidencias....");
		generateEvidence(scenario);
		evidenceList.clear();

	}

}