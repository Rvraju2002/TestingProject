package BaseCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AbstractComponents.NetWorkLogActivity;
import SpilitCodes.AccounPage;
import SpilitCodes.LoginPage;
import SpilitCodes.homePage;

public class basecode {
	 
	public WebDriver Driver;
	public homePage homepage ;
	public WebDriver initializeDriver() throws IOException {
		String file =System.getProperty("user.dir")+"\\src\\test\\java\\BaseCode\\Golbal.properties";
		Properties prop = new Properties();
		FileInputStream fis= new FileInputStream(file);
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");
	     prop.getProperty("browser");
	     ChromeOptions options=new ChromeOptions();
	     options.addArguments("--remote-allow-origins=*");
	    // options.addArguments("--disable notifications");
	     DesiredCapabilities cp = new DesiredCapabilities();
	     cp.setCapability(ChromeOptions.CAPABILITY, options);
	     options.merge(cp);
		
		if(browserName.contains("chrome")) {
		Driver = new ChromeDriver(options);
			
		}
		else if(browserName.contains("firefox")) {
			Driver = new FirefoxDriver();
		}
		
		else if(browserName.contains("edge")) {
			Driver = new EdgeDriver();
		}
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return Driver;
		
	}
	public String getScreenshot(String testCaseName,WebDriver Driver ) throws IOException {
		
		TakesScreenshot ts =(TakesScreenshot)Driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" +testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//" +testCaseName+".png";
	}
	
	public void GoToaccountPage() throws InterruptedException {
		
		String email="raju@gmail.com";
		String password="12345";
		LoginPage loginpage = homepage.goTologinPage();
		AccounPage accountpage = loginpage.LoginApplication(email, password);
	}
	
	
		

	
	
	
	@BeforeMethod(alwaysRun = true)
	public homePage HomePage() throws IOException {
		Driver=initializeDriver();
		homepage = new homePage(Driver);
		homepage.goTo();
		return homepage;
	
	}
	

    @AfterMethod(alwaysRun=true)
	public void QuitBrowser() {
		
		Driver.quit();
	}

}
