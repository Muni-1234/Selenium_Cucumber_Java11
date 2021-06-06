package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.nop.common.Common_Utilities;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orangehrm_Steps {
	
	WebDriver driver = null;
	
	Common_Utilities Testdata = new Common_Utilities();
	
	@Given("User Launch chrome Browser")
	public void user_Launch_chrome_Browser() throws IOException {
		
		String browser = Testdata.getpropertyvalue("Browser", "Test_config.properties");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
	}

	@When("User Launch URL {string}")
	public void user_Launch_URL(String URL) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		//Calling below Methods:
		orangehrmlogoTest();
		orangehrmTitleTest();
		orangehrmLinksTest();
	}	

	@And("User Enters User as {string} and Password as {string}")
	public void user_Enters_User_as_and_Password_as(String UserName, String Password) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(UserName);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(Password);	
	}
	

	@When("User Launch URL from Properties file")
	public void user_Launch_URL_from_Properties_file() throws IOException {
		
		String URL = Testdata.getpropertyvalue("URL", "Test_config.properties");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		
		//Calling below Methods:
		orangehrmlogoTest();
		orangehrmTitleTest();
		orangehrmLinksTest();
	}

	@When("User Enters UserName and Password from Properties file")
	public void user_Enters_UserName_and_Password_from_Properties_file() throws IOException {
	    
		String UserName1 = Testdata.getpropertyvalue("UserName", "Test_config.properties");
		String Password1 = Testdata.getpropertyvalue("Password", "Test_config.properties");
	    
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(UserName1);
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(Password1);	
	}

	@And("Click on Login")
	public void Click_on_Login() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("User Click on Welcome Admin Link")
	public void user_Click_on_Welcome_Admin_Link() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());	
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		//driver.findElement(By.xpath("//a[@id='welcome']")).sendKeys(Keys.ENTER);
	}

	@And("Click on Logout Link")
	public void click_on_Logout_Link() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//driver.findElement(By.xpath("//a[text()='Logout']")).sendKeys(Keys.ENTER);
	}

	@And("Close Browser")
	public void close_Browser() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		Thread.sleep(2000);
	}
	
	public void orangehrmlogoTest() {
		boolean flag = false;		
		flag = driver.findElement(By.xpath("//div[@id='divLogo']//img")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	public void orangehrmTitleTest() {		
		System.out.println(driver.getTitle());	
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
	}
	
	public void orangehrmLinksTest() {
		List<WebElement> hrmLinksList = driver.findElements(By.cssSelector("a"));
		hrmLinksList.forEach(ele -> System.out.println(ele.getText()));
		Assert.assertEquals(hrmLinksList.size(), 6);
	}
}
