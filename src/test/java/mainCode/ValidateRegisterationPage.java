package mainCode;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import AbstractComponents.resusableCode;
import BaseCode.basecode;
import ReportGenerator.ExtentReportNG;
import SpilitCodes.LoginPage;
import SpilitCodes.RegistrationPage;
import SpilitCodes.homePage;

public class ValidateRegisterationPage extends basecode {

	resusableCode res;
	
	
	@Test
	public void ValidateErrorMessageRegisterWithalreadyExistEmail() throws InterruptedException {
		// TODO Auto-generated method stub
		
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("priyanka", "vijith", "priyanka@gmail.com", "1234");
		reg.clickPrivacy();
		reg.ClickSubmitButton();
		Thread.sleep(1000);
		String errorMessgae =res.alertMessage();
		Assert.assertEquals(errorMessgae, "Warning: E-Mail Address is already registered!", "is Failed");
        
	}

	@Test
	public void Registerwithoutclickingprivacycheckbox() throws InterruptedException {

		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("priyanka", "vijith", "jyfrsfdDkF@gmail.com", "1234");
		reg.ClickSubmitButton();
		Thread.sleep(2000);
		String privacyerrormessage =res.alertMessage();
		Assert.assertEquals(privacyerrormessage, "Warning: You must agree to the Privacy Policy!");
	}

	@Test
	public void VerifyLoginlinkWorkInRegisterPage() {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		String registerTitle = Driver.getTitle();
		Assert.assertEquals(registerTitle, "Register Account");
		homePage p = new homePage(Driver);
		p.loginlink();
		String LoginTitle = Driver.getTitle();
		Assert.assertEquals(LoginTitle, "Account Login");
		System.out.println(Driver.getTitle());
	}

	@Test
	public void ValidaterefreshthePageOnRegistration() {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		Driver.navigate().refresh();
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account", "ValidaterefreshthePageOnRegistration is fail");
	}

	@Test
	public void Validatetheregistrationtitleafterrefresh() {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		Driver.get(Driver.getCurrentUrl());
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account", "ValidaterefreshthePageOnRegistration is fail");
	}

	@Test
	public void ValidateRegisterAfterclickinRegister() {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		res.MyAccount();
		res.goToRegisterPage();
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account", "ValidaterefreshthePageOnRegistration is fail");
	}

	@Test(priority = 0)
	public void ValidateifUserEnterdataAfterreshdatawillbecleared() throws InterruptedException, IOException {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("priyanka", "vijith", "jyfrsfdDkF@gmail.com", "1234");
		Driver.navigate().refresh();
		res.ClickLoginButton();
		Thread.sleep(1000);
		String error = reg.alertMessage();
		Thread.sleep(2000);
		Assert.assertEquals(error, "Warning: You must agree to the Privacy Policy!");

	}

	@Test
	public void VerifytheSpellinginRegistrationFields() {
		res = new resusableCode(Driver);
		res.MyAccount();
		RegistrationPage reg = new RegistrationPage(Driver);
		res.goToRegisterPage();
		String Firstname =reg.VerifyspellofFirstName();
		Assert.assertEquals(Firstname, "First Name", "FirstName filed text is not correct");
		String LastName = reg.VerifyspellofLastName();
		Assert.assertEquals(LastName, "Last Name", "LastName filed text is not correct");
		String EmialLabel = reg.VerifyspellofemailLabel();
		Assert.assertEquals(EmialLabel, "E-Mail", "LastName filed text is not correct");
		String PasswordLabel = reg.VerifyspellofpasswordLabel();
		Assert.assertEquals(PasswordLabel, "Password", "password filed text is not correct");

	}
	@Test
	public void VerifyRegisterationPageLinkWorkInLoginPage() throws InterruptedException {
		homePage home = new homePage(Driver);
		home.goTologinPage();
		Driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account");
	}

	@Test
	public void VeriyasideRegisterLinkWorkInLoginPage() throws InterruptedException {
		homePage home = new homePage(Driver);
		home.goTologinPage();
		Driver.findElement(By.xpath("//div//aside//div//a[2]")).click();
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account");

	}

	@Test
	public void VerifyEmailfieldacceptOnlyacceptvalidemail() throws InterruptedException {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("priyanka", "vijith", "aewfewffvvr", "1234");
		reg.ClickSubmitButton();
		String Title = Driver.getTitle();
		Assert.assertEquals(Title, "Register Account");
	}

	@Test
	public void VeriyRegisterPageWithoutEnterFirstNme() throws InterruptedException {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("", "vijith", "aewfeefewwffvvr@gmail.com", "1234");
		reg.clickPrivacy();
		reg.ClickSubmitButton();
		Thread.sleep(2000);
		String errorshow=Driver.findElement(By.id("error-firstname")).getText();
		Assert.assertEquals(errorshow,"First Name must be between 1 and 32 characters!");
	}
	@Test
	public void VeriyRegisterPageWithoutLastFirstNme() throws InterruptedException {
		res = new resusableCode(Driver);
		res.MyAccount();
		res.goToRegisterPage();
		RegistrationPage reg = new RegistrationPage(Driver);
		reg.EnterRegistrationDetails("pirya", "", "aewfeefewwffvvr@gmail.com", "1234");
		reg.clickPrivacy();
		reg.ClickSubmitButton();
		Thread.sleep(2000);
		String errorMessage=Driver.findElement(By.id("error-lastname")).getText();
		Assert.assertEquals(errorMessage, "Last Name must be between 1 and 32 characters!");
	}

}
