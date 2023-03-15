package SpilitCodes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.resusableCode;

public class productPage extends resusableCode {

	WebDriver Driver;
	public  productPage(WebDriver Driver) {
		
		super(Driver);
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}
	
	@FindBy(tagName="h4")
	List<WebElement> Listofproduct;
	
	@FindBy(css="button[type=\"submit\"] [class=\"fa-solid fa-shopping-cart\"]")
	List<WebElement> productByName;
	
	@FindBy(css="th[class=\"month\"]")
	WebElement month;
	
	@FindBy(css="th[class=\"next available\"]")
	WebElement next;
	
	@FindBy(tagName="td")
	List<WebElement> listofdate;
	
	@FindBy(id="input-option-225")
	WebElement box;
	
	@FindBy(css="#button-cart")
	WebElement add;
	
	@FindBy(id="alert")
	WebElement getmessage;
	
	@FindBy(css=".btn-block.dropdown-toggle")
	WebElement addedpage;
	
	@FindBy(css="p[class=\"text-end\"] i[class=\"fa-solid fa-share\"]")
	WebElement gotocheckout;
	public List<WebElement> getProductList() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		return Listofproduct;
		
	}
	public void  getProductByname(int i) {
		
		productByName.get(i).click();
		
	}
	
	public void DatePicker(String monyear,String date) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		
		box.click();

		while (!month.getText().contains(monyear)) {
			next.click();
		}
		for (int i = 0; i < listofdate.size(); i++) {
			String dates = listofdate.get(i).getText();

			if (dates.equals(date)) {
				listofdate.get(i).click();
				break;
			}
		}
	}
	public void addtoCart() throws InterruptedException {
		DatePicker("Jul 2012","3");
		add.click();
	}
	
	public String getSuccessMessage() throws InterruptedException {
		Thread.sleep(1000);
		String message=getmessage.getText();
		return message;
		
	}
	
	public checkOutPage GotoCheckout() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(1000);
		addedpage.click();
		Thread.sleep(2000);
		gotocheckout.click();
		return new checkOutPage(Driver);
	}
	
	
	
	
}
