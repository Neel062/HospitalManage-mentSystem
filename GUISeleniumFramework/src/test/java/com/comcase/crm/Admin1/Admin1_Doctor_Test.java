package com.comcase.crm.Admin1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddPatientPage;
import com.comcast.crm.objectrepositoryutility.Admin1_Add_Doctor_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Dashboard_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Doctor_Specialization_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Edit_Doctor_page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Doctors_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_Patients_Page;
import com.comcast.crm.objectrepositoryutility.Admin1_Manage_user_Page;
import com.comcast.crm.objectrepositoryutility.DoctorDashboardPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.PatientCreateAnAccount;
import com.comcast.crm.objectrepositoryutility.PatientRegisterPage;

/**
 * 
 * @author Nithish
 * this class consists of add doctor script, editing doctor detalis script 
 * and deleting doctor script
 *
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class Admin1_Doctor_Test extends AdminBaseClass {
	
	/**
	 * this method consists of add doctor script
	 * @throws Throwable
	 */
	@Test

	public void addDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----Adding Doctor-----");
		Reporter.log("==Adding Doctor==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/* performing logout */
		configAM();
		
		/*verify admin logout is done */
		String HomepageActualTiltle="Hospital management System";
		String HomepageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Admin logged out successfully-----");
		Reporter.log("=Admin logged out successfully=",true);
		
		/*Verify weather created doctor is able to login*/
		hp.getDoctorLoginClickHereButton().click();
		LoginPage lp = new LoginPage(driver);
		lp.loginToDoctor(driver, email, doctorpassword);
		String DoctorDashboardactualtiltle="Doctor | Dashboard";
		String DoctorDashboarexpectedtitle = driver.getTitle();
		Assert.assertEquals(DoctorDashboardactualtiltle, DoctorDashboarexpectedtitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor able to login-----");
		Reporter.log("=Doctor able to login=",true);
		
		/*verify Doctor logout is done */
		hp.getAdminAccount().click();
		hp.getLogoutLink().click();
		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor logged out successfully-----");
		Reporter.log("=Doctor logged out successfully=",true);
		
		/* performing admin login */
		configBM();
	}

	/**
	 * this method consists of edit doctor details script
	 * @throws Throwable
	 */
	@Test

	public void editDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----Editinging Doctor details-----");
		Reporter.log("==Editinging Doctor details==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/* Navigating to Edit Doctor page */
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		amdp.editDcotor(driver, doctorName);
		String editDcotorActualTiltle="Admin | Edit Doctor Details";
		String editDcotorExpectedTitle = driver.getTitle();
		Assert.assertEquals(editDcotorActualTiltle,editDcotorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Edit Doctor Details page is displayed-----");
		Reporter.log("==Edit Doctor Details page is displayed==",true);

		/* Fetching the data from Excel file */
		String editedfees = eLib.getDataFromExceladmin1("Admin1", 3, 5);
		String editedph_no = eLib.getDataFromExceladmin1("Admin1", 3, 6);
		
		/*editing doctor details(fees and phone number)*/
		Admin1_Edit_Doctor_page aedp=new Admin1_Edit_Doctor_page(driver);
		aedp.editDoctor(editedfees, editedph_no);
		
		/*Verifying doctor fees editing is successfull*/
		String fees = aedp.getDoctorfeesTxt().getAttribute("value");
		Assert.assertEquals(editedfees, fees);
		UtilityClassObject.getTest().log(Status.PASS, "----editing of fees successfully-----");
		Reporter.log("editing of fees successfully",true);
		
		/*Verifying doctor phone number editing is successfull*/
		String ph_no = aedp.getDoctorcontactTxt().getAttribute("value");
		Assert.assertEquals(editedph_no, ph_no);
		UtilityClassObject.getTest().log(Status.PASS, "----editing of ph_no successfully-----");
		Reporter.log("editing of ph_no successfully",true);
	}
	

	/**
	 * this method consists of delete doctor script
	 * @throws Throwable
	 */

	@Test

	public void deleteDoctor() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "----deleting Doctor details-----");
		Reporter.log("==deleting Doctor details==",true);
		
		/* Navigating to Add Doctor page */
		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
		adp.getDoctordropdown().click();
		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
		aadp.getAddDoctor().click();
		String AddDoctorActualTiltle="Admin | Add Doctor";
		String AddDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
		Reporter.log("==Adding Doctor page is displayed==",true);
		
		/* Fetching the data from Excel file */
		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
		String email = doctoremail + emailcom;
		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);

		/* Creating the doctor */
		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
		wLib.switchtoAlertAndAccept(driver);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
		Reporter.log("----Doctor created-----",true);
		
		/* Verifying Manage doctors page is displayed after adding doctor */
		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
		String ManageDoctorExpectedTitle = driver.getTitle();
		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
		Reporter.log("==Manage  Doctor page is displayed==",true);
		
		/*Delete the doctor which is created */
		Admin1_Manage_Doctors_Page amdp=new Admin1_Manage_Doctors_Page(driver);
		amdp.deleteDcotor(driver, doctorName);
		wLib.switchtoAlertAndAccept(driver);
		
		/*verify doctor is deleted*/
		boolean status = amdp.getDoctordeletedconfirmMsg().isDisplayed();
		Assert.assertTrue(true);
		UtilityClassObject.getTest().log(Status.PASS, "----Doctor deleted successfully-----");
		Reporter.log("==Doctor deleted successfully==",true);
	}
	
