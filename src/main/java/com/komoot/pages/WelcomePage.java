package com.komoot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage {
	
	
	public WelcomePage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "android.widget.ImageView")
	public WebElement logo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN UP WITH FACEBOOK']")
	public WebElement faceBookSignUpButton;
	
	@FindBy(name = "SIGN UP WITH FACEBOOK")
	public WebElement faceBookSignUpButtonText;
	
	@FindBy(name= "Explore more of the great outdoors. More trails, more peaks, more adventure.")
	public WebElement captionTextContent;

	@AndroidFindBy(xpath = "//android.view.View/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView[1]")
	public WebElement captionText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SIGN UP WITH EMAIL']")
	public WebElement emailSignUpButon;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='By signing up you agree to our Terms of Service.']")
	public WebElement termsOfServiceLink;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Have an account?']")
	public WebElement haveAnAccountLink;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='LOG IN HERE']")
	public WebElement logInHereLink;
	
	@AndroidFindBy(className = "dummyId']")
	public WebElement dummyIdTest;
	
	@AndroidFindBy(className = "android.webkit.WebView")
	public WebElement termsPage;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='None of the above']")
	public WebElement cancelEmailAccountSelecion;
	
		
	public void clickOnFaceBookButton(){
		faceBookSignUpButton.click();
	}
	
	public void clickOnEmailButton(){
		emailSignUpButon.click();
	}
	
	public void clickOnTermsOfServiceLink(){
		termsOfServiceLink.click();
	}
	
	public void clickOnLogInHereKLink(){
		logInHereLink.click();
	}
    
	public void clickOndummyIdTest(){
		faceBookSignUpButtonText.click();
	}
	
	public void findTextContent(){
		faceBookSignUpButton.getText();
		System.out.println("#########"+faceBookSignUpButton.getText());
	}
	
	public void clickCancelExistingEmailAccountselection(){
		cancelEmailAccountSelecion.click();
	}
	
	
}
