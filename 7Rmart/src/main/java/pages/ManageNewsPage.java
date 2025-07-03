package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	public WebDriver driver;
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
	@FindBy(xpath="//button[@type='submit']")WebElement signin;
	@FindBy(xpath=" //a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//parent::li") WebElement moreinfo;
	@FindBy(xpath=" //a[text()=' New']") WebElement newoption;
	@FindBy(xpath=" //textarea[@id='news']") WebElement enternews;
	@FindBy(xpath=" //button[@name='create']") WebElement save;
	@FindBy(xpath=" //div[@class='alert alert-success alert-dismissible']") WebElement alert;

	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
   public void clickMoreInformation()
   {
	 moreinfo.click();
    }
   
   public void clickNewButton()
   {
	 newoption.click();
   }
   
  public void enterNewsInformation(String news)
   {
	 enternews.sendKeys(news);
   }
  
  public void saveNews()
   {
	 save.click();
   }
  
  public boolean displayAlertMessage()
   {
	 return alert.isDisplayed();
   }
 
   @FindBy(xpath="//table/tbody/tr[3]/td[2]/a[1]/i") WebElement edit;
   @FindBy(xpath="//button[@name='update']") WebElement update;
   @FindBy(xpath="//h5[text()=' Alert!']") WebElement alertmsg;
  
   public void editNews()
   {
	   edit.click();
   }
   
   public void updateNews()
   {
	   update.click();
   }
   
   public boolean displayAlert()
   {
	   return alertmsg.isDisplayed();
   }
}