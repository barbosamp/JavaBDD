
package br.com.application.name.configuration;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.commons.CredentialsUsers;
import br.com.application.name.mobile.bean.enums.App;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 *
 * @author Aleksander Ramos
 * @author Filipe Mapelli Siqueira
 * @since 2018-02-08
 *
 */
public class Hooks extends BaseTest {


	@Before(value = "@cockpitqa")
	public void beforeScenarioMobileCockpitQa() {
		System.out.println("Teste execução Hooks Mobile");
		setUserApplicationUsers(CredentialsUsers.USER_MOBILE_QA);
	}


	@Before(value = "@cockpit")
	public void beforeScenarioMobileCockpit() {
		System.out.println("Teste execução Hooks Mobile");
		setUserApplicationUsers(CredentialsUsers.USER_MOBILE_PREPROD);
	}

	@Before(value = "@webmobile")
	public void beforeWebmobile() {
		System.out.println("Teste execução web/mobile");
		setUserApplicationUsers(CredentialsUsers.USER_MOBILE_QA);
	}

	@Before(value = "@webSales")
	public void beforeWebMobile() {
		System.out.println("Teste execução web/mobile");
		setUserApplicationUsers(CredentialsUsers.USER_MOBILE_PREPROD);
	}

	@Before(value = "@cockpitNew")
	public void beforeScenarioMobileCockpitNew() {
		System.out.println("Teste execução Hooks Mobile");
		initializeMobileApplicationNew(App.COCKPIT);
		setUserApplicationUsers(CredentialsUsers.USER_MOBILE_PREPROD);
	}

	@Before("@triangulo")
	public void beforeTriangulo(){
		System.out.println("Teste Triangulo");
		initializeMobileApplicationNew(App.APP);
	}

	@Before(value = "@web")
	public void beforeScenarioWebWindows() {
		System.out.println("Teste execução Hooks Web");
		initializeWebApplication(Web.CHROME_WINDOWS);
	}

	@After(value = "@cockpit")
	public void afterScenarioCockpit(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
	}
	
	@After(value = "@cockpitqa")
	public void beforeScenarioMobileCockpitQa(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
	}

	@After(value = "@cockpitNew")
	public void afterScenarioCockpitNew(Scenario scenario) {
		generateEvidence(scenario);
		closeMobile();
		evidenceList.clear();
	}

	@After(value = "@web")
	public void afterScenarioWeb(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
		closeWeb();
	}

	@After(value = "@pocmobile")
	public void closeDriver(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
		closeWeb();
	}

	@After(value = "@webSales")
	public void closeWebSales(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
		closeWeb();
	}

	@After(value = "@cockpitpreprod")
	public void afterScenarioCockpitPreprod(Scenario scenario) {
		generateEvidence(scenario);
		evidenceList.clear();
	}

}