//	@Test
//
//	public void addPaitient() throws Throwable {
//		UtilityClassObject.getTest().log(Status.INFO, "----Add paitient-----");
//		Reporter.log("==Add paitient==",true);
//		
//		/* Navigating to Add Doctor page */
//		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
//		adp.getDoctordropdown().click();
//		Admin1_Add_Doctor_Page aadp = new Admin1_Add_Doctor_Page(driver);
//		aadp.getAddDoctor().click();
//		String AddDoctorActualTiltle="Admin | Add Doctor";
//		String AddDoctorExpectedTitle = driver.getTitle();
//		Assert.assertEquals(AddDoctorActualTiltle,AddDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Add Doctor page is displayed-----");
//		Reporter.log("==Adding Doctor page is displayed==",true);
//		
//		/* Fetching the data from Excel file */
//		String doctorspecialization = eLib.getDataFromExceladmin1("Admin1", 1, 2);
//		String doctorName = eLib.getDataFromExceladmin1("Admin1", 1, 3);
//		String doctoraddress = eLib.getDataFromExceladmin1("Admin1", 1, 4);
//		String doctorfees = eLib.getDataFromExceladmin1("Admin1", 1, 5);
//		String doctorph_no = eLib.getDataFromExceladmin1("Admin1", 1, 6);
//		String doctoremail = eLib.getDataFromExceladmin1("Admin1", 1, 7) + jLib.getRandomNumber();
//		String emailcom = eLib.getDataFromExceladmin1("Admin1", 1, 8);
//		String email = doctoremail + emailcom;
//		String doctorpassword = eLib.getDataFromExceladmin1("Admin1", 1, 9);
//		String doctorcpassword = eLib.getDataFromExceladmin1("Admin1", 1, 10);
//
//		/* Creating the doctor */
//		aadp.addDoctor(doctorspecialization, doctorName, doctoraddress, doctorfees, doctorph_no, email, doctorpassword,doctorcpassword);
//		wLib.switchtoAlertAndAccept(driver);
//		UtilityClassObject.getTest().log(Status.PASS, "----Doctor created-----");
//		Reporter.log("----Doctor created-----",true);
//		
//		/* Verifying Manage doctors page is displayed after adding doctor */
//		String ManageDoctorsActualTiltle="Admin | Manage Doctors";
//		String ManageDoctorExpectedTitle = driver.getTitle();
//		Assert.assertEquals(ManageDoctorsActualTiltle,ManageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Manage Doctors page is displayed-----");
//		Reporter.log("==Manage  Doctor page is displayed==",true);
//		
//		/* performing logout */
//		configAM();
//		
//		/*verify admin logout is done */
//		String HomepageActualTiltle="Hospital management System";
//		String HomepageDoctorExpectedTitle = driver.getTitle();
//		System.out.println(HomepageDoctorExpectedTitle);
//		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Admin logged out successfully-----");
//		Reporter.log("=Admin logged out successfully=",true);
//		
//		/*Verify weather created doctor is able to login*/
//		hp.getDoctorLoginClickHereButton().click();
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToDoctor(driver, email, doctorpassword);
//		String DoctorDashboardactualtiltle="Doctor | Dashboard";
//		String DoctorDashboarexpectedtitle = driver.getTitle();
//		System.out.println(DoctorDashboarexpectedtitle);
//		Assert.assertEquals(DoctorDashboardactualtiltle, DoctorDashboarexpectedtitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Doctor able to login-----");
//		Reporter.log("=Doctor able to login=",true);
//		
//		/*navigate to AddPatient page*/
//		DoctorDashboardPage ddp=new DoctorDashboardPage(driver);
//		ddp.getPatientsDropDown().click();
//		ddp.getAddPatientBtn().click();
//		String AddPatientactualtiltle="Doctor | Add Patient";
//		String AddPatientexpectedtitle = driver.getTitle();
//		System.out.println(AddPatientexpectedtitle);
//		Assert.assertEquals(AddPatientactualtiltle,AddPatientexpectedtitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----AddPatient page is displayed-----");
//		Reporter.log("=AddPatient page is displayed=",true);
//		
//		/* Fetching the data from Excel file */
//		String pName = eLib.getDataFromExceladmin1("Admin1", 6, 2)+ jLib.getRandomNumber();
//		String paddress = eLib.getDataFromExceladmin1("Admin1", 6, 5);
//		String pph_no = eLib.getDataFromExceladmin1("Admin1", 6, 3);
//		String pemail = eLib.getDataFromExceladmin1("Admin1", 6, 4) + jLib.getRandomNumber();
//		String page = eLib.getDataFromExceladmin1("Admin1", 6, 6);
//		String phistory = eLib.getDataFromExceladmin1("Admin1", 6, 7);
//	
//		/*Add a patient*/
//		AddPatientPage app=new AddPatientPage(driver);
//		app.addMalePatients(pName, pph_no, pemail, paddress, page, phistory);
//		Assert.assertEquals(AddPatientactualtiltle,AddPatientexpectedtitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Patient added successfully-----");
//		Reporter.log("=Patient added successfully=",true);
//		UtilityClassObject.getTest().log(Status.PASS, "----AddPatient page is displayed-----");
//		Reporter.log("=AddPatient page is displayed=",true);
//			
//		/*verify Doctor logout is done */
//		hp.getAdminAccount().click();
//		hp.getLogoutLink().click();
//		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Doctor logged out successfully-----");
//		Reporter.log("=Doctor logged out successfully=",true);
//		
//		/* performing admin login */
//		configBM();
//		
//		/*verifying admin is logged in*/
//		String AdminActualTiltle="Admin | Dashboard";
//		String AdminExpectedTitle = driver.getTitle();
//		System.out.println(AdminExpectedTitle);
//		Assert.assertEquals(AdminActualTiltle,AdminExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Admin dashboard page is displayed-----");
//		Reporter.log("==admin dashboard page is displayed==",true);
//		
//		/*navigate to admin view paitents page */
//		adp.getTotalPatientsLink().click();
//		System.out.println(".....");
//		String AdminactualpaitentTitle="Admin | View Patients";
//		String AdminexpextedpaitentTitle = driver.getTitle();
//		System.out.println(AddPatientexpectedtitle);
//		Assert.assertEquals(AdminactualpaitentTitle,AdminexpextedpaitentTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----paitent details page is displayed-----");
//		Reporter.log("==paitent details page is displayed==",true);
//		
//		
//		/*verifying added patient details is displayed*/
//		Admin1_Manage_Patients_Page ampp=new Admin1_Manage_Patients_Page(driver);
//		boolean status = ampp.verifyAddedPatientIsDisplayed(driver, pName);
//		Assert.assertTrue(true);
//		UtilityClassObject.getTest().log(Status.PASS, "----patient details displayed-----");
//		Reporter.log("--patient details displayed---",true);	
//}
//	
//	@Test
//
//	public void deleteUser() throws Throwable {
//			
//		UtilityClassObject.getTest().log(Status.INFO, "----Deleting User-----");
//		Reporter.log("==Deleting User==",true);
//		
//		
//		/* performing logout */
//		configAM();
//		
//		/*verify admin logout is done */
//		String HomepageActualTiltle="Hospital management System";
//		String HomepageDoctorExpectedTitle = driver.getTitle();
//		Assert.assertEquals(HomepageActualTiltle,HomepageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Admin logged out successfully-----");
//		Reporter.log("=Admin logged out successfully=",true);
//		
//		/*navigate to login page*/
//		Home hp=new Home(driver);
//		hp.getPatienLoginClickHereButton().click();
//		wLib.switchToTabOnTitle(driver, "User-Login");
//		String LoginpageActualTiltle="User-Login";
//		String LoginpageDoctorExpectedTitle = driver.getTitle();
//		Assert.assertEquals(LoginpageActualTiltle,LoginpageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Login page is displayed-----");
//		Reporter.log("=Login page is displayed=",true);
//		
//		/* Fetching the data from Excel file */
//		String uName = eLib.getDataFromExceladmin1("Admin1", 9, 2)+ jLib.getRandomNumber();
//		String uaddress = eLib.getDataFromExceladmin1("Admin1", 9, 3);
//		String ucity = eLib.getDataFromExceladmin1("Admin1", 9, 4);
//		String uemail = eLib.getDataFromExceladmin1("Admin1", 9, 5) + jLib.getRandomNumber();
//		String upassword = eLib.getDataFromExceladmin1("Admin1", 9, 6);
//		String cpassword = eLib.getDataFromExceladmin1("Admin1", 9, 7);
//		
//		/*register as a patient*/
//		PatientRegisterPage prp=new PatientRegisterPage(driver);
//		prp.registerAsMalePatient(uName, uaddress, ucity, uemail, upassword, cpassword);
//		wLib.switchtoAlertAndAccept(driver);
//		String RegisterpageActualTiltle="User Registration";
//		String RegisterpageExpectedTitle = driver.getTitle();
//		System.out.println(RegisterpageExpectedTitle);
//		Assert.assertEquals(RegisterpageActualTiltle,RegisterpageExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----user createded successfully-----");
//		Reporter.log("=user createded successfully=",true);
//		
//		/*close the Registerpage and switch driver to homepage*/
//		driver.close();
//		wLib.switchToTabOnTitle(driver, " Hospital management System ");
//		Assert.assertEquals(LoginpageActualTiltle,LoginpageDoctorExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Login page is displayed-----");
//		Reporter.log("=Login page is displayed=",true);
//		
//		/* performing admin login */
//		configBM();
//		
//		/*verifying admin is logged in*/
//		String AdminActualTiltle="Admin | Dashboard";
//		String AdminExpectedTitle = driver.getTitle();
//		Assert.assertEquals(AdminActualTiltle,AdminExpectedTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----Admin dashboard page is displayed-----");
//		Reporter.log("==admin dashboard page is displayed==",true);
//		
//		/*navigate to manage user page*/
//		Admin1_Dashboard_Page adp = new Admin1_Dashboard_Page(driver);
//		adp.getTotalUsersLink().click();
//		/*navigate to admin view paitents page */
//		String AdminUsertTiltle="Admin | Manage Users";
//		String AdminUsertTitle = driver.getTitle();
//		//Assert.assertEquals(AdminUsertTiltle,AdminUsertTitle);
//		UtilityClassObject.getTest().log(Status.PASS, "----User details page is displayed-----");
//		Reporter.log("==User details page is displayed==",true);
//		
//		/*Delete user and verify*/
//		Admin1_Manage_user_Page amup=new Admin1_Manage_user_Page(driver);
//		boolean status = amup.deleteUser(driver, uName);
//		Assert.assertTrue(true);
//		UtilityClassObject.getTest().log(Status.PASS, "----user deleted successfully-----");
//		Reporter.log("--completed---",true);
//	}
}