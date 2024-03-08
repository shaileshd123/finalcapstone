package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BankManagerLogin;
import pages.Customers;
import pages.Home;
import testbase.TestBase;

public class CustomerSearch extends TestBase {

	Home homepage;
	BankManagerLogin manglog;
	Customers cust;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homepage = new Home();
		manglog = new BankManagerLogin();
		cust = new Customers();
	}

	@Test
	public void verifySearch() throws Exception {
		String searchingName = "Harry";
		manglog  = homepage.managerLoginBtn();
		cust = manglog.clickCustomersTab();
		cust.search(searchingName);
		String name = cust.getSearchedName();
		Assert.assertEquals(searchingName, name, "searched name not found....");
		System.out.println(name + " " + searchingName);
	}
}
