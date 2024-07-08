package com.comcast.hms.doctorModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddMedicalHistoryPage;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.ManagePatientsPage;
/**
 * @author Anbumathi
 * Adding patients in doctor module
 * Doctor adding medical history
 * Verifying the medical history is added or not in manage patients
 */


@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class DoctorAddingMedicalHistoryTest extends DoctorBaseClass{
	@Test
	public void addMedicalHistory() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "===Clicking on addPatients dropdown===");
		Reporter.log("Clicking on addPatients dropdown",true);
		
		/* Fetching details from excel for Adding patient and invoke the method for entering all details */
		AddPatientPage addPat=new AddPatientPage(driver);
		addPat.getPatientsDropdown().click();
		addPat.getAddPatMod().click();
		UtilityClassObject.getTest().log(Status.INFO, "===Verifying the title===");
		Reporter.log("Verifying the title",true);
		String actualTitle="Doctor | Add Patient";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "===Title is Verified===");
		Reporter.log("Verifying the title",true);
		String patName = eLib.getDataFromExcelDoctor("Doctor_Module",2, 0);
		String patContactNO = eLib.getDataFromExcelDoctor("Doctor_Module",2, 1);
		String patEmail=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 2)+jLib.getRandomNumber();
		String patEmail1=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 3);
		String email=patEmail+patEmail1;
		String patAddress=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 5);
		String patAge=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 6);
	    String medicalHis=eLib.getDataFromExcelDoctor("Doctor_Module", 2, 7);
	    UtilityClassObject.getTest().log(Status.INFO, "===Creating patient===");
		Reporter.log("Creating patient",true);
	    addPat.addFemalePatients(patName, patContactNO, email, patAddress, patAge, medicalHis);
	    
	    /* Verifying Added patient */
	    addPat.getPatientsDropdown().click();
		addPat.getManagePat().click();
		UtilityClassObject.getTest().log(Status.PASS, "===Verifying ManagePatient page===");
	    Reporter.log("Verifying ManagePatient page",true);
		String actualManPatTitle="Doctor | Manage Patients";
		String expectedManPatTitle=driver.getTitle();
		Assert.assertEquals(actualManPatTitle, expectedManPatTitle);
		boolean status = addPat.verifyingAddedPatient(driver, patName);
		Assert.assertTrue(status);
		
		/* Fetching and Entering medical history details to the particular patient */
		 ManagePatientsPage addMed=new ManagePatientsPage(driver);
		 addMed.getAddMedicalHisBtn().click();
		  String bp=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 0);
		  String bloodSugar=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 1);
		  String weight=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 2);
		  String bodyTem=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 3);
		  String pres=eLib.getDataFromExcelDoctor("AddingMedicalHistory", 1, 4);
		  WebElement title = driver.findElement(By.xpath("//h5[@id='exampleModalLabel']"));
		  Actions a=new Actions(driver);
		  a.moveToElement(title).perform();
		  wLib.waitForElementPresent(driver,  title);
		  AddMedicalHistoryPage addMedHis=new AddMedicalHistoryPage(driver);
		addMedHis.addingMedicalHis(bp, bloodSugar, weight, bodyTem, pres);
		WebElement submit = driver.findElement(By.xpath("//button[@name='submit']"));
		a.moveToElement(submit).click().build().perform();
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.INFO, "===Verifying managepatient page===");
	    Reporter.log("Verifying managepatient page",true);
		String actualDatTitle="Doctor | Manage Patients";
		String expectedDetTitle=driver.getTitle();
		Assert.assertEquals(expectedDetTitle, actualDatTitle);
		
	}
}
