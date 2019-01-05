package WebTesting.AutomationTask;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class TC001_VerifyAddUserDetails extends BasePage {
	public static final Logger log = Logger.getLogger(TC001_VerifyAddUserDetails.class.getName());
	public static PropertiFilePath pr = new PropertiFilePath();
	AbsaTestPage pomclass;

	@BeforeMethod
	@Parameters("browser")
	public void OpenBrowser(String browser) throws Exception {
		browserLaunch(browser, pr.loaddata("BrowserUrl"));
	}

	@Test
	public void AbsaAssessmentTest() throws Exception {
		test = rep.startTest("TC001_VerifyAddUserDetails");
		test.log(LogStatus.INFO, "Starting the test");
		log.info("Started ----- TC001_VerifyAddUserDetails -----");
		test.log(LogStatus.INFO, "Started ----- TC001_VerifyAddUserDetails -----");
		pomclass = new AbsaTestPage(driver);// created object of the page and create constructor
		pomclass.validateTitle();
		pomclass.validateUrl();
		pomclass.validateUserListTable();
		pomclass.addUserClick();
		pomclass.addingNewUser();
		pomclass.checkingUserInList();
		log.info("Ended ----- TC001_VerifyAddUserDetails ----- ");
		test.log(LogStatus.INFO, "Ended ----- TC001_VerifyAddUserDetails -----");
	}

	@AfterMethod
	public void CloseBrowser() {
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}

}
