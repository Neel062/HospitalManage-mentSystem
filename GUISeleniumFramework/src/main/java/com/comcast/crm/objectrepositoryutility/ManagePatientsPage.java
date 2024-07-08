package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePatientsPage {
	
	public ManagePatientsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Add Medical History']")
	private WebElement addMedicalHisBtn;

	public WebElement getAddMedicalHisBtn() {
		return addMedicalHisBtn;
	}
	
	
}
