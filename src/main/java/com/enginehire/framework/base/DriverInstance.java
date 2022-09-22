package com.enginehire.framework.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import com.enginehire.framework.utility.Utility;

public class DriverInstance {

	private static DriverInstance factory = new DriverInstance();
	private WebDriver driver;

	private DriverInstance() {
	}

	public static DriverInstance getInstance() {
		return factory;
	}

	public WebDriver getDriver() throws IOException {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();

			// To maximize the browser
			driver.manage().window().maximize();
			driver.get(Utility.fetchPropertyValue("URL").toString());
			

		}
		return driver;
	}

	@AfterMethod
	public void CloseDriverInstance() {
		// driver.quit();
	}
}
