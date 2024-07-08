package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientLoginPage {

	public  WebDriver driver = null;

	FileUtility fLib = new FileUtility();
	
	public PatientLoginPage(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);

	
	UtilityClassObject.setDriver(driver);
	driver.manage().window().maximize();
	driver.get(System.getProperty("url" ,fLib.getDataFromPropertiesFile("url")));
	
}
	
}
