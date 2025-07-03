package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {

	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']//parent::li/a")WebElement managefootermoreinfo;
	@FindBy(xpath="(//i[@class='fas fa-edit']//parent::a)[1]")WebElement action;
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phonenumber;
	@FindBy(xpath="//button[@type='submit']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertmsg;

	public WebDriver driver;
	
	public ManageFooterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moreInfoManageFooter()
	{
		managefootermoreinfo.click();
	}
	
	public void actionButton()
	{
		action.click();
	}
	
	public void addressFooterTextInfo(String add)
	{
		address.clear();
		address.sendKeys(add);
	}
	
	public void phonenumberFooterTextInfo(String phno)
	{
		phonenumber.clear();
		phonenumber.sendKeys(phno);
	}
	
	public void emailFooterTextInfo(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}
	
	
	public void updateFooterTextInfo()
	{
		update.click();
	}
	
	public boolean isAlertMessageIsDisplayed()
	{
		return alertmsg.isDisplayed();
	}
}