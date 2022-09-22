package com.enginehire.framework.pages;

import java.io.IOException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.enginehire.framework.utility.Utility;


public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath = "//input[@id='inputEmail']")
	public WebElement Email;

	@FindBy(xpath = "//input[@id='inputPassword']")
	public WebElement Password;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Login')]")
	public WebElement LogInbtn;

	public void enteremail() throws IOException {
		Email.sendKeys(Utility.fetchPropertyValue("Email").toString());
	}

	public void enterPassword() throws IOException {
		Password.sendKeys(Utility.fetchPropertyValue("Password").toString());
	}
	
	public void ClickLoginbtn() {
		LogInbtn.click();
		waitForPageLoad(driver);
	}

	public void WaituntilDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Welcome to  Mission Control')]")));
	}

	public void VerifyTitle() {

		String GetTitle = driver.getTitle();
		if (GetTitle.contains("Enginehire"))
			// Pass
			System.out.println("Signin Success.");
		else
			// Fail
			System.out.println(GetTitle);
	}

	public void waitForPageLoad(WebDriver driver) {

		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
		wait.until(new Function<WebDriver, Boolean>() {

			public Boolean apply(WebDriver driver) {
				return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
						.equals("complete");
			}
		});
	}

}
