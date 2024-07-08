package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class PatientCreateAnAccount extends WebDriverUtility {
	WebDriver driver;
	public PatientCreateAnAccount(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='full_name']")
	private WebElement FullNameText;
	
	@FindBy(xpath = "//label[@for='rg-male']")
	private WebElement MaleRadioBtn;
	
	@FindBy(xpath = "//label[@for='rg-female']")
	private WebElement FemaleRadioBtn;
	
	@FindBy(partialLinkText="Create an account")
	private WebElement createAnAccPatient;
	
	public WebElement getFemaleRadioBtn() {
		return FemaleRadioBtn;
	}

	public WebElement getcreateAnAccPatient() {
		return createAnAccPatient;
	}

	public WebElement getMaleRadioBtn() {
		return MaleRadioBtn;
	}
	@FindBy(xpath = "//input[@name='address']")
	private WebElement AddressTxt;
	
	@FindBy(xpath = "//input[@name='city']")
	private WebElement cityTxt;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTxt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@name='password_again']")
	private WebElement PwdAgainTxt;
	
	@FindBy(name ="submit")
	private WebElement SubmitBtn;

	public WebElement getFullNameText() {
		return FullNameText;
	}

	public WebElement getAddressTxt() {
		return AddressTxt;
	}

	public WebElement getCityTxt() {
		return cityTxt;
	}

	public WebElement getEmailTxt() {
		return emailTxt;
	}

	public WebElement getPasswordTxt() {
		return passwordTxt;
	}

	public WebElement getPwdAgainTxt() {
		return PwdAgainTxt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	/**
	 * BusinessLogic for creating patient account
	 * 
	 * @param fullNameTxt
	 * @param address
	 * @param city
	 * @param email
	 * @param password
	 * @param confirmPassword
	 */
	public void addPatientUserM(String FullNameTxt,String address, String city, String email, String password, String confirmPassword) {
		FullNameText.sendKeys(FullNameTxt);
		AddressTxt.sendKeys(address);
		cityTxt.sendKeys(city);
		MaleRadioBtn.click();
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		PwdAgainTxt.sendKeys(confirmPassword);
		SubmitBtn.click();
	}
	
	public WebElement getCreateAnAccPatient() {
		return createAnAccPatient;
	}

	public void addPatientUserF(String FullNameTxt,String address, String city, String email, String password, String confirmPassword) {
		FullNameText.sendKeys(FullNameTxt);
		AddressTxt.sendKeys(address);
		cityTxt.sendKeys(city);
		FemaleRadioBtn.click();
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		PwdAgainTxt.sendKeys(confirmPassword);
		SubmitBtn.click();
	}
	
}
