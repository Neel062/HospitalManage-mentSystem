package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPatientSearch {

	public AdminPatientSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='searchdata']")
	private WebElement SearchbyName_MobileNo_Txt;
	
	@FindBy(xpath = "//button[@name='search']")
	private WebElement SearchBtn;

	public WebElement getSearchbyName_MobileNo_Txt() {
		return SearchbyName_MobileNo_Txt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	public boolean verifyaddedpatient(WebDriver driver, String patient) {
		boolean status = driver.findElement(By.xpath("//td[text()='"+patient+"']")).isDisplayed();
		
		return status;
	}}
