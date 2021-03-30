package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class RegistrationListPage extends TestBase {
	
	@FindBy(css = "button[class='athma-btn athma-btn-priamry-outline']")
	WebElement createNewButton;
	@FindBy(xpath = "//a[contains(text(),'Patient Registrations')]")
	WebElement registrationTitle;
	
	@FindBy(id = "inputDebounce")
	WebElement patientSearch;
	
	@FindBy(xpath = "//table[@class='table athma-table fixed-header-table-body']/tbody/tr/td")
	WebElement searchedPatientmrn;
	

	public RegistrationListPage() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String getRegistrationTitle() {
		explicitWait(registrationTitle);		
		return registrationTitle.getText();
	}
	public boolean getcreateNewbuttonstatus() {
		explicitWait(createNewButton);
		return createNewButton.isEnabled();
	}
	
	public NewRegistrationPage clickCretaeNewButton() throws IOException {
		explicitWait(createNewButton);
		createNewButton.click();
		return new NewRegistrationPage();
	}

}
