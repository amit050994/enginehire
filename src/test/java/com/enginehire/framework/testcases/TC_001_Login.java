package com.enginehire.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.enginehire.framework.base.BaseTest;
import com.enginehire.framework.base.DriverInstance;
import com.enginehire.framework.pages.LoginPage;

public class TC_001_Login extends BaseTest{
	
WebDriver driver;
	
	@Test(priority = 1)
	public void tc_001_01_Login() throws Exception {
		test = extent.createTest("Verify Login as Admin");
		driver = DriverInstance.getInstance().getDriver();
		Thread.sleep(3000);
		LoginPage login = new LoginPage(driver);
		login.enteremail();
		login.enterPassword();
		login.ClickLoginbtn();
		login.WaituntilDashboard();
		login.VerifyTitle();
		
	}

}
