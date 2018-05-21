package com.komoot.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	public LoginPage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	public List<WebElement> loginTextFields;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[1]")
	public WebElement emailTextField;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[2]")
	public WebElement passwordTextField;
	
	@AndroidFindBy(xpath = "//android.widget.Button")
	public WebElement logInButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	public WebElement forgotPasswordLink;
	
	public void performLogin(String emilAddress,String password){
		loginTextFields.get(0).sendKeys("logintomani@gmail.com");
		loginTextFields.get(1).sendKeys("komoot@123");
		logInButton.click();
	}
	
	
	
	
	
	
	

}
