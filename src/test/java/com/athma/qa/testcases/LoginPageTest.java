package com.athma.qa.testcases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.AthmaLoginPage;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	AthmaLoginPage lp ;
	HomePage hp;

	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
	 lp = new AthmaLoginPage();
	 	}
	@Test(priority = 1)
	public void loginPagetitleTest() {
		String lpt = lp.validateloginPageTitle();
		//Assert.assertEquals(lpt,"");
		System.out.println(lpt);
	}
	@Test(priority = 2)
	public void loginIntoApp() throws IOException {
		hp = lp.loginPage(prop.getProperty("userName"), prop.getProperty("password"));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
