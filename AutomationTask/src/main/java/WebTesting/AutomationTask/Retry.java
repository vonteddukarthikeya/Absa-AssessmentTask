package WebTesting.AutomationTask;

import java.util.logging.Logger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	public static final Logger log = Logger.getLogger(Retry.class.getName());
	private int retryCount = 0;
	private int maxRetryCount = 2;

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {
			log("Retrying Test" + result.getName() + "with status" + getResultStatusName(result.getStatus()) + "for the"
					+ (retryCount + 1) + "time(s)");
			retryCount++;
			return true;
		}
		return false;
	}

	private void log(String data) {
		log.info(data);// to print in log4j
		Reporter.log(data);// to print in testng report
	}

	private String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIPPED";
		return resultName;
	}

}

/*
 * retry class we use "IRetryAnalyzer" interface and abstract method "retry()"
 */