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
public class CancelAppointmentHistory_NC extends AdminBaseClass {

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
		UtilityClassObject.getTest().log(Status.INFO, "------click on login to application-----");
		Reporter.log("===patient login===");
		
		DashboardPage dboard=new DashboardPage(driver);
		//featching data from excel
		String docSpecilization = eLib.getDataFromExcel("Sheet2", 7, 3);
		String doctorName = eLib.getDataFromExcel("Sheet2", 7, 2);
		Reporter.log(doctorName);
		Reporter.log(docSpecilization);
		//by using bussinesslogic bookingAppointment
		dboard.BookAppointment(docSpecilization,doctorName );
		UtilityClassObject.getTest().log(Status.INFO, "------book appointment-----");
		Reporter.log("data enterds");
		
		//switch DashboardPage
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "------click on ok button-----");
		Reporter.log("appointment====");
		
		//logout as patient
		hp.getAdminAccount().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click onadminaccount  button-----");

		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on logout  link-----");
		
		String USERNAME1 = System.getProperty("Doctorusername" , fLib.getDataFromPropertiesFile("Doctorusername"));
		String PASSWORD1 = System.getProperty("Doctorpassword" , fLib.getDataFromPropertiesFile("Doctorpassword"));
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on login click here-----");
		lp.loginToDoctor(driver, USERNAME1, PASSWORD1);
		UtilityClassObject.getTest().log(Status.INFO, "------click on  login module-----");
		
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.getAppointmentHistoryBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  Appointmenmt history button-----");

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
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "------click on OK button-----");

		
		
		boolean status1 = driver.findElement(By.xpath("//p[contains(text(),'Appointment canceled !!')]")).isDisplayed();
		
		
		hp.getAdminAccount().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on Admin account-----");

		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  logout link-----");

		
		configBM();
		
		LeftPanelMainNavigation lpmn=new LeftPanelMainNavigation(driver);
		lpmn.getAppointmntHstry().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  Appointment History-----");

		
		
		WebElement status2 = driver.findElement(By.xpath("//td[text()='" + patientName + "']/..//td[contains(text(),'" + currentTime + "')]/..//div[contains(text(),'Canceled')]"));
		action.scrollToElement(status2);
		
		boolean display2 = status2.isDisplayed();

		System.out.println(display2);

		Assert.assertTrue(display2);
		Reporter.log("completed");
		
	}
}
