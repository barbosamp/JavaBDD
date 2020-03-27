package br.com.application.name.reports.evidence;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class with shared methods and action to Selenium Evidence
 * @author Aleksander Ramos - Yaman
 */
public class SeleniumEvidenceUtils {

    /**
     * Properties that loads report parameterization
     */
    static Properties properties;


    /**
     * Load Selenium Evidence property file
     * @return a property
     * @throws IOException if file do not exists
     */
    public static Properties loadProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("/Users/marcosBarbosa/Desktop/Scafold/automacao/biblioteca-sigla-fv/src/main/resources/init.properties"));

        return properties;
    }

}
