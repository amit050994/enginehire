package com.enginehire.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.enginehire.framework.base.BaseTest;
import com.enginehire.framework.base.DriverInstance;
import com.enginehire.framework.pages.CandidatesPage;
import com.enginehire.framework.pages.DashboardPage;

public class TC_004_Candidates extends BaseTest {
	
WebDriver driver;
	
	@Test(priority = 1)
	public void tc_004_01_VerifyForm() throws Exception {
		test = extent.createTest("Verify the submitted Application form with the email.");
		driver = DriverInstance.getInstance().getDriver();
		Thread.sleep(3000);
		DashboardPage Dashboard = new DashboardPage(driver);
		Dashboard.GotoCandidatesTab();
		CandidatesPage Candidates = new CandidatesPage(driver);
		Candidates.VerifysubmittedEmail();
	}

	
}
