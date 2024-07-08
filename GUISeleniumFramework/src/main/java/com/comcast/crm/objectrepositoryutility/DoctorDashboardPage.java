package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * 
 * @author Anbumathi
 * 
 * Contains Update profile and Appointment history links
 * Contains Appointment history button, Patients dropdown, SearchFeature
 * Add and manage patients button/feature
 *
 */  
public class DoctorDashboardPage extends WebDriverUtility {
	
	public DoctorDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(partialLinkText = "Update Profile")
	private WebElement updateProfileLink;
	
	@FindBy(xpath ="//span[text()=' Appointment History ']")
	private WebElement viewAppointmentHistoryLink;

	@FindBy(xpath ="//span[text()=' Dashboard ']")
	private WebElement dashboardBtn;
	
	@FindBy(xpath ="//span[text()=' Appointment History ']")
	private WebElement appointmentHistoryBtn;
	
	@FindBy(xpath ="//span[text()=' Patients ']")
	private WebElement PatientsDropDown;
	
	@FindBy(xpath ="//span[text()=' Search ']")
	private WebElement searchFeatureBtn;
	
	@FindBy(xpath = "//span[text()=' Add Patient']")
	private WebElement addPatientBtn;
	
	@FindBy(xpath = "//span[text()=' Manage Patient ']")
	private WebElement managePatientBtn;
	
	public WebElement getDashboardBtn() {
		return dashboardBtn;
	}

	public WebElement getAppointmentHistoryBtn() {
		return appointmentHistoryBtn;
	}

	public WebElement getPatientsDropDown() {
		return PatientsDropDown;
	}

	public WebElement getSearchFeatureBtn() {
		return searchFeatureBtn;
	}

	public WebElement getAddPatientBtn() {
		return addPatientBtn;
	}

	public WebElement getManagePatientBtn() {
		return managePatientBtn;
	}
	
	public WebElement getUpdateProfileLink() {
		return updateProfileLink;
	}

	public WebElement getViewAppointmentHistoryLink() {
		return viewAppointmentHistoryLink;
	}
	
//	public void verifyAdminAppointmentisbooked(WebDriver driver, String patient) {
//		driver.findElement(By.xpath("//td[contains(text(),'2024-07-04 17:49:06')]/..//a[text()='Cancel']")).click();
//	}
}

