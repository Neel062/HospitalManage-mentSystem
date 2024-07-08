package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Admin1_Manage_user_Page extends WebDriverUtility {
	
	public Admin1_Manage_user_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this method is used to delete user
	 * @param driver
	 * @param UserName
	 * @return
	 */
	public boolean deleteUser(WebDriver driver,String UserName) {
		
		driver.findElement(By.xpath("//td[text()='"+UserName+"']/..//i[@class='fa fa-times fa fa-white']")).click();
	
		switchtoAlertAndAccept(driver);
		boolean status = UserdeletedconfirmMsg.isDisplayed();
		System.out.println("doctor deleted");
		
		return status;
		
	
	}
	
	@FindBy(xpath = "//p[contains(text(),'data deleted !!')]	")
	private WebElement UserdeletedconfirmMsg;

	public WebElement getUserdeletedconfirmMsg() {
		return UserdeletedconfirmMsg;
	}
	

}
