package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddMedicalHistoryPage {
	
	public AddMedicalHistoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "bp")
	private WebElement bpTxt;
	
	@FindBy(name="bs")
	private WebElement bloodSugarTxt;
	
	@FindBy(name="weight")
	private WebElement weightTxt;
	
	@FindBy(name="temp")
	private WebElement bodyTempTxt;
	
	@FindBy(name="pres")
	private WebElement prescriptionTxt;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getBpTxt() {
		return bpTxt;
	}

	public WebElement getBloodSugarTxt() {
		return bloodSugarTxt;
	}

	public WebElement getWeightTxt() {
		return weightTxt;
	}

	public WebElement getBodyTempTxt() {
		return bodyTempTxt;
	}

	public WebElement getPrescriptionTxt() {
		return prescriptionTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void addingMedicalHis(String bloodPressure,String bloodSugar, String Weight, String bodyTemp, String prescription) {
		bpTxt.click();
		bpTxt.sendKeys(bloodPressure);
		bloodSugarTxt.click();
		bloodSugarTxt.sendKeys(bloodSugar);
		weightTxt.click();
		weightTxt.sendKeys(Weight);
		bodyTempTxt.click();
		bodyTempTxt.sendKeys(bodyTemp);
		prescriptionTxt.click();
		prescriptionTxt.sendKeys(prescription);
		
	}
	public void verifyPatientForMedicalHistory(WebDriver driver,String patName) {
		driver.findElement(By.xpath("//td[text()='"+patName+"']/..//i[@class='fa fa-eye']")).click();
		boolean status = driver.findElement(By.xpath("(//td[text()='"+patName+"'])[1]")).isDisplayed();
	}
	
}
