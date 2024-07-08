package com.comcast.hms.doctorModule;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
/**
 * @author Anbumathi
 * Adding patient with entering all details
 * verifying in manage patients
 * 
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddPatientWithEnteringAllDetailsAndVerifyInManagePatients extends DoctorBaseClass{
	
	@Test
	public void addPatientWithName_Contact() throws Throwable{
		UtilityClassObject.getTest().log(Status.INFO, "===Adding patient with entering all details===");
		Reporter.log("Adding patient with entering all details",true);
		
		/* Adding Patient by entering all details and fetching the details from excel*/
		AddPatientPage addPat=new AddPatientPage(driver);
		addPat.getPatientsDropdown().click();
		addPat.getAddPatMod().click();
		UtilityClassObject.getTest().log(Status.INFO, "===Verifying the title===");
		Reporter.log("Verifying the title",true);
		String actualTitle="Doctor | Add Patient";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "===Title is verified===");
		Reporter.log("Title is verified",true);
		String patName = eLib.getDataFromExcelDoctor("Doctor_Module",2, 0);
		String patContactNO = eLib.getDataFromExcelDoctor("Doctor_Module",2, 1);
		String patEmail=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 2)+jLib.getRandomNumber();
		String patEmail1=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 3);
		String email=patEmail+patEmail1;
		String patAddress=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 5);
		String patAge=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 6);
	    String medicalHis=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 7);
	    UtilityClassObject.getTest().log(Status.INFO, "===Calling methods to enter all details===");
	    addPat.addMalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    
	    /* Navigating to manage patient */
		 addPat.getPatientsDropdown().click();
		 addPat.getManagePat().click();
		 UtilityClassObject.getTest().log(Status.INFO, "===Verifying the title===");
		 Reporter.log("Verifying the title",true);
		 String actualPatTitle="Doctor | Manage Patients";
		 String expectedPatTitle=driver.getTitle();
		 Assert.assertEquals(actualPatTitle, expectedPatTitle);
		
		 UtilityClassObject.getTest().log(Status.PASS, "===Title is Verified===");
		 Reporter.log("Title is Verified",true);
		
		/* Verifying added patient is displayed in manage patients page */
		String managePatName=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 0);
		boolean status = addPat.verifyingAddedPatient(driver, managePatName);
		Assert.assertTrue(status);
		UtilityClassObject.getTest().log(Status.PASS, "===Verification is done===");
		Reporter.log("Verification is done",true);
			
		
	}
}
