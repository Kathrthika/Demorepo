package com.athma.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.AthmaLoginPage;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;
import com.athma.qa.pages.RegistrationListPage;
import com.athma.qa.utils.TestUtils;

public class PatientRegistrationTest extends TestBase{
	HomePage hp;
	AthmaLoginPage ip;
	RegistrationListPage rlp;
	

	public PatientRegistrationTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		intialization();
		hp = new HomePage();
		ip = new AthmaLoginPage();
		rlp = new RegistrationListPage();
		hp = ip.loginPage(prop.getProperty("userName"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	
		
		
		
	}
	
	@Test
	public void OpenRegistrationPage() throws InterruptedException, IOException {
		//driver.wait(3000);
	
		
		//System.out.println(hp.homePagetitle());
	
		System.out.println(hp.configNameTest());
		String user_name = hp.loggedUser();
		System.out.println(user_name);
		
		hp.clickonambIcon();
		hp.clickonRegistration();
		
	}
	@Test
	public void registrationTitleTest() throws IOException, InterruptedException {
		hp.clickonambIcon();
		hp.clickonRegistration();
		
		String title = rlp.getRegistrationTitle();
		assertEquals(title, "Patient Registrations","Registration title name is wrong");
	}
	@Test
	public void createNewButtonTest() throws InterruptedException {
		hp.clickonambIcon();
		hp.clickonRegistration();
		boolean buttonStatus = rlp.getcreateNewbuttonstatus();
		assertEquals(buttonStatus, true,"Create New button is not enabled");
		
	}
	@AfterMethod
	public void closed() {
		driver.close();
	}
	
	

}
