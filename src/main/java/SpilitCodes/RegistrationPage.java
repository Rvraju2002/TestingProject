package SpilitCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.resusableCode;

public class RegistrationPage extends resusableCode {
	WebDriver Driver;

	public RegistrationPage(WebDriver Driver) {

		super(Driver);
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	@FindBy(id = "input-firstname")
	WebElement fstname;;
	@FindBy(id = "input-lastname")
	WebElement lstname;
	@FindBy(id = "input-email")
	WebElement eml;
	@FindBy(id = "input-password")
	WebElement pwd;
    @FindBy(css="input[name$='agree']")
    WebElement agree;
    @FindBy(css="button[type$='submit']")
    WebElement submit;
   
    
    @FindBy(css="label[for='input-firstname']")
    WebElement Firstname;
    
    @FindBy(css="label[for='input-lastname']")
    WebElement LastName;
    
    @FindBy(css="label[for='input-email']")
    WebElement EmialLabel;
    
    @FindBy(css="label[for='input-password']")
    WebElement PasswordLabel;
    
    
    
    
    
    
    
	
	public void EnterRegistrationDetails(String FIRSTNAME,String LASTNAME,String EMAIL,String PASSWORD) throws InterruptedException {

		fstname.sendKeys(FIRSTNAME);
		lstname.sendKeys(LASTNAME);
		eml.sendKeys(EMAIL);
		pwd.sendKeys(PASSWORD);
		JavascriptExecutor js =(JavascriptExecutor)Driver;
		js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(2000);
	}
	public void clickPrivacy() throws InterruptedException {
		   
		   agree.click();
	}
	
	public void ClickSubmitButton() {
		submit.click();
		
	}
	
	
	public String VerifyspellofFirstName() {
		String fn=Firstname.getText();
		return fn;
	}
	public String VerifyspellofLastName() {
		String ln= LastName .getText();
		return ln;
	}
	public String VerifyspellofemailLabel() {
		String el= EmialLabel.getText();
		return el;
	}
	public String VerifyspellofpasswordLabel() {
		String pwl=PasswordLabel.getText();
		return pwl;
	}
	   

}
