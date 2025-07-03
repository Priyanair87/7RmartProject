package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;


public class AdminUsersPage {
 
	public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::div/a")WebElement moreinfoadmin;
	@FindBy(xpath="//a[text()=' New']")WebElement newbtn;
	@FindBy(xpath="//input[@id='username']")WebElement usernme;
	@FindBy(xpath="//input[@id='password']")WebElement passwrd;
	@FindBy(xpath="//select[@id='user_type']")WebElement usrtype;
	@FindBy(xpath="//button[@name='Create']")WebElement savebtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
    public void clickMoreInformationAdmin()
   {
    	moreinfoadmin.click();
   }
    
    public void clickNewButton()
    {
  	 newbtn.click();
    }
    
    public void enterUserName(String user)
	{
    	usernme.sendKeys(user);
	}
	
    public void enterPassword(String pass)
	{
    	passwrd.sendKeys(pass);
	}
    
    public void selectUserType()
	{ 
    	PageUtility pageutility=new PageUtility();
    	pageutility.selectByIndex(usrtype, 2);          //  sc.selectByIndex(2);
    }
    
    public void saveAdminUsers()
    {
    	savebtn.click();
    }
    
    public boolean displayAlertMessage()
    {
  	 return alertmsg.isDisplayed();
    }
    
    @FindBy(xpath="//table/tbody/tr[1]/td[5]/a[2]/i")WebElement edit;
    @FindBy(xpath="//button[@name='Update']")WebElement update;
    @FindBy(xpath="//h5[text()=' Alert!']")WebElement alert;
    
    public void editAdminUsers()
    {
    	edit.click();
    }
    
    public void updateAdminUsers()
    {
    	update.click();
    }
    
    public boolean displayAlert()
    {
  	 return alert.isDisplayed();
    }
}
