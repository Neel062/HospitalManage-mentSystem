package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;
import java.util.Set;

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
public class LoginPage extends WebDriverUtility{                              
                           
	WebDriver driver;
	 public LoginPage(WebDriver driver) {             
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	                           
	@FindBy(name="username")                        
	private WebElement usernameTextFeild;
	
	@FindBy(name="password")
	private WebElement passwordTextFeild;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginBtn;
	     
	
	                                             
	public WebElement getusernameTextFeild() {            
		return usernameTextFeild;                       
	}

	public WebElement getpasswordTextFeild() {
		return passwordTextFeild;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 *  login to application based username , password , url argumnets 
 * @param url
 * @param username
 * @param password
 */
	 public void loginToAdmin(WebDriver driver , String username , String password) {
		 waitForPageToLoad(driver);
		 
		 Set<String> allIds = driver.getWindowHandles();
		 
		 for(String id : allIds) {
			 driver.switchTo().window(id);
			 
			 if(driver.getTitle().contains("Admin")) {
				 break;
			 }
		 }
		 
		 getusernameTextFeild().sendKeys(username);
		 getpasswordTextFeild().sendKeys(password);
		 getLoginBtn().click(); 
	 }
	 
	 public void loginToDoctor(WebDriver driver , String username , String password) throws InterruptedException {
		 waitForPageToLoad(driver);
		 
		 Set<String> allIds = driver.getWindowHandles();
		 
		 for(String id : allIds) {
			 driver.switchTo().window(id);
			 
			 if(driver.getTitle().contains("Doctor")) {
				 break;
			 }
		 }
		 
		 getusernameTextFeild().sendKeys(username);
		 getpasswordTextFeild().sendKeys(password);
		
		 getLoginBtn().click();
	 }
	 
	 public void loginToPatient(WebDriver driver , String username , String password) throws InterruptedException {
		 waitForPageToLoad(driver);
		 
		 Set<String> allIds = driver.getWindowHandles();
		 
		 for(String id : allIds) {
			 driver.switchTo().window(id);
			 
			 if(driver.getTitle().contains("User")) {
				 break;
			 }
		 }
		 
		 getusernameTextFeild().sendKeys(username);
		 getpasswordTextFeild().sendKeys(password);
		 getLoginBtn().click();
	 }
}
