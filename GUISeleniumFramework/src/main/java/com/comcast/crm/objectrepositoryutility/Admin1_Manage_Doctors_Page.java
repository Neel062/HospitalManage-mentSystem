package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Nithish
 *This page contains Admin_Manage_Doctors elements
 */

public class Admin1_Manage_Doctors_Page {
	

	public Admin1_Manage_Doctors_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * this method is used to click on doctor edit icon
	 * @param driver
	 * @param DoctorName
	 */
	public void editDcotor(WebDriver driver,String DoctorName) {
	  
		driver.findElement(By.xpath("//td[text()='"+DoctorName+"']/..//i[@class='fa fa-pencil']")).click();
	}
	
	/**
	 * this method is used to click on doctor delete icon
	 * @param driver
	 * @param DoctorName
	*/
	public void deleteDcotor(WebDriver driver,String DoctorName) {
	
		driver.findElement(By.xpath("//td[text()='"+DoctorName+"']/..//i[@class='fa fa-times fa fa-white']")).click();
	}
	

	public boolean verifyAddedDoctor(WebDriver driver,String doctor) {
		boolean status = driver.findElement(By.xpath("//td[text()='"+doctor+"']")).isDisplayed();
		return status;
	}

	@FindBy(xpath = "//p[contains(text(),'data deleted !!')]	")
	private WebElement DoctordeletedconfirmMsg;

	public WebElement getDoctordeletedconfirmMsg() {
		return DoctordeletedconfirmMsg;
	}
	


}
