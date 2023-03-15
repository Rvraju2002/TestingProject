package AbstractComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class resusableCode {

	WebDriver Driver;

	public resusableCode(WebDriver Driver) {

		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}

	@FindBy(linkText = "My Account")
	WebElement myaccount;
	
	@FindBy(linkText="Register")
	WebElement registerPage;

	@FindBy(css = "button[class$='btn btn-primary']")
	WebElement loginButton;
	
	@FindBy(linkText = "Login")
	WebElement login;

    @FindBy(id="alert")
	WebElement aleartMessage;

	public void MyAccount() {
		myaccount.click();
	}
	public void goToRegisterPage() {
		
		registerPage.click();
	}
	
    public String alertMessage() {
		
		String alrt=aleartMessage.getText();
		return alrt;
	}

	public void ClickLoginButton() {

		loginButton.click();
	}
	
	public void loginlink() {
		login.click();
	}


}
