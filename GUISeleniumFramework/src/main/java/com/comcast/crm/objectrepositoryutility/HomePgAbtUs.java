package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePgAbtUs {

	public HomePgAbtUs(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//p[text()='Hello this is Providence hospital2660.']")
	private WebElement HomePgAbtUs;
	public WebElement getHomePgAbtUs() {
		return HomePgAbtUs;
	}
	
}
