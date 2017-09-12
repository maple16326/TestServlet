package mypackage;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class PropertyTest {
	public static final Logger LOGGER = Logger.getLogger(PropertyTest.class);
	public static final String LOG4JPROPERTIES="log4j.properties";
	public List<String> property(String s) {
		Properties prop = new Properties();
		List<String> list = new ArrayList<>();
		String feboproperties;
		String joseProperty;
		PropertyConfigurator.configure(LOG4JPROPERTIES);
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					"a.properties"));
			prop.load(in);
			Iterator<String> it = prop.stringPropertyNames().iterator();
			while (it.hasNext()) {
				String key = it.next();
				if ("f".equals(s)
						&& ((key.equals("FeboinputFilePath")) || (key
								.equals("FebooutputDirPath")))) {
					feboproperties = prop.getProperty(key);
					list.add(feboproperties);
				} else if ("j".equals(s)
						&& ((key.equals("JosephinputFilePath")) || (key
								.equals("JosephoutputDirPath")))) {
					joseProperty = prop.getProperty(key);
					list.add(joseProperty);
				}
			}
			in.close();

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		} 
			return list;
		

	}

}
