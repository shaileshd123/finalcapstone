package com.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Account;
import pages.CustomerLogin;
import pages.Home;
import testbase.TestBase;

public class Login extends TestBase {

	Home hp;
	CustomerLogin custlog;
	Account acc;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		hp = new Home();
		custlog = new CustomerLogin();
		acc = new Account();
	}

	@Test
	public void verifyLogin() throws Exception {
		custlog = hp.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		custlog.selectUser();
		String EXPname = custlog.selectUser();
		acc = custlog.clickloginbtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String ActUser = acc.getUserName();
		System.out.println(EXPname + "  and   " + ActUser);
		Assert.assertEquals(EXPname, ActUser, "Selected user is not logged in...");
	}
}

