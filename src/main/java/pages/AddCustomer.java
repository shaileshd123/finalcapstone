package pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.TestBase;

public class AddCustomer extends TestBase {

	public AddCustomer() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// elements
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastnameField;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCodeField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addCustomerBtn;

	// Actions
	public void enterFName(String firstName) {
		firstNameField.sendKeys(firstName);
	}

	public void enterLName(String lastName) {
		lastnameField.sendKeys(lastName);
	}

	public void enterPCode(String zipcode) {
		postCodeField.sendKeys(zipcode);
	}

	public void clickaddCustBtn() {
		addCustomerBtn.click();
	}

	public String acceptAlert() {
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		al.accept();

		return alertText;
	}
}
