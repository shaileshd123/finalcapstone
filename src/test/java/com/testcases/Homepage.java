package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Home;
import testbase.TestBase;

public class Homepage extends TestBase {
	Home homepage;

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		homepage = new Home();
	}

	@Test(priority = 1)
	public void homePageTest() throws InterruptedException {
		String explogo = homepage.verifyLogoText();
		Assert.assertEquals(explogo, "XYZ Bank", "Expected logo text is not present");
		String expTitle = homepage.getPageTitle();
		Assert.assertEquals(expTitle, "XYZ Bank", "Expected title is not present");
		String actUrl = homepage.getPageURL();
		Assert.assertEquals(actUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",
				"Expected url is not present");
		System.out.println(actUrl);
	}
}
