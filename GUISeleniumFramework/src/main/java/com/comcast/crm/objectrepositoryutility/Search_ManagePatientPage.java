package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Anbumathi
 * 
 * Contains search patients by name and contact number
 *
 */  
public class Search_ManagePatientPage extends WebDriverUtility {
	
	
	public Search_ManagePatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "searchdata")
	private WebElement searchByName;
	
	@FindBy(id = "searchdata")
	private WebElement searchByMobileNo;
	
	@FindBy(id = "submit")
	private WebElement searchBtn;

	public WebElement getSearchByName() {
		return searchByName;
	}

	public WebElement getSearchByMobileNo() {
		return searchByMobileNo;
	}
	

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchByName(String patName) {
		searchByName.sendKeys(patName);
	}
	
	public void searchByMobileNo(String patMobileNO) {
		searchByMobileNo.sendKeys(patMobileNO);
	}

	public void verifyAfterSearch(WebDriver driver,String patName) {
		boolean status = driver.findElement(By.xpath("//td[text()='"+patName+"']")).isDisplayed();
		Assert.assertTrue(status);
	}
}
