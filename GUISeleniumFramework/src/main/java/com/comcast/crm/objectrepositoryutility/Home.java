package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class Home extends WebDriverUtility{                             
                           
	WebDriver driver;
	
	@FindBy(xpath = "//h6[text()='Patient Login']/../a/button")
	private WebElement patienLoginClickHereButton;
	
	@FindBy(xpath = "//h6[text()='Doctors login']/../a/button")
	private WebElement doctorLoginClickHereButton;
	
	@FindBy(xpath = "//h6[text()='Admin Login']/../a/button")
	private WebElement adminLoginClickHereButton;
	
	@FindBy(xpath = "//span[@class='username']")
	private WebElement adminAccount;
	
	@FindBy(xpath = "//a[contains(text(),'Log Out')]")
	private WebElement logoutLink;
	
	 public Home(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPatienLoginClickHereButton() {
		return patienLoginClickHereButton;
	}

	public WebElement getDoctorLoginClickHereButton() {
		return doctorLoginClickHereButton;
	}

	public WebElement getAdminLoginClickHereButton() {
		return adminLoginClickHereButton;
	}

	public WebElement getAdminAccount() {
		return adminAccount;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	

	 
	

	
	
}
