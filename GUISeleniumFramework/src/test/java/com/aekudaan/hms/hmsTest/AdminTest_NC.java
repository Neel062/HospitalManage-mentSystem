package com.aekudaan.hms.hmsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.HomePageBYNeelesh_Pages;
import com.comcast.crm.objectrepositoryutility.LeftPanelMainNavigation;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.PatientCreateAnAccount;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AdminTest_NC extends AdminBaseClass {

	@Test
	public void adminTest() throws Throwable {
		/* Logout as admin */
		configAM();
		
		/* Fetching the data from excel and creating patient */
		Home hp = new Home(driver);
		hp.getPatienLoginClickHereButton().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on patient login button--------------");
		WebDriverUtility wLib=new WebDriverUtility();
		wLib.switchToTabOnTitle(driver, "user-login.php");
		PatientCreateAnAccount pcreate = new PatientCreateAnAccount(driver);
		pcreate.getcreateAnAccPatient().click();
		UtilityClassObject.getTest().log(Status.INFO, "------create an patient account--------------");
		String patientFullName = eLib.getDataFromExcel("Sheet2", 1, 2)+jLib.getRandomNumber();
		Reporter.log(patientFullName);
		String address=eLib.getDataFromExcel("Sheet2", 1, 3);
		Reporter.log(address);
		String city=eLib.getDataFromExcel("Sheet2", 1, 4);
		Reporter.log(city);
		String semail =eLib.getDataFromExcel("Sheet2", 1, 5)+jLib.getRandomNumber();
		Reporter.log(semail);
		String lemail =eLib.getDataFromExcel("Sheet2", 1, 6);
		Reporter.log(lemail);
		String email=semail+lemail;
		String password = eLib.getDataFromExcel("Sheet2", 1, 7);
		Reporter.log(password);
		String passwordAgain = eLib.getDataFromExcel("Sheet2", 1, 8);
		Reporter.log(passwordAgain);
		/* Invoke the method for adding patient */
		pcreate.addPatientUserF(patientFullName, address, city, email, password, passwordAgain);
		wLib.switchtoAlertAndAccept(driver);
		wLib.switchToTabOnURL(driver, "Hospital_Doctor_Patient_Management_System/");
		
		/* Login as patient */
		configBM();
		
		/* Verifying added patient */
		LeftPanelMainNavigation patient=new LeftPanelMainNavigation(driver);
		patient.getUser().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on user--------------");
		patient.getManageUser().click();
		UtilityClassObject.getTest().log(Status.INFO, "------click on  manage user--------------");
		ExcelUtility elib=new ExcelUtility();
		//String actualPatientName=elib.getDataFromExcel("Sheet2", 1, 2);
		String patientName = driver.findElement(By.xpath("//td[text()='"+patientFullName+"']")).getText();
		//String patientName = driver.findElement(By.xpath("//td[@class='hidden-xs']/../td[text()='"+actualPatientName+"']")).getText();
		SoftAssert sft=new SoftAssert();
		boolean status=patientName.contains(patientFullName);
		sft.assertTrue(status);
		Reporter.log("succefully");
		sft.assertAll();
	}
}
