package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BtwnDatesReports {

	public BtwnDatesReports(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='fromdate']")
	private WebElement fromdate;
	
	@FindBy(xpath = "//input[@name=\"todate\"]")
	private WebElement todate;
	
	@FindBy(xpath = "//button[@name=\"submit\"]")
	private WebElement submitBtn;

	public WebElement getFromdate() {
		return fromdate;
	}

	public WebElement getTodate() {
		return todate;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
}
