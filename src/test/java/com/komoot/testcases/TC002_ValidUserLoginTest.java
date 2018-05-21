package com.komoot.testcases;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.komoot.TestBase.TestBase;
import com.komoot.pages.HomePage;
import com.komoot.pages.LoginPage;
import com.komoot.pages.WelcomePage;

public class TC002_ValidUserLoginTest extends TestBase {

	public final static Logger log = Logger.getLogger(TC002_ValidUserLoginTest.class.getName());

	@Test
	public void verifyValidUserLogInAndScreenElements() throws FileNotFoundException {

		log.info("###########Komoot Application has been Launched###########");

		WelcomePage launch = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);

		HomePage home = new HomePage(driver);

		launch.clickOnLogInHereKLink();
		waitForElement(driver, launch.cancelEmailAccountSelecion, defaultTimeout);
		launch.clickCancelExistingEmailAccountselection();
		waitForElement(driver, login.emailTextField, defaultTimeout);

		Assert.assertTrue(login.emailTextField.isDisplayed());
		Assert.assertTrue(login.passwordTextField.isDisplayed());
		Assert.assertTrue(login.logInButton.isDisplayed());
		Assert.assertTrue(login.forgotPasswordLink.isDisplayed());

		login.performLogin(getTestData(getClassName(), "userName"), getTestData(getClassName(), "password"));
		
		//Optional if the prerequisite not meet
		//home.enableLocation();
		
		waitForElement(driver, home.discoverMenu, defaultTimeout);
		Assert.assertTrue(home.discoverMenu.isDisplayed());

		log.info("###########Login was successful using Valid user credentioals###########");

	}

}
