package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin1_Edit_Doctor_page {

	public Admin1_Edit_Doctor_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "docfees")
	private WebElement DoctorfeesTxt;
	
	public WebElement getDoctorfeesTxt() {
		return DoctorfeesTxt;
	}

	@FindBy(name = "doccontact")
	private WebElement DoctorcontactTxt;

	public WebElement getDoctorcontactTxt() {
		return DoctorcontactTxt;
	}
	@FindBy(name = "submit")
	private WebElement DoctorUpdateBtn;
	
	
	public WebElement getDoctorUpdateBtn() {
		return DoctorUpdateBtn;
	}

	/**
	 * this method is used to edit doctor details(fees and phone number)
	 * 
	 * @param fees
	 * @param ph_no
	 */

	public void editDoctor(String fees,String ph_no ) {
		DoctorfeesTxt.clear();
		DoctorfeesTxt.sendKeys(fees);
		DoctorcontactTxt.clear();
		DoctorcontactTxt.sendKeys(ph_no);
		DoctorUpdateBtn.click();
	}
	}
