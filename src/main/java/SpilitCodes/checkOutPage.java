package SpilitCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.resusableCode;

public class checkOutPage extends resusableCode{

	WebDriver Driver;
	public checkOutPage(WebDriver Driver) {
		super(Driver);
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	
	@FindBy(id="input-shipping-new")
	WebElement newaddress;
	
	@FindBy(css="input[name$='firstname']")
	WebElement fstname;
	
	@FindBy(css="input[name$='lastname']")
	WebElement lstname;
	@FindBy(css="input[name$='address_1']")
	WebElement address;
	
	@FindBy(css="input[name$='city']")
	WebElement  city;
	
	@FindBy(css="select[name$='country_id']")
	WebElement country;
	
	@FindBy(css="select[name='zone_id']")
	WebElement state;
	
	@FindBy(id="button-shipping-address")
	WebElement continueButton;
	
	@FindBy(id="input-shipping-method")
	WebElement shippingMethod;
	
	@FindBy(id="input-payment-method")
	WebElement payment;
	
	@FindBy(id="button-confirm")
	WebElement Button;
	
	
	
    
	public void choosingAddress() {
		
		if (newaddress.isDisplayed()) {
			newaddress.click();
		}
	}
	public void AddressDetails(String FirstName,String LastName,String Address,String City) {
		
		fstname.sendKeys(FirstName);
		lstname.sendKeys(LastName);
		address.sendKeys(Address);
		city.sendKeys(City);
	}
	public void chooseCournty(String counrtryName) {
		
		Select c = new Select(country);
		c.selectByVisibleText(counrtryName);
	}
	public void chooseState(String StateName) throws InterruptedException {
		Select s = new Select(state);
		s.selectByVisibleText(StateName);
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		continueButton.click();
	}
	public void  chooseshippingMethod() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
		Select f = new Select(shippingMethod);
		f.selectByIndex(1);
	}
	public void choosepaymentMethod() throws InterruptedException {

		Thread.sleep(1000);
		Select p = new Select(payment);
		p.selectByIndex(1);
	}
	public placeOrderPage clikCofirmButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		Button.click();
		return new placeOrderPage (Driver);
	}
}
