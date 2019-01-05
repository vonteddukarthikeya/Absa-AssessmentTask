package WebTesting.AutomationTask;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

public class PropertiFilePath {
	public static String path = "./absaTest.properties"; // Properties file path

// loading data from properties
	public static String loaddata(String key) throws Exception {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

// To generate Unique UserName
	public int randomusername() {
		Random r = new Random();
		int mailid = r.nextInt(999);
		return mailid;
	}

// To generate Unique Password
	public int randompassword() {
		Random r = new Random();
		int mailid = r.nextInt(999);
		return mailid;
	}

// To generate Unique MailId
	public int randommailid() {
		Random r = new Random();
		int mailid = r.nextInt(999);
		return mailid;
	}

// To generate Unique PhoneNumber
	public int randomphonenumber() {
		Random r = new Random();
		int phonenumber = r.nextInt(999999999);
		return phonenumber;
	}

}
