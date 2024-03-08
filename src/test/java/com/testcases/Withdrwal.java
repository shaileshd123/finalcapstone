package com.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Account;
import pages.CustomerLogin;
import pages.Home;
import testbase.TestBase;

public class Withdrwal extends TestBase {

	Home homepage;
	CustomerLogin custlogin;
	Account accountpage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		homepage = new Home();
		custlogin = new CustomerLogin();
		accountpage = new Account();
	}
	
	
	@Test
	public void DepositMoney()throws Exception {
		custlogin = homepage.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		custlogin.selectUser();
		String EXPname = custlogin.selectUser();
		accountpage = custlogin.clickloginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accountpage.clickWithdrawlTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accountpage.enterWithdrawlAmount("500");
		accountpage.clickWithdrawlButton();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;
		
		String alertMsg = accountpage.getWithdarwlSuccessMSG();
		Assert.assertEquals(alertMsg,"Transaction successful");
		
		

	}
	
	
}
