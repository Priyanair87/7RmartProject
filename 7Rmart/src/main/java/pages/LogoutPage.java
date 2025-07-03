	package pages;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LogoutPage {

		@FindBy(xpath="//input[@placeholder='Username']")WebElement uname;
		@FindBy(xpath="//input[@placeholder='Password']")WebElement pword;
		@FindBy(xpath="//button[@type='submit']")WebElement signin;
		@FindBy(xpath="//div/nav/ul[2]/li/a")WebElement image;
		@FindBy(xpath="//div/nav/ul[2]/li/div/a[2]")WebElement logout;
		@FindBy(xpath="//button[text()='Sign In']")WebElement signinpage;
		
		public WebDriver driver;
		
		public LogoutPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void admin()
		{
			image.click();
		}
		public void userLogout()
		{
			logout.click();
		}
		
		public boolean signinPageDisplayed()
		{
			return signinpage.isDisplayed();
		}
	}


