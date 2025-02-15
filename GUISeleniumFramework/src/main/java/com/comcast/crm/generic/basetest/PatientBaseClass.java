package com.comcast.crm.generic.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.databaseutlity.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PatientBaseClass {
	/* Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public  WebDriver driver = null;
	public Home hp;
	public  static WebDriver sdriver = null;


	
		@BeforeSuite(groups = {"smokeTest", "regressionTest"})
		public void configBS() throws Throwable {
			System.out.println("===Connect to DB , Report Config===");
			dbLib.getDbconnection();
		}
		
		
       //  @Parameters ("BROWSER")
	    @BeforeClass(groups = {"smokeTest", "regressionTest"})
	    public void configBC() throws Throwable {
	    	
	    System.out.println("==Launch the BROWSER==");
	    
		
		
	    
	   // String BROWSER	= fLib.getDataFromPropertiesFile("browser");
	    String BROWSER = System.getProperty("browser" , fLib.getDataFromPropertiesFile("browser"));
		if(BROWSER.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		}else if(BROWSER.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOption = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOption);
		}else if(BROWSER.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOption = new EdgeOptions();
			driver = new EdgeDriver(edgeOption);
		}else {
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			driver = new ChromeDriver(chromeOptions);
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		driver.manage().window().maximize();
		driver.get(System.getProperty("url" ,fLib.getDataFromPropertiesFile("url")));
		
	    }
	    
	    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
		public void configBM() throws Throwable {
			System.out.println("=login=");
			String USERNAME = System.getProperty("Patientusername" , fLib.getDataFromPropertiesFile("Patientusername"));
			String PASSWORD = System.getProperty("Patientpassword" , fLib.getDataFromPropertiesFile("Patientpassword"));
			hp = new Home(driver);
			hp.getPatienLoginClickHereButton().click();
			LoginPage lp = new LoginPage(driver);
			lp.loginToPatient(driver, USERNAME, PASSWORD);
		}
	    
	    
		@AfterMethod(groups = {"smokeTest", "regressionTest"})
		public void configAM() {
			System.out.println("=logout=");
			Home hp = new Home(driver);
			hp.getAdminAccount().click();
			hp.getLogoutLink().click();
		}
		
	    
	    @AfterClass(groups = {"smokeTest", "regressionTest"})
	    public void configAC() {
	    	System.out.println("==Close the BROWSER==");
	        driver.quit();
	    }
	    
	   @AfterSuite(groups = {"smokeTest", "regressionTest"})
		public void configAS() throws SQLException {
			System.out.println("===close Db , Report backUP====");
			dbLib.closeDbconnection();
			
		}
}
