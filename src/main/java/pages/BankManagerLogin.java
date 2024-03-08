package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class BankManagerLogin extends TestBase{

	public BankManagerLogin() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	 //elements
		@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
		WebElement addCustomerTab;
		
		@FindBy(xpath = "//button[contains(text(),'Open Account')]")
		WebElement openAccountTab;
		
		@FindBy(xpath = "//button[contains(normalize-space(), \"Customers\")]")
		WebElement customersTab;


	//Actions
		
		public AddCustomer clickaddCustomerTab() throws IOException
		{
			addCustomerTab.click();
			return new AddCustomer();
		}
		
		public OpenAccount clickopenAccountTab() throws Exception
		{
			openAccountTab.click();
			return new OpenAccount();
		}
		
		public Customers clickCustomersTab() throws IOException
		{
			customersTab.click();
			return new Customers();
		}
		
}
