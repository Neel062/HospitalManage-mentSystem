package com.comcast.hms.doctorModule;

import org.testng.AssertJUnit;
import org.testng.Reporter;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.Admin1_Add_Doctor_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Dashboard_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Doctors_Page;
/**
 * @author Anbumathi
 * Adding Doctor and Verify doctor in manage doctor feature(Admin Module)
 * 
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddDoctorAndVerifyInManageDoctorPageTest extends AdminBaseClass{
	@Test
	public void CreateDoctorAndVerify() throws Throwable{
		
		UtilityClassObject.getTest().log(Status.INFO, "===Navigating to doctor in Admin Module===");
		Reporter.log("Navigating to doctor in Admin Module",true);
		Admin1_Dashboard_Page doctor=new Admin1_Dashboard_Page(driver);
		Admin1_Add_Doctor_Page addDoctor=new Admin1_Add_Doctor_Page(driver);
		doctor.getDoctordropdown().click();
		addDoctor.getAddDoctor().click();
		UtilityClassObject.getTest().log(Status.INFO, "===Verifying title of add doctor page===");
	Reporter.log("Verifying title of add doctor page",true);
		String actualTitle="Admin | Add Doctor";
		String expectedTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
		/* Fetching the data from excel */
		String doctorSpecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3)+jLib.getRandomNumber();
		String doctorAddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorFees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorNo = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorPwd = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorConfirmPwd = eLib.getDataFromExceladmin1("Admin1", 1, 10);
		
		/* Invoke the method for entering details for adding doctor */
		addDoctor.addDoctor(doctorSpecialization, doctorName, doctorAddress, doctorFees, doctorNo, email, doctorPwd, doctorConfirmPwd);
		UtilityClassObject.getTest().log(Status.PASS, "===Doctor details is added successfully===");
		Reporter.log("Doctor details is added successfully",true);
		
		/* After adding doctor alert will display and handling the alert */
		UtilityClassObject.getTest().log(Status.INFO, "===Handling Alert===");
		Reporter.log("Handling Alert",true);
		wLib.switchtoAlertAndAccept(driver);
		Reporter.log("Handled Alert",true);
		String actualManDocTitle="Admin | Manage Doctors";
		String expectedManDocTitle=driver.getTitle();
		Assert.assertEquals(actualManDocTitle, expectedManDocTitle);
		
		/* After adding doctor verify in manage doctor */
		UtilityClassObject.getTest().log(Status.INFO, "===Added Doctor verify in Manage doctor page===");
		Reporter.log("Added Doctor verify in Manage doctor page",true);
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		boolean status = amdp.verifyAddedDoctor(driver, doctorName);
		Assert.assertTrue(status);
		UtilityClassObject.getTest().log(Status.PASS, "===Added Doctor is verifiedin manage doctor===");
		Reporter.log("Added Doctor is verified",true);
	}
}
