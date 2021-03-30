

package com.athma.qa.testcases;

import java.io.IOException;

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

public class PracticeTest extends TestBase {
	AthmaLoginPage lp;
	HomePage hp;
	RegistrationListPage rlp;
	NewRegistrationPage nrp ;
	String sheetName = "Patientdetails";

	public PracticeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setEnv() throws IOException{
		intialization();
		lp = new AthmaLoginPage();
		hp = new HomePage();		
		rlp = new RegistrationListPage();
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
	

	@Test 
	public void newRegistraionTest() throws InterruptedException, IOException {
		
		hp.clickonambIcon();
		hp.clickonRegistration();
		nrp = rlp.clickCretaeNewButton();
		//nrp.selectForm("RPR_MRN_ONLY");
		nrp.selectprefix("Mr.");
		nrp.enterFirstName("Aniruth");
		nrp.enterAge("25");
		nrp.enterZipCode("560021");
		nrp.clickRegisterButton();
		
		
		
		
		
	}
	}
