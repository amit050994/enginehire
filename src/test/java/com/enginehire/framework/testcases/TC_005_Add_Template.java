package com.enginehire.framework.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.enginehire.framework.base.BaseTest;
import com.enginehire.framework.base.DriverInstance;
import com.enginehire.framework.pages.DashboardPage;
import com.enginehire.framework.pages.DocumentTempPage;

public class TC_005_Add_Template extends BaseTest {
	
WebDriver driver;
	
	@Test(priority = 1)
	public void tc_005_01_Add_Template() throws Exception {
		test = extent.createTest("Verify the Add Template.");
		driver = DriverInstance.getInstance().getDriver();
		Thread.sleep(3000);
		DashboardPage Dashboard = new DashboardPage(driver);
		Dashboard.GotoTempTab();
		DocumentTempPage DocumentTemp = new DocumentTempPage(driver);
		DocumentTemp.ClickonAddbtn();
		DocumentTemp.EnterName();
		DocumentTemp.ClickSigncheckbox();
		DocumentTemp.ClickAddField();
		DocumentTemp.EnterFieldName();
		DocumentTemp.clickAddbtn();
		DocumentTemp.EnterBodyText();
		DocumentTemp.EnterSigningName();
		DocumentTemp.AddMessageafterSigning();
		DocumentTemp.ClickCreatebtn();
		DocumentTemp.WaitforSuccessMessage();
	}

}
