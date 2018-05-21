package com.komoot.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.komoot.TestBase.TestBase;
import com.komoot.pages.HomePage;
import com.komoot.pages.LoginPage;
import com.komoot.pages.UserProfilePage;
import com.komoot.pages.WelcomePage;

public class TC003_HomepageUITest extends TestBase {

	public final static Logger log = Logger.getLogger(TC003_HomepageUITest.class.getName());

	@Test
	public void verifyHomepageUITest() throws InterruptedException, FileNotFoundException {

		WelcomePage launch = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		UserProfilePage profile = new UserProfilePage(driver);

		launch.clickOnLogInHereKLink();
		waitForElement(driver, launch.cancelEmailAccountSelecion, defaultTimeout);
		launch.clickCancelExistingEmailAccountselection();
		waitForElement(driver, login.emailTextField, defaultTimeout);

		login.performLogin(getTestData(getClassName(), "userName"), getTestData(getClassName(), "password"));
		waitForElement(driver, home.discoverMenu, defaultTimeout);

		log.info("###########Login was successful using Valid user credentioals###########");

		Assert.assertTrue(home.discoverMenu.isDisplayed());
		Assert.assertTrue(home.mapMenu.isDisplayed());
		Assert.assertTrue(home.planMenu.isDisplayed());
		Assert.assertTrue(home.profileMenu.isDisplayed());
		Assert.assertTrue(home.regionMenu.isDisplayed());

		log.info("###########Home Page UI validation was completed###########");

		home.clickProfileMenu();
		waitForElement(driver, profile.profileName, defaultTimeout);
		Assert.assertTrue(profile.profileName.isDisplayed());
		log.info("###########Home Page - user profile icon validated###########");

		home.clickPlanMenu();
		waitForElement(driver, home.planTourText, defaultTimeout);
		Assert.assertTrue(home.planTourText.isDisplayed());
		log.info("###########Home Page - Plan Menu Verified###########");

		home.clickDiscoverMenu();
		waitForElement(driver, home.discoverMenu, defaultTimeout);
		Assert.assertTrue(home.discoverMenu.isDisplayed());

		log.info("###########Home Page - Discover Menu Verification successful###########");

	}

}
