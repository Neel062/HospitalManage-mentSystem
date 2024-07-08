package com.comcast.hms.doctorModule;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.PatientBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.BookAppointment;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LeftPanelMainNavigation;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * @author Anbumathi
 * Book an Appointment in patient module
 * cancel the appointment in doctor module
 * verifying whether appointment is cancelled or not
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class BookAndCancelAppointmentAndViewInAppointmentHistory extends PatientBaseClass{
	
	@Test
	public void BookingAndCancelAppointment() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "===Booking Appointment===");
		/* Clicking an book appointment link */
		BookAppointment bookApp=new BookAppointment(driver);
		bookApp.getBookAppointmentlink().click();
		
		/* verifying whether booking appointment page is displayed or not*/
		UtilityClassObject.getTest().log(Status.INFO, "===Verify Booking Appointment page===");
		String actualTitle="User | Book Appointment";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		/* Fetching details from excel for booking appointment*/
		UtilityClassObject.getTest().log(Status.PASS, "===Booking Appointment page is verified===");
		Reporter.log("Appointment is displayed",true);
		String doctorSpecialization=eLib.getDataFromExcelDoctor("BookPatAppointment", 1, 0);
		String doctorName=eLib.getDataFromExcelDoctor("BookPatAppointment", 1, 1);
		UtilityClassObject.getTest().log(Status.INFO, "===Booking Appointment===");
		
		/* Passing the details in this method to book appointment */
		bookApp.BookAppointment(doctorSpecialization, doctorName);
		Reporter.log("Appointment is Booked",true);
		UtilityClassObject.getTest().log(Status.PASS, "===Appointment added successfully===");
		
		UtilityClassObject.getTest().log(Status.INFO, "===Handling Alert===");
		/* Handling alert by using alert statement */
		wLib.switchtoAlertAndAccept(driver);
		
		/* after Handled alert verifying whether Appointment page is displaying */
		String actualBookAppTitle="User | Book Appointment";
		String expectedBookAppTitle=driver.getTitle();
		Assert.assertEquals(actualBookAppTitle, expectedBookAppTitle);
		UtilityClassObject.getTest().log(Status.PASS, "===Alert Handled===");
		
		/* Logout as Patient */
		configAM();
		UtilityClassObject.getTest().log(Status.INFO, "===Logout as patient===");
		String actualPatTitle="Hospital management System";
		String expectedPatTitle=driver.getTitle();
		Assert.assertEquals(actualPatTitle, expectedPatTitle);
		
		/* Login as Doctor */
		String USERNAME = System.getProperty("Doctorusername" , fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD = System.getProperty("Doctorpassword" , fLib.getDataFromPropertiesFile("Doctorpassword"));
		UtilityClassObject.getTest().log(Status.INFO, "===Login as Doctor===");
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, USERNAME, PASSWORD);
		
		/* Verifying doctor is able to login */
		UtilityClassObject.getTest().log(Status.INFO, "===Verify Login as Doctor===");
		String actualDoctorLogTitle="Doctor | Dashboard";
		String expectedDoctorLogTitle=driver.getTitle();
		Assert.assertEquals(actualDoctorLogTitle, expectedDoctorLogTitle);
		
		/* Navigating to appointment history and fetching details from excel*/
		DoctorDashboardPage doc=new DoctorDashboardPage(driver);
		doc.getAppointmentHistoryBtn().click();
		String actualAppHisTitle="Doctor | Appointment History";
		String expectedAppHisTitle=driver.getTitle();
		Assert.assertEquals(actualAppHisTitle, expectedAppHisTitle);
		Reporter.log("Appointment History page is displayed",true);
		String patName1=eLib.getDataFromExcelDoctor("BookPatAppointment", 3, 0);
		boolean status = bookApp.verifyBookAppointment(patName1);
		Assert.assertTrue(status);
		UtilityClassObject.getTest().log(Status.PASS, "===Verified Booked appointed===");
		doc.getAppointmentHistoryBtn().click();
		
		/* Canceling and verifying the book appointment */
		bookApp.CapturingTimeDate(patName1);
		Reporter.log("Verifying Appointment is canceled or not");
		UtilityClassObject.getTest().log(Status.INFO, "===Cancel Booking===");
		wLib.switchtoAlertAndAccept(driver);
		boolean status1 = driver.findElement(By.xpath("//p[contains(text(),'Appointment canceled !!')]")).isDisplayed();
		Assert.assertTrue(status1);
		Reporter.log("Booking appointment is canceled");
		UtilityClassObject.getTest().log(Status.PASS, "===Booking Canceled===");
	}
}
