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

public class DocumentTempPage {

	WebDriver driver;

	public DocumentTempPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath = "//button[contains(text(),'Add Template')]")
	public WebElement AddTempBtn;
	
	@FindBy(xpath = "//div[@class='dialog-content-container']/div/input[1]")
	public WebElement EnterName;
	
	@FindBy(xpath = "//input[@id='checkbox-item-139-sign_by_both']")
	public WebElement Signcheckbox;
	
	@FindBy(xpath = "//button[contains(text(),'Add Field')]")
	public WebElement AddField;
	
	@FindBy(xpath = "//div[2][@class='row']/div/div/input")
	public WebElement FieldName;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Add')]")
	public WebElement Addbtn;
	
	@FindBy(xpath = "//div[@class='content-editable'][@contenteditable='true']")
	public WebElement EnterBody;
	
	@FindBy(xpath = "//input[2][@type='text'][@class='form-control']")
	public WebElement AddSigningName;
	
	@FindBy(xpath = "//textarea[@class='form-control']")
	public WebElement AddMessage;
	
	@FindBy(xpath = "//button[@class='mylisting-button dark-button'][contains(text(),'Create')]")
	public WebElement Createbtn;
	
	public void ClickonAddbtn() throws InterruptedException {
		AddTempBtn.click();
		Thread.sleep(3000);
		
	}
	
	public void EnterName() throws InterruptedException {
		EnterName.click();
		EnterName.sendKeys("Test");
		Thread.sleep(1000);
	}
	
	public void ClickSigncheckbox() throws InterruptedException {
		Signcheckbox.click();
		Thread.sleep(1000);
		
	}
	
	public void ClickAddField() throws InterruptedException {
		AddField.click();
		Thread.sleep(3000);
		
	}
	
	public void EnterFieldName() throws InterruptedException {
		FieldName.click();
		FieldName.sendKeys("Test");
		Thread.sleep(1000);
	}
	
	public void clickAddbtn() throws InterruptedException {
		Addbtn.click();
		Thread.sleep(2000);
	}
	
	public void EnterBodyText() throws InterruptedException {
		EnterBody.click();
		EnterBody.sendKeys("This is for testing purposes.");
		Thread.sleep(3000);
		
	}
	
	public void EnterSigningName() throws InterruptedException {
		AddSigningName.click();
		AddSigningName.sendKeys("Test");
		Thread.sleep(1000);
	}
	
	public void AddMessageafterSigning() throws InterruptedException {
		AddMessage.click();
		AddMessage.sendKeys("The Success Message");
		Thread.sleep(2000);
	}
	
	public void ClickCreatebtn() throws InterruptedException {
		Createbtn.click();
		Thread.sleep(3000);
	}
	
	public void WaitforSuccessMessage() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Template created.')]")));
	
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
