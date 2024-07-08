package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.DoctorBaseClass;
import com.comcast.crm.generic.basetest.PatientBaseClass;
/**
 * 
 * @author Deepak
 *
 */
public class SampleTest extends PatientBaseClass {

	@Test(groups = {"smokeTest"})
	public void createConTactTest() throws Throwable {		
		/* read testScritp data from Excel file*/
		//String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
		Thread.sleep(5000);
	
	}

}
