package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * 
 * @author Nithish
 * this page contains admin dashboard elements
 *
 */

public class Admin1_Dashboard_Page extends WebDriverUtility {
	

	public Admin1_Dashboard_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement Doctordropdown;
	
	public WebElement getDoctordropdown() {
		return Doctordropdown;
	}
	
	 @FindBy(xpath ="//span[text()=' Users ']")
	 private WebElement  Usersdropdown;
	 
	 @FindBy(xpath ="//span[text()=' Doctor Session Logs ']")
	 private WebElement DoctorSessionLogs;
	 
	 @FindBy(xpath ="//span[text()=' User Session Logs ']")
	 private WebElement UserSessionLogs;
	 
	 @FindBy(xpath ="//span[text()=' Reports ']")
	 private WebElement Reports;
	 
	 @FindBy(partialLinkText ="Total Users")
	 private WebElement TotalUsersLink;
	 
	 @FindBy(partialLinkText ="Total Doctors")
	 private WebElement TotalDoctorsLink;
	 
	 @FindBy(partialLinkText ="Total Appointments")
	 private WebElement TotalAppointmentsLink;
	 
	 public WebElement getUsersdropdown() {
		return Usersdropdown;
	}

	public WebElement getDoctorspecilizationLink() {
		return DoctorspecilizationLink;
	}

	public WebElement getAddDoctorsLink() {
		return AddDoctorsLink;
	}

	public WebElement getManageDoctorsLink() {
		return ManageDoctorsLink;
	}

	public WebElement getManageUsersLink() {
		return ManageUsersLink;
	}

	public WebElement getBetweendatesreportsLink() {
		return BetweendatesreportsLink;
	}

	public WebElement getDoctorSessionLogs() {
		return DoctorSessionLogs;
	}

	public WebElement getUserSessionLogs() {
		return UserSessionLogs;
	}

	public WebElement getReports() {
		return Reports;
	}

	public WebElement getTotalUsersLink() {
		return TotalUsersLink;
	}

	public WebElement getTotalDoctorsLink() {
		return TotalDoctorsLink;
	}

	public WebElement getTotalAppointmentsLink() {
		return TotalAppointmentsLink;
	}

	public WebElement getTotalPatientsLink() {
		return TotalPatientsLink;
	}

	public WebElement getTotalNewQueriesLink() {
		return TotalNewQueriesLink;
	}

	@FindBy(partialLinkText ="Total Patients")
	 private WebElement TotalPatientsLink;
	 
	 @FindBy(partialLinkText ="Total New Queries")
	 private WebElement TotalNewQueriesLink;
	 
	 @FindBy(xpath ="//span[text()=' Doctor Specialization ']")
		private WebElement DoctorspecilizationLink;
	 

	 @FindBy(xpath ="//span[text()=' Add Doctor']")
		private WebElement AddDoctorsLink;
		
	 @FindBy(xpath ="//span[text()=' Manage Doctors ']")
		private WebElement ManageDoctorsLink;
	 	
	 @FindBy(xpath ="//span[text()=' Manage Users ']")
		private WebElement ManageUsersLink;
	 
	 public WebElement getManagepatientLink() {
		return ManagepatientLink;
	}

	@FindBy(xpath ="//span[text()=' Manage Patients ']")
		private WebElement ManagepatientLink;
	 
	 @FindBy(xpath ="//span[text()='B/w dates reports ']")
		private WebElement BetweendatesreportsLink;
	 /*
	  * this methos is used to find row count 
	  */
	 public int gettablecount(WebDriver driver) {
		 
		 List<WebElement> list = driver.findElements(By.xpath("//tbody/tr"));
		 
		 return list.size();
	 }
	 
	
	 
	 
		
	 
}
	 
