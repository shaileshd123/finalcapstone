package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class Home extends TestBase {

	public Home()  {
		
		PageFactory.initElements(driver, this);
	}

	//elements
	@FindBy(xpath = "//button[contains(.,'Customer Login')]")
	WebElement customerlogin;

	@FindBy(xpath ="//button[contains(.,'Bank Manager Login')]")
	WebElement managerlogin;
	
	@FindBy(xpath ="//strong[contains(.,'XYZ Bank')]")
	WebElement logo;
	
	
	//Actions   
	public String verifyLogoText()
	{
		return logo.getText();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();		
	}
	
	public String getPageURL()
	{
		return driver.getCurrentUrl();		
	}
	
	public CustomerLogin customerLoginbtn() throws IOException
	{
		customerlogin.click();
		return new CustomerLogin();
	}
	
	public BankManagerLogin managerLoginBtn() throws IOException
	{
		managerlogin.click();
		
		return new BankManagerLogin();
	}
}
