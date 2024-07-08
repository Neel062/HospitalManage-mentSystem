package com.aekudaan.hms.hmsTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LeftPanelMainNavigation;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class cancellingCancelBtnApntmntHstry_NC extends AdminBaseClass{

	@Test
	public void CancelAppointmentTest() throws Throwable
	{
		
		configAM();
		String USERNAME = System.getProperty("Patientusername" , fLib.getDataFromPropertiesFile("Patientusername"));
		String PASSWORD = System.getProperty("Patientpassword" , fLib.getDataFromPropertiesFile("Patientpassword"));
		hp = new Home(driver);
		hp.getPatienLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on patient login click here button-----");
		LoginPage lp = new LoginPage(driver);
		lp.loginToPatient(driver, USERNAME, PASSWORD);
		UtilityClassObject.getTest().log(Status.INFO, "------login to application-----");

		Reporter.log("===patient login===");
		
		DashboardPage dboard=new DashboardPage(driver);
		
		String docSpecilization = eLib.getDataFromExcel("Sheet2", 7, 3);
		String doctorName = eLib.getDataFromExcel("Sheet2", 7, 2);
		Reporter.log(doctorName);
		Reporter.log(docSpecilization);
		
		dboard.BookAppointment(docSpecilization,doctorName );
		System.out.println("data enterds");
		
		UtilityClassObject.getTest().log(Status.INFO, "------switch DashboardPage-----");
		wLib.switchtoAlertAndAccept(driver);
		Reporter.log("appointment====");

		hp.getAdminAccount().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on admit account button-----");
		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on logout link-----");

		
		String USERNAME1 = System.getProperty("Doctorusername" , fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD1 = System.getProperty("Doctorpassword" , fLib.getDataFromPropertiesFile("Doctorpassword"));
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on doctor login click here-----");
		lp.loginToDoctor(driver, USERNAME1, PASSWORD1);
		UtilityClassObject.getTest().log(Status.INFO, "------click on login to application-----");
		
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.getAppointmentHistoryBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on appointment history button-----");

		
		//dboard.getadminAppointHistory().click();
		Reporter.log("Appointment History is clicked");
		
		Actions action = new Actions(driver);

		String patientName = eLib.getDataFromExcel("Sheet2", 7, 1);
		
		DateFormat df = new SimpleDateFormat("hh");
		Calendar calobj = Calendar.getInstance();
		String currentTime1 = df.format(calobj.getTime());
	    Integer c = Integer.valueOf(currentTime1);
	    int n = c.intValue();
	    n=n+12;
	    String currentTime = String.valueOf(n);
		
		Reporter.log(currentTime);
		WebElement status = driver.findElement(
				By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]/..//a[text()='Cancel']"));
		action.scrollToElement(status);
		status.click();
		wLib.switchtoAlertAndCancel(driver);
		UtilityClassObject.getTest().log(Status.INFO, "------click on cancel button-----");
		hp.getAdminAccount().click();
		UtilityClassObject.getTest().log(Status.INFO, "------login as admin account-----");

		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on logout link-----");
		configBM();
		
		LeftPanelMainNavigation lpmn=new LeftPanelMainNavigation(driver);
		lpmn.getAppointmntHstry().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on appointment history-----");
		Thread.sleep(5000);
		WebElement status2 = driver.findElement(
				By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]/..//div[contains(text(),'No Action yet')]"));
		action.scrollToElement(status2);
		boolean display2 = status2.isDisplayed();

		System.out.println(display2);

		Assert.assertTrue(display2);
		Reporter.log("completed");
		
	}
}
