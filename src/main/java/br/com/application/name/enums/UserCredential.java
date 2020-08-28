package br.com.application.name.enums;

import br.com.application.name.commons.BaseTest;
import br.com.application.name.commons.PropertiesManager;
import br.com.application.name.interfaces.Credentials;

public enum UserCredential implements Credentials {

    VALIDO{
        @Override
        public String email() {
            return PropertiesManager.getPropertiesValue("EMAIL");
        }

        @Override
        public String password() {
            return PropertiesManager.getPropertiesValue("PASSWORD");
        }
    };


}
