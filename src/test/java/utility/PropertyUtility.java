package utility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	Properties props = null;
	
	public Properties loadProperty() {
		try {
			props = new Properties();
			
			String path = System.getProperty("user.dir");
			FileReader reader = new FileReader(path+"/src/test/java/propertyFile/configure.properties");
			props.load(reader);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			return props;
		}
	}
}
