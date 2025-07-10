package testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	public AdminUsersPage adminuserspage;
	public HomePage homepage;
   
	@Test(retryAnalyzer=retry.Retry.class,description="Verify that an authorized user can successfully create a new Admin account via the user management interface.")
	public void verifyTheUserIsAbleToCreateTheAdminUsers() throws IOException
	{
		        //String username="Ranjith";
				//String password="Ranjith@321"; 
				
		        String username=ExcelUtility.getStringData(1, 0, "loginpage");
		        String password=ExcelUtility.getStringData(1, 1, "loginpage");
		        
		        //String user=ExcelUtility.getStringData(1, 0, "adminuserspage");
				//String pass=ExcelUtility.getStringData(1, 1, "adminuserspage");
				
				LoginPage loginpage=new LoginPage(driver);
				loginpage.enterTheUserName(username).enterThePassword(password);
				homepage=loginpage.clickTheSignInButton();
				adminuserspage=homepage.clickMoreInformationAdmin();
				FakerUtility fakerutility=new FakerUtility();
				String adminusername=fakerutility.creatARandomFirstName();
				String adminpassword=fakerutility.creatARandomFirstName();
				
				adminuserspage.clickNewButton().enterUserName(adminusername).enterPassword(adminpassword).selectUserType().saveAdminUsers();
				
				/*loginpage.enterTheUserName(username);
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
				adminuserspage.saveAdminUsers();*/
				boolean alertmsg=adminuserspage.displayAlertMessage();
				Assert.assertTrue(alertmsg,"user is failed to create the username and the password");
	}
	
	@Test(retryAnalyzer=retry.Retry.class,description="Verify that an authorized user can successfully update a new Admin account via the user management interface.")
	public void verifyTheUserIsAbleToUpdateTheAdminUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "loginpage");
        String password=ExcelUtility.getStringData(1, 1, "loginpage");
        
        LoginPage loginpage=new LoginPage(driver);
        loginpage.enterTheUserName(username).enterThePassword(password);
        homepage=loginpage.clickTheSignInButton();
        adminuserspage=homepage.clickMoreInformationAdmin();
        adminuserspage.editAdminUsers().updateAdminUsers();
   
        
		/*loginpage.enterTheUserName(username);
		loginpage.enterThePassword(password);
		loginpage.clickTheSignInButton();
		
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage=homepage.clickMoreInformationAdmin();
		adminuserspage.editAdminUsers();
		adminuserspage.updateAdminUsers();*/
		
		boolean alert=adminuserspage.displayAlert();
		Assert.assertTrue(alert,"user is failed to update the username and the password");
	}
}