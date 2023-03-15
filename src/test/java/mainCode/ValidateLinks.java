package mainCode;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseCode.basecode;

public class ValidateLinks extends basecode {

	@Test
	public void ValidatemainLinks() throws InterruptedException {
		GoToaccountPage();
		Thread.sleep(1000);
		List<WebElement> link = Driver.findElements(By.cssSelector(".col a"));

		for (int i = 0; i < link.size(); i++) {

			String value = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.get(i).sendKeys(value);
		}
		Set<String> s = Driver.getWindowHandles();
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
			Driver.switchTo().window(it.next());
			System.out.println(Driver.getTitle());

		}

	}

	@Test
	public void ValidateasideLinks() throws InterruptedException {
		GoToaccountPage();
		Thread.sleep(1000);
		List<WebElement> link = Driver.findElements(By.xpath("//div//div//aside//a"));
		for (int i = 0; i < link.size(); i++) {

			String value = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.get(i).sendKeys(value);
		}
		Set<String> s = Driver.getWindowHandles();
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
			Driver.switchTo().window(it.next());
			System.out.println(Driver.getTitle());

		}

	}

	@Test
	public void ValidatefooterLinks() throws InterruptedException {
		GoToaccountPage();
		WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//footer//div//div//div[1]//ul//a")));
		List<WebElement> link = Driver.findElements(By.xpath("//footer//a"));
		for (int i = 0; i < link.size(); i++) {

			String value = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.get(i).sendKeys(value);
		}
		Set<String> s = Driver.getWindowHandles();
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
			Driver.switchTo().window(it.next());
			System.out.println(Driver.getTitle());

		}

	}

}
