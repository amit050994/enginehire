package com.enginehire.framework.pages;

import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath = "//span[contains(text(),'Builders')]")
	public WebElement BuildersTab;
	
	@FindBy(xpath = "//span[contains(text(),'Profile Builder')]")
	public WebElement ProfileBuilders;
	
	@FindBy(xpath = "//span[contains(text(),'Users')]")
	public WebElement UsersTab;
	
	@FindBy(xpath = "//span[contains(text(),'Candidates')]")
	public WebElement CandidatesTab;
	
	@FindBy(xpath = "//span[contains(text(),'Templates')][@class='nav-link dropdown-toggle']")
	public WebElement TemplatesTab;
	
	@FindBy(xpath = "//span[contains(text(),'Document Templates')]")
	public WebElement DocTemp;
	
	public void GotoProfileBuilders() throws InterruptedException {
		BuildersTab.click();
		Thread.sleep(1000);
		ProfileBuilders.click();
		Thread.sleep(7000);
	}
	
	public void GotoCandidatesTab() throws InterruptedException {
		
		UsersTab.click();
		Thread.sleep(1000);
		CandidatesTab.click();
		Thread.sleep(7000);
	}
	
	public void GotoTempTab() throws InterruptedException {
		
		TemplatesTab.click();
		Thread.sleep(1000);
		DocTemp.click();
		Thread.sleep(7000);
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
