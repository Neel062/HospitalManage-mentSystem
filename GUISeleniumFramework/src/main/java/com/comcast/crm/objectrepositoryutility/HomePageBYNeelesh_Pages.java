package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageBYNeelesh_Pages {

	public HomePageBYNeelesh_Pages(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Contact Us")
	private WebElement ContactUs;
	
	@FindBy(xpath = "//input[@name='mobileno']")
	private WebElement MobileNumberTextField;
	
	@FindBy(xpath = "//input[@name='fullname']")
	private WebElement FirstName;
	
	@FindBy(xpath = "//input[@name='emailid']")
	private WebElement emailadd;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement EnterMessege;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement SendMessegeBtn;
	
	@FindBy(xpath = "//h6[text()='Patient Login']/..//button[text()='Click Here']")
	private WebElement patientclickhere;
	
	public WebElement getPatientclickhere() {
		return patientclickhere;
	}

	public WebElement getSendMessegeBtn() {
		return SendMessegeBtn;
	}

	public WebElement getContactUs() {
		return ContactUs;
	}

	public WebElement getMobileNumberTextField() {
		return MobileNumberTextField;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getEmailadd() {
		return emailadd;
	}

	public WebElement getEnterMessege() {
		return EnterMessege;
	}
	
}
