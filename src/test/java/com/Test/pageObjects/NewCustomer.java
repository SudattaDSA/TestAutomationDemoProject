package com.Test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer {
	WebDriver ldriver;

	public NewCustomer(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//a[text()=\"New Customer\"]")
	@CacheLookup
	WebElement lnkNewCustomer;

	public void clickNewCustomer() {
		lnkNewCustomer.click();
	}
}
