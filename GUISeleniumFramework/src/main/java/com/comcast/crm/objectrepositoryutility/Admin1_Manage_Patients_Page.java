package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Admin1_Manage_Patients_Page {


	public Admin1_Manage_Patients_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to verify Added Patient Is Displayed or not 
	 * @param driver
	 * @param patientName
	 * @return
	 */
	public boolean verifyAddedPatientIsDisplayed(WebDriver driver,String patientName) {
	
		boolean status = driver.findElement(By.xpath("//td[text()='"+patientName+"']")).isDisplayed();
	return status;
	}
}
