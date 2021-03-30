package com.athma.qa.pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athma.qa.base.TestBase;
import com.athma.qa.utils.TestUtils;

public class HomePage extends TestBase {
	
	
	
	//@FindBy(xpath = "//span[@class='sb-icon icon-athmamodules athma-ambulatory-module-icon']")
	@FindBy(css = "span[class='sb-icon icon-athmamodules athma-ambulatory-module-icon']")
	WebElement amb_icon;
	
	@FindBy(css = "span[class='sb-icon icon-athmamodules athma-billing-module-icon']")
	WebElement invBilling_icon;
	
	@FindBy(xpath = "//a[@href='https://sqa.narayanahealth.org:7076/patient-registration']")
	WebElement patient_Registration;
	
	@FindBy(xpath = "//a[@href='/amb-invoice']")
	WebElement op_Billing;
	
	@FindBy(css = "span[class='nav-username']")
	WebElement logedInUserName;
	
	@FindBy(xpath = "//a[@class='nav-link text-uppercase pb-2 active']")
	WebElement config_name;
	
	
	
	

	public HomePage() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void clickonambIcon() throws InterruptedException {
		explicitWait(amb_icon);
		Actions act = new Actions(driver);
		act.moveToElement(amb_icon).build().perform();
		
		//amb_icon.click();
	}
	
	public void clickonRegistration() throws InterruptedException {
		explicitWait(patient_Registration);
		
		patient_Registration.click();
	}
	
	public String loggedUser() throws InterruptedException {
		explicitWait(logedInUserName);
		
		return logedInUserName.getText();
	}
	public String homePagetitle() {
		
		return driver.getTitle();
	}
	
	public String configNameTest(){
		explicitWait(config_name);
		return config_name.getText();
	}
	
	

}
