package com.komoot.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.komoot.TestBase.TestBase;
import com.komoot.pages.HomePage;
import com.komoot.pages.LoginPage;
import com.komoot.pages.UserProfilePage;
import com.komoot.pages.WelcomePage;

public class TC005_SeacrhTourAndLogoutTest extends TestBase {

	public final static Logger log = Logger.getLogger(TC004_UserProfileVerificationTest.class.getName());

	@Test
	public void verifySearchTourTest() throws FileNotFoundException {

		WelcomePage launch = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		UserProfilePage profile = new UserProfilePage(driver);

		launch.clickOnLogInHereKLink();
		waitForElement(driver, launch.cancelEmailAccountSelecion, defaultTimeout);
		launch.clickCancelExistingEmailAccountselection();

		login.performLogin(getTestData(getClassName(), "userName"), getTestData(getClassName(), "password"));
		
		waitForElement(driver, home.discoverMenu, defaultTimeout);
		
		log.info("###########Login was successful using Valid user credentioals###########");
        		
		home.clickPlanMenu();
		waitForElement(driver, home.planTourText, defaultTimeout);
		log.info("###########Komoot - Plan page loaded successfully###########");

		home.searchTripRoute("Dusseldorf", "paris");

		log.info("###########A Route was found in the search results###########");

	    navigateBack();

		waitForElement(driver, home.profileMenu, defaultTimeout);

		home.clickProfileMenu();
		
		log.info("###########Profile Page loaded successfully###########");

		waitForElement(driver, profile.profileName, defaultTimeout);

		profile.clickSettingsIcon();
		waitForElement(driver, profile.accountTextTitle, defaultTimeout);
		log.info("###########Profile Setttings Page loaded successfully###########");
		
		verticalSwipe();
		waitForElement(driver, profile.logoutText, defaultTimeout);
		profile.logoutText.click();



	}

}
