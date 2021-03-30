package com.athma.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.athma.qa.base.TestBase;
import com.athma.qa.pages.AthmaLoginPage;
import com.athma.qa.pages.HomePage;
import com.athma.qa.pages.LoginPage;
import com.athma.qa.pages.NewRegistrationPage;
import com.athma.qa.pages.RegistrationListPage;
import com.athma.qa.utils.TestUtils;

public class NewPatientRegisterTest extends TestBase {
 Logger log = Logger.getLogger(NewPatientRegisterTest.class);
	AthmaLoginPage lp;
	HomePage hp;
	RegistrationListPage rlp;
	NewRegistrationPage nrp ;
	String sheetName = "Patientdetails";

	public NewPatientRegisterTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setEnv() throws IOException{
		intialization();
		lp = new AthmaLoginPage();
		hp = new HomePage();		
		rlp = new RegistrationListPage();
		log.info("running before method");
		log.error("Error");
		log.debug("Debug");
		log.warn("Warning");
	   hp  = lp.loginPage(prop.getProperty("userName"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		
		
		}
	
	@DataProvider
	public Object[][] getPatientDetailsData() throws EncryptedDocumentException, IOException {
		Object[][] data= TestUtils.getTestData(sheetName);
		return data;
	}
	

	@Test (dataProvider = "getPatientDetailsData")
	public void newRegistraionTest(String title, String patientfirstname,String Age,String pincode) throws InterruptedException, IOException {
		System.out.println(title +" "+patientfirstname +" "+Age+" "+ pincode);
		log.info("Started test method");
		
		hp.clickonambIcon();
		hp.clickonRegistration();
		nrp = rlp.clickCretaeNewButton();
		//nrp.selectForm("RPR_MRN_ONLY");
		nrp.selectprefix(title);
		nrp.enterFirstName(patientfirstname);
		nrp.enterAge(Age);
		nrp.enterZipCode(pincode);
		nrp.clickRegisterButton();
		
		}
	}
