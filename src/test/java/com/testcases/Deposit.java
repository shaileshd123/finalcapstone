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

public class Deposit extends TestBase{

	Home homepage;
	CustomerLogin custpage ;
	Account accountpage;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		homepage = new Home();
		custpage = new CustomerLogin();
		accountpage = new Account();
	}
	public Deposit() {
		super();
	}
	
	@Test
	public void DepositMoney()throws Exception {
		custpage  = homepage .customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		custpage .selectUser();
		String EXPname =custpage .selectUser();
		accountpage = custpage .clickloginbtn();
		
		accountpage.clickDepositTab();
		
		accountpage.enterDepositAmount("900");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		accountpage.clickDepositButton();
		
		
		
		String alertMsg = accountpage.getDepositSuccessMSG();
		Assert.assertEquals(alertMsg,"Deposit Successful");

	}
		

}

