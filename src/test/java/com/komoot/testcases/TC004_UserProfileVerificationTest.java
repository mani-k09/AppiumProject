package com.komoot.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.komoot.TestBase.TestBase;
import com.komoot.pages.FindFriendspage;
import com.komoot.pages.HomePage;
import com.komoot.pages.LoginPage;
import com.komoot.pages.UserProfilePage;
import com.komoot.pages.WelcomePage;

import org.testng.Assert;

public class TC004_UserProfileVerificationTest extends TestBase {

	public final static Logger log = Logger.getLogger(TC004_UserProfileVerificationTest.class.getName());

	@Test
	public void verifyUserProfileVerification() throws FileNotFoundException {

		WelcomePage launch = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		UserProfilePage profile = new UserProfilePage(driver);
		FindFriendspage friends = new FindFriendspage(driver);

		launch.clickOnLogInHereKLink();
		waitForElement(driver, launch.cancelEmailAccountSelecion, defaultTimeout);
		launch.clickCancelExistingEmailAccountselection();

		login.performLogin(getTestData(getClassName(), "userName"), getTestData(getClassName(), "password"));
		waitForElement(driver, home.discoverMenu, defaultTimeout);

		log.info("###########Login was successful###########");

		home.clickProfileMenu();
		waitForElement(driver, profile.profileName, defaultTimeout);

		log.info("###########Profile page loaded successfuly###########");

		Assert.assertEquals(getTestData(getClassName(), "profileName"), profile.getUsername());
		Assert.assertTrue(profile.profileSettings.isDisplayed());
		Assert.assertEquals(getTestData(getClassName(), "planTour"), profile.planToursText.getText());
		Assert.assertTrue(profile.noToursText.isDisplayed());
		int follwercount = Integer.parseInt((getTestData(getClassName(), "totalFollowers")));
		int followingcount = Integer.parseInt((getTestData(getClassName(), "totalFollowings")));
		
		Assert.assertEquals(follwercount, profile.findNumbeOfFollowers());
		Assert.assertEquals(followingcount, profile.findNumbeOfFollowing());

		log.info("###########Profile page UI verified successfuly###########");

		profile.checkfindFriendsNavigation();
		waitForElement(driver, friends.findFriendsContext, defaultTimeout);

		log.info("###########Find friends page loaded successfuly###########");
	}

}
