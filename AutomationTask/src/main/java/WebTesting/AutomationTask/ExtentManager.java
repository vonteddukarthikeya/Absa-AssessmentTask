package WebTesting.AutomationTask;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");// date format
			String fileName = formater.format(calendar.getTime()).toString().replace(":", "_").replace(" ", "_")
					+ ".html";
			extent = new ExtentReports(System.getProperty("user.dir")
					+ "/src/main/java/WebTesting/AutomationTask/Extent_Reports/" + fileName);
			extent.loadConfig(new File(System.getProperty("user.dir") + "//ReportsConfig.xml"));
			extent.addSystemInfo("Selenium Version", "3.8.1").addSystemInfo("Environment", "QA");
		}
		return extent;
	}
}
