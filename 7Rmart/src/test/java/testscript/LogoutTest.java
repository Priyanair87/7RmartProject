package testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base{
    
	@Test(retryAnalyzer=retry.Retry.class)
	public void isUserIsAbleToLogOut() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		LogoutPage logoutpage=new LogoutPage(driver);
		logoutpage.admin();
		logoutpage.userLogout();
		
		boolean signpage=logoutpage.signinPageDisplayed();
		Assert.assertTrue(signpage);
		
	}
}