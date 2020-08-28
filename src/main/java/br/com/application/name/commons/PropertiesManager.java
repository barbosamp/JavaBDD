package br.com.application.name.commons;

import java.io.*;
import java.util.Properties;

public class PropertiesManager {


    public static String getPropertiesValue(String key){
        Properties prop = new Properties();
        File file = new File("src/main/resources");
        try {
            prop.load(new FileInputStream(file.getAbsolutePath()+"/application.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public void setPropertieValue(String key, String value){
        Properties props = new Properties();
        File file = new File("src/main/resources");
        FileInputStream in = null;
        try {
            in = new FileInputStream(file.getAbsolutePath()+"/application.properties");
            props.load(in);
            in.close();
            FileOutputStream out = new FileOutputStream(file.getAbsolutePath()+"/application.properties");
            props.setProperty(key, value);
            props.store(out, null);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
