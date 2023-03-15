package SpilitCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.resusableCode;

public class homePage extends resusableCode {
	WebDriver Driver;
	public homePage(WebDriver Driver) {
		super(Driver);
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	// Driver.findElement(By.linkText("Login")).click();

	
	

	public void goTo() {

		Driver.get("http://localhost/opencart/index.php?route=common/home&language=en-gb");
	}

	

	public LoginPage goTologinPage() {
		MyAccount();
		loginlink();
		return new LoginPage(Driver);
	}
	

}
