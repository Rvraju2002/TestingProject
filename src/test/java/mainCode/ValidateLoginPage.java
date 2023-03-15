package mainCode;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import AbstractComponents.resusableCode;
import BaseCode.basecode;
import SpilitCodes.AccounPage;
import SpilitCodes.LoginPage;
import SpilitCodes.RegistrationPage;

public class ValidateLoginPage extends basecode{
	resusableCode res;
	
	
	@Test
	public void validateLoginLinkOnHomePage() {
		
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		String Title=Driver.getTitle();
		Assert.assertEquals(Title, "Account Login");
	}
	@Test
	public void VerifySpellingLoginPage() {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage page = new LoginPage(Driver);
		String EmilSpelling=page.spellingofEmailoginPage();
		Assert.assertEquals(EmilSpelling, "E-Mail Address");
		String PasswordSpelling=page.spellingofpasswordLoginPage();
		Assert.assertEquals(PasswordSpelling, "Password");
		String forgettenPwsSpelling=page.spellingforgetpwdloginPage();
		Assert.assertEquals(forgettenPwsSpelling, "Forgotten Password");
		String loginbtnspelling=page.loginspelling();
		Assert.assertEquals(loginbtnspelling, "Login");
	}
	
    @Test
	public void  Email_Case_Insensitive_Verification() throws InterruptedException {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage page = new LoginPage(Driver);
		page.LoginApplication("RaJu@gmail.com", "12345");
		String Tilte=Driver.getTitle();
		Assert.assertEquals(Tilte, "My Account");
	}
	@Test
	public void VerifyTiltleAfterLogin() throws InterruptedException {
		GoToaccountPage();
		Thread.sleep(1000);
		String Title=Driver.getTitle();
		Assert.assertEquals(Title, "My Account");
		
	}
	@Test
	public void LoginWithoutPassword() throws InterruptedException {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.LoginApplication("raju@gmail.com", "");
		Thread.sleep(1000);
		String Text=res.alertMessage();
		Assert.assertEquals(Text, "Warning: No match for E-Mail Address and/or Password.");
	}
	@Test
	public void LoginWithOutEmail() throws InterruptedException {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.LoginApplication("", "12345");
		Thread.sleep(1000);
		String Text=res.alertMessage();
		Assert.assertEquals(Text, "Warning: No match for E-Mail Address and/or Password.");
	}
    @Test
	public void withValidcredential() throws InterruptedException {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.LoginApplication("Vignesh123@gmail.com", "12345");
		Thread.sleep(1000);
		String Text=res.alertMessage();
		Assert.assertEquals(Text, "Warning: No match for E-Mail Address and/or Password.");
	}

	@Test
    public void LoginWithOutCredential() throws InterruptedException {
    	res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
	    res.ClickLoginButton();
	    Thread.sleep(1000);
	    String Text=res.alertMessage();
		Assert.assertEquals(Text, "Warning: No match for E-Mail Address and/or Password.");
    	
    }
	@Test
	public void  verify_refresh_loginpage() throws InterruptedException {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.EnterEmail("raju@gmail.com", "12345");
		Driver.navigate().refresh();
		res.ClickLoginButton();
		String Title=Driver.getTitle();
		Assert.assertEquals(Title, "Account Login");
		
		
	}
	@Test
	public void VerifyForgetpasswordPage() {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.GoToForgetPasswordPage();
		String Title=Driver.getTitle();
		Assert.assertEquals(Title, "Forgot Your Password?");
		
	}
	@Test
	public void VerifyasideForgetpasswordLink() {
		res= new resusableCode(Driver);
		res.MyAccount();
		res.loginlink();
		LoginPage p=new LoginPage(Driver);
		p.AsideForgetLink();
		String Title=Driver.getTitle();
		Assert.assertEquals(Title, "Forgot Your Password?");
		
	}

}
