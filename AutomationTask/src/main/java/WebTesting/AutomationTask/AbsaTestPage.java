package WebTesting.AutomationTask;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class AbsaTestPage extends BasePage {
	public static Logger log = Logger.getLogger(AbsaTestPage.class.getName());
	public static PropertiFilePath pr=new PropertiFilePath();
	
// Page Factory Approach
	@FindBy(xpath = "//button[@class='btn btn-link pull-right']")
	public WebElement AddUser;
	@FindBy(xpath = "//span[text()='First Name']")
	public WebElement FirstNameText;
	@FindBy(xpath = "//span[text()='Last Name']")
	public WebElement LastNameText;
	@FindBy(xpath = "//span[text()='User Name']")
	public WebElement UserNameText;
	@FindBy(xpath = "//span[text()='Customer']")
	public WebElement CustomerText;
	@FindBy(xpath = "//span[text()='Role']")
	public WebElement RoleText;
	@FindBy(xpath = "//span[text()='E-mail']")
	public WebElement EmailText;
	@FindBy(xpath = "//span[text()='Cell Phone']")
	public WebElement CellPhoneText;
	@FindBy(xpath = "//span[text()='Locked']")
	public WebElement LockedText;
	@FindBy(name = "FirstName")
	public WebElement FirstNameField;
	@FindBy(css = "input[name='LastName']")
	public WebElement LastNameField;
	@FindBy(css = "input[name='UserName']")
	public WebElement UserNameField;
	@FindBy(xpath = "//input[@class='ng-pristine ng-valid'][@name='Password']")
	public WebElement PasswordField;
	@FindBy(xpath = "//input[@class='ng-pristine ng-valid'][@type='radio'][@value='15']")
	public WebElement CustomerField;
	@FindBy(xpath = "//option[text()='Customer']")
	public WebElement RoleField;
	@FindBy(css = "input[name='Email']")
	public WebElement EmailField;
	@FindBy(xpath = "//input[@name='Mobilephone']")
	public WebElement PhoneField;
	@FindBy(xpath = "//button[@class='btn btn-success']")
	public WebElement SaveButtonField;
	@FindBy(xpath = "//input[@class='pull-right ng-pristine ng-valid']")
	public WebElement SearchField;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	public WebElement TableData;

	public AbsaTestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

// Title Validation
	public void validateTitle() throws Exception {
		log.info("Started ----- Title Validation -----");
		String actualtitle = driver.getTitle();
		String expectedtitle = pr.loaddata("TitleName");
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("Both actual and expected titles are equal");
		} else {
			System.out.println("Both actual and expected titles are not equal");
		}
		System.out.println("Title :" + actualtitle);
		log.info("Ended ----- Title Validation -----");
	}

// Url validation
	public void validateUrl() throws Exception {
		log.info("Started ----- Url Validation -----");
		String actualurl = driver.getCurrentUrl();
		String expectedurl = pr.loaddata("BrowserUrl");
		if (actualurl.equals(expectedurl)) {
			System.out.println("Both actual and expected url's are equal");
		} else {
			System.out.println("Both actual and expected url's are not equal");
		}
		System.out.println("URL :" + actualurl);
		log.info("Ended ----- Url Validation -----");
	}

