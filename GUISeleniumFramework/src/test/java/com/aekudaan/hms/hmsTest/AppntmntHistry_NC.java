package com.aekudaan.hms.hmsTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.BookAppointment;
import com.comcast.crm.objectrepositoryutility.DashboardPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LeftPanelMainNavigation;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AppntmntHistry_NC extends AdminBaseClass{

	@Test
	public void AppHistoryTest() throws Throwable
	{	
		/* Logout as admin */
		configAM();
		String expecttitle="Hospital management System";
		String actTitle=driver.getTitle();
		Assert.assertEquals(expecttitle, actTitle);
		/* Login as patient */
		String USERNAME = System.getProperty("Patientusername" , fLib.getDataFromPropertiesFile("Patientusername"));
		String PASSWORD = System.getProperty("Patientpassword" , fLib.getDataFromPropertiesFile("Patientpassword"));
		hp = new Home(driver);
		hp.getPatienLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on patient Login click here button--------------");
		LoginPage lp = new LoginPage(driver);
		lp.loginToPatient(driver, USERNAME, PASSWORD);
		
		String expectPattitle="User | Dashboard";
		String actPatTitle=driver.getTitle();
		Assert.assertEquals(expectPattitle, actPatTitle);
		
		/*Booking appointment in patient module*/
		UtilityClassObject.getTest().log(Status.INFO, "------Login to application--------------");
		Reporter.log("===patient login===");	
		DashboardPage dboard=new DashboardPage(driver);		
		String docSpecilization = eLib.getDataFromExcel("Sheet2", 7, 3);
		String doctorName = eLib.getDataFromExcel("Sheet2", 7, 2);
		Reporter.log(doctorName);
		Reporter.log(docSpecilization);
		dboard.BookAppointment(docSpecilization,doctorName );
		UtilityClassObject.getTest().log(Status.INFO, "------bookingAppointment-----");
		Reporter.log("data enterds");
		UtilityClassObject.getTest().log(Status.INFO, "------switch DashboardPage-----");
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "------click on ok button-----");
		
		/*Logout as Admin*/
		hp.getAdminAccount().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on admin account-----");
		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on logout link-----");
		String expectAdmtitle="Hospital management System";
		String actAdmTitle=driver.getTitle();
		System.out.println(actAdmTitle);
		Assert.assertEquals(expectAdmtitle, actAdmTitle);
		
		/*Login as Doctor*/
		String USERNAME1 = System.getProperty("Doctorusername" , fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD1 = System.getProperty("Doctorpassword" , fLib.getDataFromPropertiesFile("Doctorpassword"));
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "Click on doctor login");
		lp.loginToDoctor(driver, USERNAME1, PASSWORD1);
		String expectDoctitle="Doctor | Dashboard";
		String actDoctTitle=driver.getTitle();
	    Assert.assertEquals(expectDoctitle, actDoctTitle);
		
		
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.getAppointmentHistoryBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Click on appointment history button");		
		//Actions action = new Actions(driver);

	//	String patientName = eLib.getDataFromExcel("Sheet2", 7, 1);
		// boolean status = ddp.verifydocAppointmentisbooked(patientName);
		// System.out.println("inside method");
		
//		Calendar cal = Calendar.getInstance();
//		Date date = cal.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		int hrs= date.getHours();
//		int min=date.getMinutes();
//		String modDate=sdf.format(date)+" "+hrs+":"+min;
//		System.out.println(modDate);
//		
//		boolean status = driver.findElement(
//				By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + modDate + "')]")).isDisplayed();
//		//action.scrollToElement(status);
//		
//
//		//boolean display = status.isDisplayed();
//
//		System.out.println(status);
//
//		Assert.assertTrue(status);
//		Reporter.log("completed");
//		
//		hp.getAdminAccount().click();
//		UtilityClassObject.getTest().log(Status.INFO, "click on admin account button");
//		hp.getLogoutLink().click();
//		
//		configBM();
//		
//		LeftPanelMainNavigation lpmn=new LeftPanelMainNavigation(driver);
//		lpmn.getAppointmntHstry().click();
//		UtilityClassObject.getTest().log(Status.INFO, "click on appointment history");
//		
//		boolean status1 = driver.findElement(By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + modDate + "')]")).isDisplayed();
//	//	action.scrollToElement(status1);
//
//		//boolean display1 = status1.isDisplayed();
//
////		System.out.println(display1);
////
////		Assert.assertTrue(display1);
//		Reporter.log("completed");
//		
		
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
		WebElement status2 = driver.findElement(
				By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]/..//div[contains(text(),'No Action yet')]"));
		action.scrollToElement(status2);
		boolean display2 = status2.isDisplayed();

		System.out.println(display2);

		Assert.assertTrue(display2);
		Reporter.log("completed");
		
	}

}