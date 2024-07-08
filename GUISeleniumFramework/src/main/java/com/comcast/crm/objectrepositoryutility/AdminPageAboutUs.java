package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPageAboutUs {

	public AdminPageAboutUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class=' nicEdit-main ']")
	private WebElement PageDescription_Txt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;

	public WebElement getPageDescription_Txt() {
		return PageDescription_Txt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
}
