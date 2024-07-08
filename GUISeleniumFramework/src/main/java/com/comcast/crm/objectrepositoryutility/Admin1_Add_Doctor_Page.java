package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 *  @author Nithish
*This page contains Add Doctor elements
*/
public class Admin1_Add_Doctor_Page extends WebDriverUtility {
	
	public Admin1_Add_Doctor_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "Doctorspecialization")
	private WebElement Doctorspecializationdropdown;
	
	@FindBy(xpath =  "//span[text()=' Add Doctor']")
	private WebElement AddDoctor;
	
	public WebElement getAddDoctor() {
		return AddDoctor;
	}

	@FindBy(name = "docname")
	private WebElement DoctornameTxt;
	
	@FindBy(name = "clinicaddress")
	private WebElement DoctorclinicadressTxt;
	
	@FindBy(name = "docfees")
	private WebElement DoctorfeesTxt;
	
	public WebElement getDoctorfeesTxt() {
		return DoctorfeesTxt;
	}

	@FindBy(name = "doccontact")
	private WebElement DoctorcontactTxt;
	
	@FindBy(name = "docemail")
	private WebElement DoctoremailTxt;
	
	@FindBy(name = "npass")
	private WebElement DoctorpwdTxt;
	
	@FindBy(name = "cfpass")
	private WebElement DoctorcfpwdTxt;
	
	@FindBy(name = "submit")
	private WebElement DoctorSubmitBtn;

	public WebElement getDoctorspecializationdropdown() {
		return Doctorspecializationdropdown;
	}

	public WebElement getDoctornameTxt() {
		return DoctornameTxt;
	}

	public WebElement getDoctorclinicadressTxt() {
		return DoctorclinicadressTxt;
	}

	public WebElement getDoctorcontactTxt() {
		return DoctorcontactTxt;
	}

	public WebElement getDoctoremailTxt() {
		return DoctoremailTxt;
	}

	public WebElement getDoctorpwdTxt() {
		return DoctorpwdTxt;
	}

	public WebElement getDoctorcfpwdTxt() {
		return DoctorcfpwdTxt;
	}

	public WebElement getDoctorSubmitBtn() {
		return DoctorSubmitBtn;
	}
	
	public void SpecializationDropdown(String text ) {
		select(Doctorspecializationdropdown, text);
		
	}
	/**
	 * this method is used to add doctor
	 * @param specialization
	 * @param name
	 * @param address
	 * @param fees
	 * @param ph_no
	 * @param email
	 * @param password
	 * @param cpassword
	 */
	public void addDoctor(String specialization,String name,String address,String fees,String ph_no,String email,String password,String cpassword ) {
		
		Doctorspecializationdropdown.sendKeys(specialization);
		DoctornameTxt.sendKeys(name);
		DoctorclinicadressTxt.sendKeys(address);
		DoctorfeesTxt.sendKeys(fees);
		DoctorcontactTxt.sendKeys(ph_no);
		DoctoremailTxt.sendKeys(email);
		DoctorpwdTxt.sendKeys(password);
		DoctorcfpwdTxt.sendKeys(cpassword);
		DoctorSubmitBtn.click();
		
	}
}
