package testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomePageTest extends Base{
	
	public HomePage homepage;
    
	@Test(retryAnalyzer=retry.Retry.class,description="Verify that a logged-in user can log out successfully, is redirected to the login page, and the session ends properly.")
	public void isUserIsAbleToLogOut() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		homepage.admin().userLogout();
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		HomePage logoutpage=new HomePage(driver);
		logoutpage.admin();
		logoutpage.userLogout();*/
		
		boolean signpage=homepage.signinPageDisplayed();
		Assert.assertTrue(signpage,"Logout failed. Please try again");
		
	}
}