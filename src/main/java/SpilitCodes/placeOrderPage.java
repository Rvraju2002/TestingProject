package SpilitCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.resusableCode;

public class placeOrderPage extends resusableCode{

	WebDriver Driver;
	public placeOrderPage(WebDriver Driver) {
		super(Driver);
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	@FindBy(tagName="h1")
	WebElement placeOrderMessage;
	@FindBy(css=".btn.btn-primary")
	WebElement bactohome;
	
	public String  OrderConfirmMessage() throws InterruptedException {
		Thread.sleep(1000);
		String message = placeOrderMessage.getText();
		return message;
	}
	public void backtohomepage() {
		bactohome.click();
	}
}
