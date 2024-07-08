package com.comcast.hms.doctorModule;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Search_ManagePatientPage;

/**
 * @author Anbumathi
 * Doctor adding patient and verifying whether patient is added
 * After verification search the patient by name
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class DoctorAddPatientAndSearchWithName extends DoctorBaseClass{

	@Test
	public void addingPatientAndSearch() throws Throwable {
		/* Adding patient */
		AddPatientPage addPat=new AddPatientPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "===Clicking on addPatients dropdown and manage patient===");
		Reporter.log("Clicking on addPatients dropdown and manage patient",true);
		addPat.getPatientsDropdown().click();
		addPat.getAddPatMod().click();
		
		/* verifying whether booking appointment page is displayed or not*/
		UtilityClassObject.getTest().log(Status.INFO, "===Verify Booking Appointment page===");
	    String actualTitle="Doctor | Add Patient";
		String expectedTitle=driver.getTitle();
	    Assert.assertEquals(actualTitle, expectedTitle);
		
		String patName = eLib.getDataFromExcelDoctor("Doctor_Module",3, 0);
		String patContactNO = eLib.getDataFromExcelDoctor("Doctor_Module",3, 1);
		String patEmail=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 2)+jLib.getRandomNumber();
		String patEmail1=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 3);
		String email=patEmail+patEmail1;
		String patAddress=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 5);
		String patAge=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 6);
	    String medicalHis=eLib.getDataFromExcelDoctor("Doctor_Module", 3, 7);
	    UtilityClassObject.getTest().log(Status.INFO, "===Invoke the method and passing all details===");
		Reporter.log("Invoke the method and passing all details",true);
	    addPat.addMalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    
	    /* Navigate to search feature and verifying added patient able to search by their name */
	    Search_ManagePatientPage searchPat=new Search_ManagePatientPage(driver);
	    DoctorDashboardPage doctpage=new DoctorDashboardPage(driver);
	    doctpage.getSearchFeatureBtn().click();
	    searchPat.searchByName(patName);
	    searchPat.getSearchBtn().click();
	    
	    /* verifying Manage Patients is displaying */
		UtilityClassObject.getTest().log(Status.INFO, "===Verify Booking Appointment page===");
		String actualSearchTitle="Doctor | Manage Patients";
		String expectedSearchTitle=driver.getTitle();
		Assert.assertEquals(actualSearchTitle, expectedSearchTitle);
	    
	    /* Verifying the patient in search module */
	    searchPat.verifyAfterSearch(driver, patName);
	    UtilityClassObject.getTest().log(Status.PASS, "===Doctor able to fetch the patient details===");
		Reporter.log("Doctor able to fetch the patient details",true);
	}
}
