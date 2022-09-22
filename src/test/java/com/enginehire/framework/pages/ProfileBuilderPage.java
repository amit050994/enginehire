package com.enginehire.framework.pages;

import java.util.ArrayList;
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

public class ProfileBuilderPage {

	WebDriver driver;

	public ProfileBuilderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath = "//i[@class='material-icons'][contains(text(),'launch')]")
	public WebElement ClickLaunchbtn;


	
	public void waituntilTableLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='loader']"))));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table table-striped mt-2']")));
	
	}
	
	public void ClkApplicationFormLink() throws InterruptedException {
		ClickLaunchbtn.click(); 
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		waitForPageLoad(driver);
	}

	public void CopyLink() throws InterruptedException {
		String CurrentURL= driver.getCurrentUrl();
		SubmitFormPage.setValue(CurrentURL);
	}
	
	public void backtoparentTab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
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
