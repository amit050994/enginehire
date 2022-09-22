package com.enginehire.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.enginehire.framework.base.BaseTest;
import com.enginehire.framework.pages.SubmitFormPage;

public class TC_003_Submit_Form extends BaseTest {

WebDriver driver;
	
	@Test(priority = 1)
	public void tc_003_01_SubmitForm() throws Exception {
		test = extent.createTest("Verify the Application form Submission and checking the success Message.");
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		SubmitFormPage SubmitForm = new SubmitFormPage(driver);
		SubmitForm.openApplicationform();
		SubmitForm.SubmitDetails();
		SubmitForm.WaitforSuccessMessage();
		SubmitForm.closeBrowser();
		
	}
	
}
