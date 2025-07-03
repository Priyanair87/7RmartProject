package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage 
{
	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']//parent::li/a")WebElement moreinfomcontact;
	@FindBy(xpath="//i[@class='fas fa-edit']//parent::a/i")WebElement action;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//input[@id='email']")WebElement email; 
	@FindBy(xpath="//textarea[@id='content']//parent::div/textarea[1]")WebElement address;
	@FindBy(xpath="//button[@name='Update']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;

    public WebDriver driver;
	
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moreInfoManageContact()
	{
		moreinfomcontact.click();
	}
	public void actionManageContact()
	{
		action.click();
	}
	
	public void phonenumberManageContact(String phno)
	{
		phone.clear();
		phone.sendKeys(phno);
	}
	
	public void emailManageContact(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}
	
	public void addressManageContact(String add)
	{
		address.clear();
		address.sendKeys(add);
	}
	public void updateManageContact()
	{
		PageUtility pageutility=new PageUtility();
		pageutility.javaSriptClick(driver, update);                            //update.click();
	}
	
	public boolean isAlertMessageIsDisplayed()
	{
		return alertmsg.isDisplayed();
	}
}
