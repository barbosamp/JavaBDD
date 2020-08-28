package br.com.application.name.reports.evidence.funcionalidade;

import br.com.application.name.commons.BaseTest;
import cucumber.api.DataTable;

import java.util.Map;

public class ParametrosEvidenciaFuncionalidade extends BaseTest {

	public void executandoTeste(DataTable params) {

		super.initializeEvidence();

		for (Map<String, String> map : params.asMaps(String.class, String.class)) {
			super.setCtNumber(map.get("Numero do CT"));
			super.setCtName("CT - " + map.get("Numero do CT") + " " + map.get("Nome do CT"));
			super.setTester(map.get("Nome do executor"));
			super.setCiclo(map.get("Sprint"));
		}

	}

}
