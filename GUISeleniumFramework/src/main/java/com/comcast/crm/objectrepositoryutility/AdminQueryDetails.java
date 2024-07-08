package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminQueryDetails {

	public AdminQueryDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//textarea[@name='adminremark']")
	private WebElement AdminRemarkTxtFld;
	
	@FindBy(xpath = "//button[@name='update']")
	private WebElement UpdateBtn;

	public WebElement getAdminRemarkTxtFld() {
		return AdminRemarkTxtFld;
	}

	public WebElement getUpdateBtn() {
		return UpdateBtn;
	}
}
