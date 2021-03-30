package com.athma.qa.pages;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athma.qa.base.TestBase;

public class NewRegistrationPage extends TestBase {
	
	@FindBy(xpath = "/html/body/jhi-main/div/section/div[2]/jhi-patient-registration-dialog/div/div[2]/div[6]/select")
	WebElement formDropDown;
	
	@FindBy(xpath ="//ng-select[@name='patientPrefix']")
	WebElement prefixDropDwon;
	
	@FindBy(name = "firstName")
	WebElement firstName;
	
	@FindBy(name = "age")
	WebElement patientAge;
	
	@FindBy(name = "correspondencePincode")
	WebElement patientZipCode;
	
	@FindBy(xpath = "//button[contains(text(),'Register')]")
	WebElement registerBtn;
	
	@FindBy(xpath = "(//button[@class='athma-btn athma-btn-secondary'])[1]")
	WebElement cancelBtn;

	public NewRegistrationPage() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void selectForm(String name) {
		explicitWait(formDropDown);
		formDropDown.click();
		Select sel = new Select(formDropDown);
		sel.selectByVisibleText(name);
	}
	
	public void selectprefix(String prefix) throws InterruptedException {
		explicitWait(prefixDropDwon);
		Actions act = new Actions(driver);
		act.moveToElement(prefixDropDwon).click().build().perform();
		//explicitWait(prefixDropDwon);
		//prefixDropDwon.sendKeys(Keys.DOWN);
		//prefixDropDwon.sendKeys(Keys.ENTER);
		
		  //prefixDropDwon.click();
		  
		 
		 //Select sel = new Select(prefixDropDwon);
		 //sel.selectByVisibleText(prefix);
		driver.findElement(By.xpath("(//span[@class='ng-option-label'])[1]")).click();
		 
}
	
	public void enterFirstName(String patientfirstName) {
		explicitWait(firstName);
		firstName.sendKeys(patientfirstName);
	}
	public void enterAge(String enterpatientAge) {
		explicitWait(patientAge);
		patientAge.sendKeys(enterpatientAge);
	}
	public void enterZipCode(String enterzipcode) {
		explicitWait(patientZipCode);
		patientZipCode.sendKeys(enterzipcode);
		patientZipCode.sendKeys(Keys.TAB);
	}
	public void clickRegisterButton() throws InterruptedException {
		explicitWait(registerBtn);
		registerBtn.click();
		explicitWait(cancelBtn);
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(cancelBtn).click().build().perform();
		System.out.println("cancel button clicked");
		
		
		//cancelBtn.click();
		
		
	}
	
	
	
	

}
