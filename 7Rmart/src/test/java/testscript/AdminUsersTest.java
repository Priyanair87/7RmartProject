package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
   
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToCreateTheAdminUsers() throws IOException
	{
		        //String username="Ranjith";
				//String password="Ranjith@321"; 
				
		        String username=ExcelUtility.getStringData(1, 0, "loginpage");
		        String password=ExcelUtility.getStringData(1, 1, "loginpage");
		        
		        //String user=ExcelUtility.getStringData(1, 0, "adminuserspage");
				//String pass=ExcelUtility.getStringData(1, 1, "adminuserspage");
				
				LoginPage loginpage=new LoginPage(driver);
				loginpage.enterTheUserName(username);
				loginpage.enterThePassword(password);
				loginpage.clickTheSignInButton();
				
				AdminUsersPage adminuserspage=new AdminUsersPage(driver);
				
				FakerUtility fakerutility=new FakerUtility();
				String adminusername=fakerutility.creatARandomFirstName();
				String adminpassword=fakerutility.creatARandomFirstName();
				
				
				adminuserspage.clickMoreInformationAdmin();
				adminuserspage.clickNewButton();
				adminuserspage.enterUserName(adminusername);
				adminuserspage.enterPassword(adminpassword);
				adminuserspage.selectUserType();
				adminuserspage.saveAdminUsers();
				boolean alertmsg=adminuserspage.displayAlertMessage();
				Assert.assertTrue(alertmsg);
	}
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToUpdateTheAdminUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
        String password=ExcelUtility.getStringData(1, 1, "loginpage");
        
        LoginPage loginpage=new LoginPage(driver);
		loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickMoreInformationAdmin();
		adminuserspage.editAdminUsers();
		adminuserspage.updateAdminUsers();
		
		boolean alert=adminuserspage.displayAlert();
		Assert.assertTrue(alert);
	}
}