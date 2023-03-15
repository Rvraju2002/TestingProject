package mainCode;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseCode.basecode;
import SpilitCodes.AccounPage;
import SpilitCodes.LoginPage;
import SpilitCodes.checkOutPage;
import SpilitCodes.homePage;
import SpilitCodes.placeOrderPage;
import SpilitCodes.productPage;

public class EndToEnd extends basecode {

	@Test
	public void EndToEndPage() throws InterruptedException, IOException {
		String productName = "HP LP3065";
		String email="raju@gmail.com";
		String password="12345";
		LoginPage loginpage = homepage.goTologinPage();
		AccounPage accountpage = loginpage.LoginApplication(email, password);
		productPage prodcutpage = accountpage.goToProductPage();
		List<WebElement> Listofproduct = prodcutpage.getProductList();
		for (int i = 0; i < Listofproduct.size(); i++) {
			String listofProductNames = Listofproduct.get(i).getText();
			if (listofProductNames.contains(productName)) {
				Thread.sleep(2000);
				prodcutpage.getProductByname(i);
				break;
			}
		}
		prodcutpage.addtoCart();
		String text = prodcutpage.getSuccessMessage();
		Assert.assertEquals(text, "Success: You have added HP LP3065 to your shopping cart!");
		checkOutPage checkoutpage = prodcutpage.GotoCheckout();
		checkoutpage.choosingAddress();
		checkoutpage.AddressDetails("Vicky", "Raju", "Solaikoundanpatty", "Virudhunagar");
		checkoutpage.chooseCournty("India");
		checkoutpage.chooseState("Tamil Nadu");
		checkoutpage.chooseshippingMethod();
		checkoutpage.choosepaymentMethod();
		placeOrderPage placeorder = checkoutpage.clikCofirmButton();
		String message = placeorder.OrderConfirmMessage();
		Assert.assertEquals(message, "Your order has been placed!");
		placeorder.backtohomepage();
	}
	
	
	
	

}
