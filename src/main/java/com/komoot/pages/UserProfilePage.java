package com.komoot.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserProfilePage {
	
	public UserProfilePage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.view.View/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	public WebElement profileName;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ImageButton[2]")
	public WebElement profileSettings;
	
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView")
	public List<WebElement> followersInfo;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
	public List<WebElement> followingInfo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FIND FRIENDS']")
	public WebElement finfFriendsTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='No Tours? Go explore now!']")
	public WebElement noToursText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Plan Tour']")
	public WebElement planToursText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ACCOUNT']")
	public WebElement accountTextTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	public WebElement logoutText;
	

	
	public String getUsername(){
		String userName = profileName.getText();
		return userName;
	}
	
	public int findNumbeOfFollowers(){
		String followersCount = followersInfo.get(0).getText();
		int count = Integer.parseInt(followersCount);
		return count;
	}
	
	public int findNumbeOfFollowing(){
		String followingCount = followingInfo.get(0).getText();
		int count = Integer.parseInt(followingCount);
		return count;
	}
	
	public void checkfindFriendsNavigation(){
		finfFriendsTitle.click();
	}
	
	public void clickSettingsIcon(){
		profileSettings.click();
	}
	
	public void clickLogOut(){
		logoutText.click();
	}

	

}
	
	
	
	
	
	
	
	
	
	


