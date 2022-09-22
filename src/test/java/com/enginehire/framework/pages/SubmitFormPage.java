package com.enginehire.framework.pages;

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

public class SubmitFormPage {

	WebDriver driver;
	int number = 100 + (int)(Math.random()* ((10000 - 100) + 1));  
	String UserEmail = "testqa"+number+"@yopmail.com";

	public SubmitFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[2][@class='row']/div/div/input")
	public WebElement FName;

	@FindBy(xpath = "//div[3][@class='row']/div/div/input")
	public WebElement LName;
	
	@FindBy(xpath = "//div[4][@class='row']/div/div/input")
	public WebElement Email;
	
	@FindBy(xpath = "//div[5][@class='row']/div/div/input")
	public WebElement Phone;

	@FindBy(xpath = "//button[@id='submit-button']")
	public WebElement Submitbtn;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Login')]")
	public WebElement SuccessMessage;
	
	
	
	static String value = null;
	public static void setValue(String value) {
		SubmitFormPage.value = value;
		
	}
	
	public void openApplicationform() throws InterruptedException {
		driver.get(value);
		waitForPageLoad(driver);
		Thread.sleep(3000);
	}
	
	public void SubmitDetails() throws InterruptedException {
		FName.click();
		FName.sendKeys("Test");
		LName.click();
		LName.sendKeys("QA");
		Email.click();
		Email.sendKeys(UserEmail);
		CandidatesPage.setValue1(UserEmail);
		Phone.click();
		Phone.sendKeys("8775542511");
		Submitbtn.click();
		Thread.sleep(3000);
	}
	
	public void WaitforSuccessMessage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Thank you for your application to join our team!')]")));
	
	}
	
	public void closeBrowser() {
		driver.close();
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
