package com.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BankManagerLogin;
import pages.Home;
import pages.OpenAccount;
import testbase.TestBase;

public class OpenNewAccount extends TestBase {

	Home homepage;
	BankManagerLogin banklogin;
	OpenAccount openacc;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homepage = new Home();
		banklogin = new BankManagerLogin();
		 openacc = new OpenAccount();
	}

	@Test(priority = 3)
	public void createAccount() throws Exception {
		banklogin =homepage.managerLoginBtn();
		 openacc =banklogin.clickopenAccountTab();
		 openacc.selectCustomer();
		 openacc.selectCurrency();
		 openacc.clickProcessBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String alertmsg =  openacc.acceptAlert();
		System.out.println(alertmsg);
	}
}
