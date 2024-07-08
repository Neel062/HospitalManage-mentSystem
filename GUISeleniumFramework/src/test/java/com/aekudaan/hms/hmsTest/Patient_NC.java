package com.aekudaan.hms.hmsTest;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.AdminPatientSearch;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LeftPanelMainNavigation;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class Patient_NC extends AdminBaseClass {

	@Test
	public void PatientSearch() throws Throwable {
		
		/* Logout as admin */
		configAM();
		
		/* Login as doctor */
		String USERNAME = eLib.getDataFromExcel("Sheet2", 4, 1);
		String PASSWORD =eLib.getDataFromExcel("Sheet2", 4, 2);
		UtilityClassObject.getTest().log(Status.INFO, "------get data from excel-----");
		hp = new Home(driver);
		hp.getDoctorLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  Doctor login click here button-----");
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, USERNAME, PASSWORD);
		Reporter.log("DOCTOR login");
		
		/* Fetching data from excel and Adding patient by entering all details */
		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
		ddp.getPatientsDropDown().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  get patient dropdown page-----");
		ddp.getAddPatientBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  Add patient button-----");
		AddPatientPage adp=new AddPatientPage(driver);
		String patientName = eLib.getDataFromExcel("Sheet2", 4, 3)+jLib.getRandomNumber();
		String contact_no = eLib.getDataFromExcel("Sheet2", 4, 4);
		String email = eLib.getDataFromExcel("Sheet2", 4, 5)+jLib.getRandomNumber();
		String address = eLib.getDataFromExcel("Sheet2", 4, 6);
		String age = eLib.getDataFromExcel("Sheet2", 4, 7);
		String medicalhistory = eLib.getDataFromExcel("Sheet2", 4, 8);
		adp.addMalePatients(patientName, contact_no, email,address, age, medicalhistory);
		Reporter.log("===patient is ceated===");

		hp.getAdminAccount().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "------click on  Admin Account-----");

		hp.getLogoutLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  logout option-----");

		/* login as patient */
		configBM();
		
		/* verifying patient in search feature */
		LeftPanelMainNavigation lpmn=new LeftPanelMainNavigation(driver);
		lpmn.getPatientSearch().click();
		Reporter.log("patientsearch ---clicked");
		AdminPatientSearch aps=new AdminPatientSearch(driver);
		aps.getSearchbyName_MobileNo_Txt().sendKeys(patientName);
		aps.getSearchBtn().click();		boolean status = aps.verifyaddedpatient(driver, patientName);
		System.out.println(status);
		Assert.assertTrue(status);
	}
}
