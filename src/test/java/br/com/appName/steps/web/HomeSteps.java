package br.com.appName.steps.web;

import br.com.application.name.web.funcionalidade.HomeFuncionalidade;
import cucumber.api.java.pt.E;

public class HomeSteps {

        private HomeFuncionalidade homeFuncionalidade;

        public HomeSteps() {
                this.homeFuncionalidade =  new HomeFuncionalidade();
        }

        @E("^acesso a tela de registro$")
        public void estouRealizandoOTeste(){
                this.homeFuncionalidade.acessaRegistroNovoUsuario();
        }
}
