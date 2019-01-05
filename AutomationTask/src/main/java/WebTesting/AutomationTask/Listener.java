package WebTesting.AutomationTask;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener extends BasePage implements ITestListener{

// On test Start
	public void onTestStart(ITestResult teststart) {
		Reporter.log("Test started Running:" + teststart.getMethod().getMethodName());
	}

// On test Skipp
	public void onTestSkipped(ITestResult testskipp) {
		Reporter.log("Test is Skipped:" + testskipp.getMethod().getMethodName());
	}

// On test Failure
	public void onTestFailure(ITestResult testfailure) {
		Calendar calendar = Calendar.getInstance();// to get the system date we can use "Date" or "Calendar" class
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");// date format
		String methodName = testfailure.getName();// current test name we get
		if (!testfailure.isSuccess())// if not success
		{
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);// take a screen shot
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/main/java/WebTesting/AutomationTask/";
				File destFile = new File(reportDirectory + "/Failure_ScreenShots/" + methodName + "_"
						+ formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
						+ "' height='100' width='100'/></a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

// On test Success
	public void onTestSuccess(ITestResult testsuccess) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("mm_dd_yyyy_hh_mm_ss");
		String methodName = testsuccess.getName();
		Reporter.log("Test Success:" + testsuccess.getMethod().getMethodName());
		if (testsuccess.isSuccess()) {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
						+ "/src/main/java/WebTesting/AutomationTask/";
				File destFile = new File(reportDirectory + "/Success_ScreenShots/" + methodName + "_"
						+ formater.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
						+ "' height='100' width='100'/></a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult testfailbutwithinsuccesspercentage) {
	}

	public void onStart(ITestContext onstart) {
	}

	public void onFinish(ITestContext onfinish) {
	}

}
