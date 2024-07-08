package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftPanelMainNavigation {

	public LeftPanelMainNavigation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement patient;
	
	public WebElement getPatient() {
		return patient;
	}

	public WebElement getManageptnt() {
		return manageptnt;
	}

	public WebElement getAppointmntHstry() {
		return appointmntHstry;
	}

	public WebElement getContctedQueries() {
		return ContctedQueries;
	}

	public WebElement getUnrdQuers() {
		return unrdQuers;
	}

	public WebElement getReadQuers() {
		return ReadQuers;
	}

	public WebElement getBtwReprts() {
		return BtwReprts;
	}

	public WebElement getReports() {
		return reports;
	}

	public WebElement getPages() {
		return pages;
	}

	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement manageptnt;
	
	@FindBy(xpath = "//span[contains(text(),' Users ')]")
	private WebElement user;
	
	@FindBy(xpath = "//span[contains(text(),' Manage Users ')]")
	private WebElement ManageUser;
	
	public WebElement getUser() {
		return user;
	}

	public WebElement getManageUser() {
		return ManageUser;
	}

	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement appointmntHstry;
	
	@FindBy(xpath = "//span[text()=' Conatctus Queries ']")
	private WebElement ContctedQueries;
	
	@FindBy(xpath = "//span[text()=' Unread Query ']")
	private WebElement unrdQuers;
	
	@FindBy(xpath = "//span[text()=' Read Query ']")
	private WebElement ReadQuers;
	
	@FindBy(xpath = "//span[text()='B/w dates reports ']")
	private WebElement BtwReprts;
	
	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement reports;
	
	@FindBy(xpath = "//span[text()=' Pages ']")
	private WebElement pages;
	
	@FindBy(xpath = "//span[contains(text(),' Patient Search ')]")
	private WebElement patientSearch;

	public WebElement getPatientSearch() {
		return patientSearch;
	}
}
