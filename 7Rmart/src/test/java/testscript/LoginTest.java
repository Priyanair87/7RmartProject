package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	public HomePage homepage;
     
	@Test(retryAnalyzer=retry.Retry.class,groups= {"Regression"},description="Verify that login success when an valid username and valid password are entered.")
	 public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	 {
		//String username="admin";
		//String password="admin"; 
	    
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
		String password=ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username).enterThePassword(password);
		homepage=loginpage.clickTheSignInButton();
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();*/
		boolean dashboardloaded=loginpage.isDashBoardDisplayed();
		Assert.assertTrue(dashboardloaded);
		
	 }
	@Test(description="Verify that login fails when an valid username and invalidvalid password are entered.")
	public void verifyTheUserIsAbleToLoginUsingValidUsername_InvalidPassword() throws IOException
	 {
		//String username="admin";
		//String password="adm"; 
	     
		String username=ExcelUtility.getStringData(2, 0, "loginpage");
		String password=ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Home Page Not Loaded");               // Validates expected results using Assert class
		
	 }
	@Test(description="Verify that login fails when an invalid username and validvalid password are entered.")
	public void verifyTheUserIsAbleToLoginUsingInalidUsername_validPassword() throws IOException
	 {
		//String username="adm";
		//String password="admin"; 
	
		String username=ExcelUtility.getStringData(3, 0, "loginpage");
		String password=ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Home Page Not Loaded");
		
	 }
	@Test(dataProvider="login data provider",description="Verify that login fails when an invalid username and invalidvalid password are entered.")
	public void verifyTheUserIsAbleToLoginUsingInvalidUsername_InvalidPassword(String username,String password) throws IOException
	 {
		//String username="adm";
		//String password="adm"; 
	
		//String username=ExcelUtility.getStringData(4, 0, "loginpage");
		//String password=ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		boolean alert=loginpage.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "Home Page Not Loaded");
		
	 }
	@DataProvider(name="login data provider")
	public Object[][] dpmethod()
	{
		return new Object[][] {{"abc","abs"},{"avg","ngf"},{"hgf","ytd"}};
	}
}

/*
 Notes:-
 
 Assertion:-  
   Is a TestNG feature, 
   Used for Validation(compare between actual and expected results)
   Commonly used for verifying application behavior,
                     validating UI elements,Page Title,Url,message
   It doesn't continue when it fails once and through a Assertion error(That means Expected conditions doesn't meet)
   
   2 Types
      1. Hard Assertion ----> It doesn't continue(stops) execution when Assertion Fails, It through an Exception
                              There is no need to create an object, just apply-->classname.methodname
                              There is no need to call a method AsserAll()
                              
      2. Soft Assertion ----> It completes execution when Assertion Fails
                              Need to create an object for a SoftAssert class,Methods of softAssert class are assertEquals,assertTrue,assertFalse etc 
                              
                              At the end, call a method AsserAll()
     For eg:-
             String actualTitle=driver.getTitle();
             String expectedTitle="obsqurazone";
             Assert.assertEquals(actualTitle,expectedTitle,"Title does not match");
                                 
 */