package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * sruthis
 * @author Dell Inspiron15
 *
 */
public class PatientRegisterPage extends WebDriverUtility{                             
        
		WebDriver driver;
		 public PatientRegisterPage(WebDriver driver) {             
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
		 }

		 @FindBy(partialLinkText="Create an account")
		 private WebElement PatientCreateAnAccountlink;

		 public WebElement getPatientCreateAnAccountlink()
		 {
		 	return PatientCreateAnAccountlink;
		 }
		 
		 @FindBy(name="full_name")
		 private WebElement PatientFullNametxtfield;

		 public WebElement getPatientFullNametxtfield()
		 {
		 	return PatientFullNametxtfield;
		 }

		 @FindBy(name="address")
		 private WebElement PatientAddresstxtfield;

		 public WebElement getPatientAddresstxtfield()
		 {
		 	return PatientAddresstxtfield;
		 }

		 @FindBy(name="city")
		 private WebElement Patientcitytxtfield;

		 public WebElement getPatientcitytxtfield()
		 {
		 	return Patientcitytxtfield;
		 }

		 @FindBy(xpath="//label[contains(@for,\"rg-male\")]")
		 private WebElement PatientMaleRadioButton;

		 public WebElement getPatientmaleRadioButton()
		 {
		 	return PatientMaleRadioButton;
		 }
		 
		 @FindBy(xpath="//label[contains(@for,\"rg-female\")]")
		 private WebElement PatientFemaleRadioButton;

		 public WebElement PatientFemaleRadioButton()
		 {
		 	return PatientMaleRadioButton;
		 }
		 
		 @FindBy(id="email")
		 private WebElement PatientEmailtxtfield;

		 public WebElement getPatientEmailtxtfield()
		 {
		 	return PatientEmailtxtfield;
		 }
		
		 @FindBy(id="password")
		 private WebElement PatientPasswordtxtfield;

		 public WebElement getPatientPasswordtxtfield()
		 {
		 	return PatientPasswordtxtfield;
		 }
		 @FindBy(id="password_again")
		 private WebElement PatientPasswordAgaintxtfield;

		 public WebElement getPatientPasswordAgaintxtfield()
		 {
		 	return PatientPasswordAgaintxtfield;
		 }
		 
		 @FindBy(xpath = "//button[@type='submit']")
		 private WebElement PatientSubmitButton;

		 public WebElement getPatientSubmitButton()
		 {
		 	return PatientSubmitButton;
		 }
		 
		 @FindBy(xpath="//span[contains(text(),\" Book Appointment \")]")
		 private WebElement BookAppointment;

		 public WebElement getBookAppointment()
		 {
		 	return BookAppointment ;
		 }
		 
		 @FindBy(xpath="//span[contains(text(),\" Appointment History \")]")
		 private WebElement AppointmentHistory;

		 public WebElement getAppointmentHistory()
		 {
		 	return AppointmentHistory ;
		 }
		 
		 @FindBy(xpath="//span[contains(text(),\" Medical History \")]")
		 private WebElement MedicalHistory;

		 public WebElement getMedicalHistory()
		 {
		 	return MedicalHistory ;
		 }
		 
		 /**
		  * registering the patient
		  * @param fullname
		  * @param adress
		  * @param city
		  * @param gender
		  * @param email
		  * @param password
		  * @param passwordagain
		  */
		 public void registerAsFemalePatient(String fullname,String address,String city,String email,String Password,String PasswordAgain)
		 {
			 PatientCreateAnAccountlink.click();
			 PatientFullNametxtfield.sendKeys(fullname);
			 PatientAddresstxtfield.sendKeys(address);
			 Patientcitytxtfield.sendKeys(city);
			 PatientFemaleRadioButton.click();
			 PatientEmailtxtfield.sendKeys(email);
			 PatientPasswordtxtfield.sendKeys(Password);
			 PatientPasswordAgaintxtfield.sendKeys(PasswordAgain);
			 PatientSubmitButton.click();
		 }
		 public void registerAsMalePatient(String fullname,String address,String city,String email,String Password,String PasswordAgain)
		 {
			 PatientCreateAnAccountlink.click();
			 PatientFullNametxtfield.sendKeys(fullname);
			 PatientAddresstxtfield.sendKeys(address);
			 Patientcitytxtfield.sendKeys(city);
			 PatientMaleRadioButton.click();
			 PatientEmailtxtfield.sendKeys(email);
			 PatientPasswordtxtfield.sendKeys(Password);
			 PatientPasswordAgaintxtfield.sendKeys(PasswordAgain);
			 PatientSubmitButton.click();
		 }
		 }
		
			 
