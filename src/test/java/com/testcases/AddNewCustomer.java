package com.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AddCustomer;
import pages.BankManagerLogin;
import pages.Home;
import testbase.TestBase;

public class AddNewCustomer extends TestBase {

	Home homepage;
	AddCustomer addcust;
	BankManagerLogin bankmanglog;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homepage = new Home();
		addcust = new AddCustomer();
		bankmanglog = new BankManagerLogin();
	}

	@Test
	public void verifyManagerLogin() throws Exception {
		homepage.managerLoginBtn();
		bankmanglog.clickaddCustomerTab();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		addcust.enterFName(prop.getProperty("firstname"));
		addcust.enterLName(prop.getProperty("lastname"));
		addcust.enterPCode(prop.getProperty("zipcode"));
		addcust.clickaddCustBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String alertMsg = addcust.acceptAlert();
		System.out.println(alertMsg);
	}
}
