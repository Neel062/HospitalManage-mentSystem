package com.comcast.crm.objectrepositoryutility;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CancelAppointmentHistory extends AdminBaseClass {

	@Test
	public void CancelAppntmntHstry() throws InterruptedException {
		
		configAM();
		
		Home hp = new Home(driver);
		hp.getPatienLoginClickHereButton().click();
		Thread.sleep(4000);
		
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToTabOnTitle(driver, "user-login.php");
		
		
	}
}
