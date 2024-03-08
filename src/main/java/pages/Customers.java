package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class Customers extends TestBase {

	public Customers() throws IOException {
		PageFactory.initElements(driver, this);
	}

	//elements
	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement searchField;
	
	@FindBy(xpath = "(//table/tbody/tr/td)[1]")
	WebElement firstlistedName;
	
	
	//Actions
	public void search(String name)
	{
		searchField.sendKeys(name);
	}
	
	public String getSearchedName()
	{
		return firstlistedName.getText();
	}
		
}
