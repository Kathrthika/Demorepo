package com.athma.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.athma.qa.utils.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException 
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\339154\\eclipse-workspace\\AthmaTest\\src\\main\\java\\com\\athma\\qa\\config\\config.properties");
		prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	public static void intialization() {
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		String url = prop.getProperty("url");
		System.out.println(url);
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MILLISECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMP_WAIT, TimeUnit.MILLISECONDS);
	}
	
	

	public void explicitWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.IMP_WAIT);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public void explicitWaitclickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,TestUtils.IMP_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	

}

