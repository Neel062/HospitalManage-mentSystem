package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminContactUs {

	public AdminContactUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='pagetitle']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//div[@class=' nicEdit-main ']")
	private WebElement PageDescpinCntctUs_Txt;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email_Txt;
	
	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getPageDescpinCntctUs_Txt() {
		return PageDescpinCntctUs_Txt;
	}

	public WebElement getEmail_Txt() {
		return email_Txt;
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//input[@name='mobnum']")
	private WebElement contactNo;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitBtn;
}
