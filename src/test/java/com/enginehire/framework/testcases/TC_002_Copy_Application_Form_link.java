package com.enginehire.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.enginehire.framework.base.BaseTest;
import com.enginehire.framework.base.DriverInstance;
import com.enginehire.framework.pages.DashboardPage;
import com.enginehire.framework.pages.ProfileBuilderPage;

public class TC_002_Copy_Application_Form_link extends BaseTest{
WebDriver driver;
	
	@Test(priority = 1)
	public void tc_002_01_Copy_Link() throws Exception {

		test = extent.createTest("Verify Open Profile Builder and copy the Application form URL");
		driver = DriverInstance.getInstance().getDriver();
		Thread.sleep(3000);
		DashboardPage Dashboard = new DashboardPage(driver);
		ProfileBuilderPage ProfileBuilder = new ProfileBuilderPage(driver);
		Dashboard.GotoProfileBuilders();
		ProfileBuilder.ClkApplicationFormLink();
		ProfileBuilder.CopyLink();
		ProfileBuilder.backtoparentTab();
	}
}
