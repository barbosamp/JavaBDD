package br.com.appName.steps.web;


import br.com.application.name.commons.BaseTest;
import br.com.application.name.reports.evidence.funcionalidade.ParametrosEvidenciaFuncionalidade;
import br.com.application.name.web.funcionalidade.InicioFuncionalidade;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;

public class InitTestStep extends BaseTest {

    private ParametrosEvidenciaFuncionalidade parametrosEvidenciaFuncionalidade;
    private InicioFuncionalidade inicioFuncionalidade;

    public InitTestStep() {
        this.parametrosEvidenciaFuncionalidade = new ParametrosEvidenciaFuncionalidade();
        this.inicioFuncionalidade = new InicioFuncionalidade();
    }

    @E("^estou realizando o teste$")
    public void estouRealizandoOTeste(DataTable params) {

        System.out.println("Definindo os parametros da evidencia . . .");
        this.parametrosEvidenciaFuncionalidade.executandoTeste(params);
        System.out.println("Parâmetros de evidência ok");
    }

    @Dado("^que acesso a pagina inicial do sistema$")
    public void queAcessoAPaginaInicialDoSistema() {
        addEvidenciaWeb("Acesso realizado!");
    }

}
