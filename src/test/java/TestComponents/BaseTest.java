package TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Priyanshu.Selenium.*;


public class BaseTest {
	  	public WebDriver driver;
	    public static LoginPage lp;
	    public WebDriver initDriver() throws IOException{
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("headless");
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.manage().window().maximize();
	        return driver;
	    }
	    @BeforeMethod
	    public LoginPage launchApplication() throws IOException{
	        driver = initDriver();
	        lp = new LoginPage(driver);
	        lp.goTo();
	        return lp;
	    }
	    @AfterMethod
	    public void closeBrowser(){
	        driver.quit();
	    }
	    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
	    	FileUtils.copyFile(source, file);
	    	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	    	
	    }
}
