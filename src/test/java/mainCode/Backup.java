package mainCode;

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

public class Backup {

	@Test
	public void EndToEndPage() throws InterruptedException {

		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		String productName = "HP LP3065";
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Driver.get("http://localhost/opencart/index.php?route=common/home&language=en-gb");
		Driver.findElement(By.linkText("My Account")).click();
		Driver.findElement(By.linkText("Login")).click();
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(1000);
		Driver.findElement(By.id("input-email")).sendKeys("raju4@gmail.com");
		Driver.findElement(By.id("input-password")).sendKeys("1234");
		Driver.findElement(By.cssSelector("button[class$='btn btn-primary']")).click();
		Thread.sleep(1000);
		WebElement des = Driver.findElement(By.xpath("//nav/div/ul/li[1]/a[1]"));
		Actions a = new Actions(Driver);
		a.moveToElement(des).build().perform();
		Driver.findElement(By.linkText("Show All Desktops")).click();
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		List<WebElement> Listofproduct = Driver.findElements(By.tagName("h4"));
		for (int i = 0; i < Listofproduct.size(); i++) {

			String listofProductNames = Listofproduct.get(i).getText();
			System.out.println(listofProductNames);

			if (listofProductNames.contains(productName)) {
				Thread.sleep(2000);
				Driver.findElements(By.cssSelector("button[type=\"submit\"] [class=\"fa-solid fa-shopping-cart\"]"))
						.get(i).click();
				break;
			}
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(2000);
		Driver.findElement(By.id("input-option-225")).click();

		while (!Driver.findElement(By.cssSelector("th[class=\"month\"]")).getText().contains("Jul 2014")) {
			Driver.findElement(By.cssSelector("th[class=\"next available\"]")).click();
		}
		List<WebElement> date = Driver.findElements(By.tagName("td"));
		for (int i = 0; i < date.size(); i++) {
			String dates = date.get(i).getText();

			if (dates.equals("3")) {
				date.get(i).click();
				break;
			}
		}
		Driver.findElement(By.cssSelector("#button-cart")).click();
		Thread.sleep(1000);
		String text = Driver.findElement(By.id("alert")).getText();
		Assert.assertEquals(text, "Success: You have added HP LP3065 to your shopping cart!");
		js.executeScript("window.scrollBy(0,-600)");
		Thread.sleep(1000);
		Driver.findElement(By.cssSelector(".btn-block.dropdown-toggle")).click();
		Thread.sleep(2000);
		Driver.findElement(By.cssSelector("p[class=\"text-end\"] i[class=\"fa-solid fa-share\"]")).click();
		WebElement ele=Driver.findElement(By.id("input-shipping-new"));
		if(ele.isDisplayed()) {
		Driver.findElement(By.id("input-shipping-new")).click();
		}
		Driver.findElement(By.cssSelector("input[name$='firstname']")).sendKeys("Vicky");
		Driver.findElement(By.cssSelector("input[name$='lastname']")).sendKeys("Raju");
		Driver.findElement(By.cssSelector("input[name$='address_1']")).sendKeys("solaikoundanpatti");
		Driver.findElement(By.cssSelector("input[name$='city']")).sendKeys("Virudhunagar");
		WebElement country = Driver.findElement(By.cssSelector("select[name$='country_id']"));
		Select c = new Select(country);
		c.selectByVisibleText("India");
		WebElement state = Driver.findElement(By.cssSelector("select[name='zone_id']"));
		Select s = new Select(state);
		s.selectByVisibleText("Tamil Nadu");
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(2000);
		Driver.findElement(By.id("button-shipping-address")).click();
		js.executeScript("window.scrollBy(0,-300)");
		Thread.sleep(2000);
		WebElement flat = Driver.findElement(By.id("input-shipping-method"));
		Select f = new Select(flat);
		f.selectByIndex(1);
		Thread.sleep(1000);
		WebElement payment = Driver.findElement(By.id("input-payment-method"));
		Select p = new Select(payment);
		p.selectByIndex(1);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		Driver.findElement(By.id("button-confirm")).click();
		Thread.sleep(1000);
		String message = Driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(message, "Your order has been placed!");
		Driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Driver.quit();

	}

}
