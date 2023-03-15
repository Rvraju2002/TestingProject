package SpilitCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.resusableCode;

public class LoginPage extends resusableCode {
	
	WebDriver Driver;
	public LoginPage(WebDriver Driver) {
		super(Driver);
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(css="label[for=\"input-email\"]")
	WebElement EmilSpelling;
	
	@FindBy(css="label[for='input-password']")
	WebElement PasswordSpelling;
	
	@FindBy(css="div[class='mb-3'] a")
	WebElement forgettenPwsSpelling;
	
	@FindBy(css="button[type=\"submit\"]")
	WebElement loginbtnspelling;
	
	@FindBy(css="div[class='mb-3'] a")
	WebElement forgetenPasswordLink;
	
	@FindBy(xpath="//div//aside//div//a[3]")
	WebElement asideLink;
	////div//aside//div//a[3]
	
	
	public AccounPage LoginApplication(String Email,String Password) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		email.sendKeys(Email);
		password.sendKeys(Password);
		ClickLoginButton();
		Thread.sleep(1000);
		return new AccounPage(Driver);
	}
	public void EnterEmail(String El,String Pad) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		email.sendKeys(El);
		password.sendKeys(Pad);
	}
	
	public String spellingofEmailoginPage() {
		
		String emailSpelling=EmilSpelling.getText();
		return emailSpelling;
	}
    public String spellingofpasswordLoginPage() {
    	String pwdspell=PasswordSpelling.getText();
    	return pwdspell;
	}
    public String spellingforgetpwdloginPage() {
    	String frgetspell=forgettenPwsSpelling.getText();
    	return frgetspell;
	}
    public String loginspelling() {
    	String loginbtnspell=loginbtnspelling.getText();
    	return loginbtnspell;
    }
	
   
    public void GoToForgetPasswordPage() {
    	forgetenPasswordLink.click();
    }
    public void AsideForgetLink() {
    	asideLink.click();
    }
	
	
}