// Validating Headers of table
	public void validateUserListTable() throws Exception {
		log.info("Started ----- Validate for UserListTable -----");
		AddUser.getText();
		FirstNameText.getText();
		LastNameText.getText();
		UserNameText.getText();
		CustomerText.getText();
		RoleText.getText();
		EmailText.getText();
		CellPhoneText.getText();
		LockedText.getText();

		String actualadduser = AddUser.getText();
		String expectedadduser = "Add User";
		String actualfirstname = FirstNameText.getText();
		String expectedfirstname = "First Name";
		String actuallastname = LastNameText.getText();
		String expectedlastname = "Last Name";
		String actualusername = UserNameText.getText();
		String expectedusername = "User Name";
		String actualcustomer = CustomerText.getText();
		String expectedcustomer = "Customer";
		String actualroletext = RoleText.getText();
		String expectedroletext = "Role";
		String actualemail = EmailText.getText();
		String expectedemail = "E-mail";
		String actualcellphone = CellPhoneText.getText();
		String expectedcellphone = "Cell Phone";
		String actuallocked = LockedText.getText();
		String expectedlocked = "Locked";

		Assert.assertEquals(actualadduser, expectedadduser);
		Assert.assertEquals(actualfirstname, expectedfirstname);
		Assert.assertEquals(actuallastname, expectedlastname);
		Assert.assertEquals(actualusername, expectedusername);
		Assert.assertEquals(actualcustomer, expectedcustomer);
		Assert.assertEquals(actualroletext, expectedroletext);
		Assert.assertEquals(actualemail, expectedemail);
		Assert.assertEquals(actualcellphone, expectedcellphone);
		Assert.assertEquals(actuallocked, expectedlocked);

		System.out.println("Both Actual and Expected texts are equal:" + actualadduser);
		System.out.println("Both Actual and Expected texts are equal :" + actualfirstname);
		System.out.println("Both Actual and Expected texts are equal :" + actuallastname);
		System.out.println("Both Actual and Expected texts are equal :" + actualusername);
		System.out.println("Both Actual and Expected texts are equal :" + actualcustomer);
		System.out.println("Both Actual and Expected texts are equal :" + actualroletext);
		System.out.println("Both Actual and Expected texts are equal :" + actualemail);
		System.out.println("Both Actual and Expected texts are equal :" + actualcellphone);
		System.out.println("Both Actual and Expected texts are equal :" + actuallocked);
		log.info("Ended ----- Validate for UserListTable -----");
	}

// Add User click event
	public void addUserClick() throws Exception {
		AddUser.click();
		Thread.sleep(1000); // system wait property
	}

// Adding New Users by Properties and Excel file
	public void addingNewUser() throws Exception {
		log.info("Started ----- Adding New User -----");
		FirstNameField.sendKeys(pr.loaddata("FirstNameField"));
		ExcelAPI e=new ExcelAPI(System.getProperty("user.dir")
				+ "/src/main/java/WebTesting/AutomationTask/TestData/AutomationTask_TestData.xlsx");
		int rcnt = e.getRowCount("Task2_TestData");
		for (int i = 1; i < rcnt; i++) {
			LastNameField.clear();
			LastNameField.sendKeys(e.getCellData("Task2_TestData", "Last Name", i));
			PasswordField.sendKeys(e.getCellData("Task2_TestData", "Password", i));
			EmailField.sendKeys(e.getCellData("Task2_TestData", "Email", i));
		}
		UserNameField.sendKeys(pr.loaddata("username") + pr.randomusername());
		WebElement radio_Button = CustomerField;
		if (!radio_Button.isSelected()) {
			CustomerField.click();
			Thread.sleep(1000);
		}
		RoleField.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Implicitly Wait
		PhoneField.sendKeys(pr.loaddata("phonenumber") + pr.randomphonenumber());
		SaveButtonField.click();
		waitforElement(SearchField, 30); // Explicitly Wait
		log.info("Ended ----- Adding New User -----");
	}

// Checking the added user in the list
	public void checkingUserInList() throws Exception {
		log.info("Started ----- Checking user added in list -----");
		SearchField.sendKeys(pr.loaddata("FirstNameField"));
		Thread.sleep(1000);
		TableData.getText();
		String actualvalue = TableData.getText();
		String expectedvalue = pr.loaddata("FirstNameField");
		if (actualvalue.equals(expectedvalue)) {
			System.out.println("Both actual and expected values are equal");
		} else {
			System.out.println("Both actual and expected values are not equal");
		}
		System.out.println("FirstName:" + actualvalue);
		Thread.sleep(1000);
		WebElement toClear = driver.findElement(By.xpath("//input[@class='pull-right ng-valid ng-dirty']"));
		Thread.sleep(1000);
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		Thread.sleep(3000);
		log.info("Started ----- Checking user added in list -----");
	}

}




