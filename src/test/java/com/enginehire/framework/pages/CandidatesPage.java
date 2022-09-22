package com.enginehire.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidatesPage {

	WebDriver driver;

	public CandidatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath = "//table[@class='table table-striped mt-2 shadow']")
	public WebElement CandidatedTable;
	
	static String value = null;
	public static void setValue1(String value) {
		CandidatesPage.value = value;
		
	}
	
	public void VerifysubmittedEmail() throws InterruptedException {
		WebElement elem = CandidatedTable.findElement(By.xpath("//span[contains(text(),'"+value+"')]"));
		if (elem != null && elem.getText().contains(value)) {
			System.out.println("The user's email is showing.");
			
		}
		else {
			System.out.println("Something is wrong.");
		}
		
	}
}
