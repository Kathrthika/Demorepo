package com.athma.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.athma.qa.base.TestBase;

public class AthmaLoginPage extends TestBase{
	
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement sign_in_Btn;

	public AthmaLoginPage() throws IOException {
		//super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public String validateloginPageTitle() {
		return driver.getTitle();
		
	}
	public HomePage loginPage(String un,String Pwd) throws IOException {
		userName.sendKeys(un);
		password.sendKeys(Pwd);
		sign_in_Btn.click();
		return new HomePage();
	}

}
