package com.komoot.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.komoot.TestBase.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends TestBase{
	public HomePage(AppiumDriver<WebElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility = "PLAN")
	public WebElement planMenu;
	
	@AndroidFindBy(accessibility = "MAP")
	public WebElement mapMenu;
	
	@AndroidFindBy(accessibility = "PROFILE")
	public WebElement profileMenu;
	
	@AndroidFindBy(accessibility = "REGIONS")
	public WebElement regionMenu;
	
	@AndroidFindBy(accessibility = "DISCOVER")
	public WebElement discoverMenu;
	
	@AndroidFindBy(accessibility = "Search query")
	public WebElement searchQueryTextField;
	
	@AndroidFindBy(accessibility = "Clear query")
	public WebElement clearQuerymenu;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout")
	public List<WebElement> searchResultText;
	
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout/android.widget.ImageView")
	public List<WebElement> activityIcon;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	public WebElement activityText;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='PLAN TOUR']")
	public WebElement planTourText;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.view.View[1]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	public WebElement startLocationText;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView/android.view.View[2]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	public WebElement destinationLocationText;
	
	
	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.View/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[1][@text='From Düsseldorf to Paris']")
	public WebElement routeInformationText;
	
	@FindBy(xpath = "//android.widget.Button[@text='START NAVIGATION']")
	public WebElement startNavigationButtonText;
	
	@FindBy(xpath = "//android.widget.TextView[@text='GPS disabled']")
	public WebElement GpsDisabledText;
	
	@FindBy(xpath = "//android.widget.Button[@text='Settings']")
	public WebElement locatonSettingsButtonText;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Use GPS satellites']")
	public WebElement enableLocatonSettings;
			
	public void clickProfileMenu(){
		profileMenu.click();	
		}
	
	public void clickMAPMenu(){
		mapMenu.click();	
		}
	
	public void clickRegionsMenu(){
		regionMenu.click();	
		}
	
	public void clickPlanMenu(){
		planMenu.click();
	}
	
	public void clickDiscoverMenu(){
		  discoverMenu.click();	
		}
	
	public void clickStartLocation(){
		startLocationText.click();
	}
	
	public void enterDestinationLocation(String startLocation){
		destinationLocationText.click();

	}
	
	public void searchTripRoute(String startLocation, String endLocationtext){
		startLocationText.click();
		searchQueryTextField.sendKeys(startLocation);
		searchResultText.get(0).click();
		destinationLocationText.click();
		searchQueryTextField.sendKeys(endLocationtext);
		searchResultText.get(0).click();
		planTourText.click();
	}
	
	public void enableLocation(){
		
		if (GpsDisabledText.isDisplayed()){
			locatonSettingsButtonText.click();
			enableLocatonSettings.click();
			driver.navigate().back();
		}
		else{
			log.info("Location Services already enabled");
		}
	}
	
	public void checkTextUpdateOnSelectingActivityIcon(){
		String[] activityName = {"Hiking","Bike","Mountain Bike","Road Bike","Running","Bike(With Gravel)","Mountain Bike(Alphine)","Mountain Climbing"};
		
		int storedActivityCount = activityName.length;
		
	    int activityCount = activityIcon.size();
		
		System.out.println("Total activities :" + activityCount);
		
		for (int i = 0; i< activityCount;i++){
			//System.out.println("########### stored values" + activityName[i]);
			activityIcon.get(i).click();
		
		for(int j = 0;j<storedActivityCount;j++)
		{
				activityIcon.get(i).click();
				   String activityFound = activityText.getText();
				   System.out.println("#### Activity found" +activityFound );
				if(activityName.equals(activityIcon.get(j).getText())) {
					System.out.println("matched");
				}
			}
		   		   
//		   if(activityFound = activityName[i])
		   
		}
			
		}
		
	

}
