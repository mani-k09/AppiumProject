package com.komoot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FindFriendspage {
	
	public FindFriendspage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find Friends']")
	public WebElement findFriendsTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Find out which of your friends are using komoot:']")
	public WebElement findFriendsContext;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='VIA FACEBOOK']")
	public WebElement findFriendsViaFacebook;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='VIA EMAIL']")
	public WebElement findFriendsViaEmail;
	
	
	public void clickFaceBookButton(){
		findFriendsViaFacebook.click();
	}
	
	public void clickEmailButton(){
		findFriendsViaEmail.click();
	}

}
