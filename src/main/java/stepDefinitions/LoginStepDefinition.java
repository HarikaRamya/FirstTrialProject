package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Listeners.ExtentReportListener;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;



public class LoginStepDefinition extends ExtentReportListener{
	
	WebDriver driver;
	ExtentTest logInfo=null;
	
	@Given("^user opens the login page$")
	public void user_opens_the_login_page() throws Throwable {
		
		try {
		test=extent.createTest(Feature.class,"feature name");
		test=test.createNode(Scenario.class, "Scenario name");
		logInfo=test.createNode(new GherkinKeyword("Given"), "Given Step name");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\BrowserDrivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		logInfo.pass("Opened the login page successfully");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		
		}catch(Exception e) {
			testStepHandle("FAIL", driver, logInfo);
		}

	}
	
	
	

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
	   
	}
	// \"([^\"]*)\"
	
	@When("^user enters \"(.*)\" and \"(.*)\" $")
	public void user_enters_username_and_password(String userName, String password) throws Throwable {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);	   
	}

	@Then("^user login successfully$")
	public void user_login_successfully() throws Throwable {
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	
	}

	@Then("^user verifies login page$")
	public void user_verifies_login_page() throws Throwable {
	    if(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
	    	System.out.println("Login is succesful");
	    }
	    
	}

	@Then("^user logout$")
	public void user_logout() throws Throwable {
	   
	    
	    driver.findElement(By.xpath("//p[text()='Text texted']")).click();
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
	 
	 
}
