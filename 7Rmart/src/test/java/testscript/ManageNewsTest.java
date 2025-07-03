package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test(retryAnalyzer=retry.Retry.class)
	
	public void verifyTheUserIsAbleToEnterTheNews() throws IOException
	{
		//String username="admin";
		//String password="admin"; 
		//String news="New Offer Alert!Don't miss out!Flash sale ends soon.";
		
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		String news=ExcelUtility.getStringData(1, 0,"managenewspage");
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.clickNewButton();
		managenewspage.enterNewsInformation(news);
		managenewspage.saveNews();
		boolean alertmessage=managenewspage.displayAlertMessage();
		Assert.assertTrue(alertmessage);
		
	}
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToUpdateTheNews() throws IOException
	{
		
		String username=ExcelUtility.getStringData(1, 0,"loginpage");
		String password=ExcelUtility.getStringData(1, 1,"loginpage");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickMoreInformation();
		managenewspage.editNews();
		managenewspage.updateNews();
		managenewspage.displayAlert();
		
		boolean alertmsg=managenewspage.displayAlertMessage();
		Assert.assertTrue(alertmsg);
		
	}
}
