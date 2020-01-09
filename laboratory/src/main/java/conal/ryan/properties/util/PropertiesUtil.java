package conal.ryan.properties.util;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by cryan on 5/12/2015.
 */
public class PropertiesUtil {

    private String serverAddress="192.168.3.1";
    private int serverPort=80;
    private int threadCount=5;

    public void loadParams() {
        Properties properties = new Properties();
        InputStream inputStream = null;

        // First try loading from the current directory
        try {
            File file = new File("server.properties");
            inputStream = new FileInputStream(file);
        }
        catch ( Exception e ) { inputStream = null; }

        try {
            if ( inputStream == null ) {
                // Try loading from classpath
                inputStream = getClass().getResourceAsStream("server.properties");
            }

            // Try loading properties from the file (if found)
            properties.load(inputStream);
        }
        catch ( Exception e ) { }

        serverAddress = properties.getProperty("ServerAddress", "192.168.0.1");
        serverPort = new Integer(properties.getProperty("ServerPort", "8080"));
        threadCount  = new Integer(properties.getProperty("ThreadCount", "5"));
    }

    public void saveParamChanges() {
        try {
            Properties props = new Properties();
            props.setProperty("ServerAddress", serverAddr);
            props.setProperty("ServerPort", ""+serverPort);
            props.setProperty("ThreadCount", ""+threadCnt);
            File f = new File("server.properties");
            OutputStream out = new FileOutputStream( f );
            props.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public void saveParamChangesAsXML() {
        try {
            Properties props = new Properties();
            props.setProperty("ServerAddress", serverAddr);
            props.setProperty("ServerPort", ""+serverPort);
            props.setProperty("ThreadCount", ""+threadCnt);
            File f = new File("server.xml");
            OutputStream out = new FileOutputStream( f );
            props.storeToXML(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public void saveProperties(File file, String key, String value) {
        try {
            Properties properties = new Properties();
            properties.setProperty(key, value);

            OutputStream out = new FileOutputStream(file);
            properties.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public void saveProperties(File file, Map<String, String> map) {
        try {
            Properties properties = new Properties();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                properties.setProperty(key, value);
            }

            OutputStream out = new FileOutputStream(file);
            properties.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }

    public void saveProperties(File file, Map<String, List<String>> map) {
        try {
            Properties properties = new Properties();

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();

                String value = entry.getValue();
                properties.setProperty(key, value);
            }

            OutputStream out = new FileOutputStream(file);
            properties.store(out, "This is an optional header comment string");
        }
        catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
