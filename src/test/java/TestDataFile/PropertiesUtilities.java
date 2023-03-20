package TestDataFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtilities {

    public FileInputStream fileInputStream;
    public Properties properties;

    public PropertiesUtilities(String nameTest) {
        loadFile(nameTest);
    }

    public void loadFile(String nameTest) {
        properties = new Properties(); //il initializam
        try {

            fileInputStream = new FileInputStream("src/test/resources/TestData/"+  nameTest + "Data.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public HashMap<String, String> GetData(){
        HashMap<String, String> testData = new HashMap<>();
        for(String key: properties.stringPropertyNames()){
            testData.put(key, properties.getProperty(key));
        }
        return testData;
    }
}
