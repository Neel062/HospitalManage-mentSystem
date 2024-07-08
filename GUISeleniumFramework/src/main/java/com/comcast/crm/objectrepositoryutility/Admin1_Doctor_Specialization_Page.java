package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Nithish
 *This page contains Doctor_Specialization elements
 */

public class Admin1_Doctor_Specialization_Page {
	
	public Admin1_Doctor_Specialization_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "doctorspecilization")
	private WebElement DoctorspecilizationTxt;
	
	@FindBy(name = "submit")
	private WebElement SubmitBtn;
	
	public WebElement getDoctorspecilizationTxt() {
		return DoctorspecilizationTxt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	public WebElement getDoctorspecilizationConfirmMsg() {
		return DoctorspecilizationConfirmMsg;
	}

	@FindBy(xpath = "//p[contains(text(),'Doctor Specialization added successfully !!')]")
	private WebElement DoctorspecilizationConfirmMsg ;
	
	/**
	 * to add doctor specialization
	 * @param text
	 */
	public void addSpecialization(String text) {
		DoctorspecilizationTxt.sendKeys(text);
		SubmitBtn.click();
	}

}
