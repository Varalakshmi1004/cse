package config;

import java.io.FileInputStream;
import java.util.Properties;

public class SauceDemoProperties 
{
    public static void main(String[] args) throws Exception 
    {
        Properties properties = new Properties();
        
        FileInputStream input = new FileInputStream("src/main/java/config/SauceDemoProp.properties");
            // Load properties from the file
        properties.load(input);
            
            // Access properties using the key
        String Url = properties.getProperty("SauceDemoUrl");
            
            // Print the properties
        System.out.println("Database URL: " + Url);
   }
}