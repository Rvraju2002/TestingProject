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
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.resusableCode;
import BaseCode.basecode;


public class UITesting extends basecode {

    @Test
	public void VerifyHomePageTitle() {

		String ActualTitle = Driver.getTitle();

		Assert.assertEquals(ActualTitle, "Your Store", "VerifyHomePageTitle failed");
	}

	@Test
	public void VerifyLoginPageTitle() throws InterruptedException {
		resusableCode res = new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		String ActualTitle = Driver.getTitle();
		Assert.assertEquals(ActualTitle, "Account Login", "VerifyAccountPageTitle failed");
	}

	@Test
	public void VerifyAccountPageTitle() throws InterruptedException {
		GoToaccountPage();
		Thread.sleep(1000);
		String AcutualTitle = Driver.getTitle();
		Assert.assertEquals(AcutualTitle, "My Account", "VerifyAccountPageTitle failed");
	}
	
	
}
