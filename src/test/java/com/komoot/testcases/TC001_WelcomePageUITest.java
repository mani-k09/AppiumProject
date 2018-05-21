package com.komoot.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.komoot.TestBase.TestBase;
import com.komoot.pages.WelcomePage;

public class TC001_WelcomePageUITest extends TestBase {

	public final static Logger log = Logger.getLogger(TC001_WelcomePageUITest.class.getName());

	@Test
	public void verifylaunchpageElements() {
		log.info("###########Komoot Application has been Launched###########");
		WelcomePage launch = new WelcomePage(driver);

		//Validating UI elements present on screen
		Assert.assertTrue(launch.logo.isDisplayed());
		Assert.assertTrue(launch.captionText.isDisplayed());
		Assert.assertTrue(launch.faceBookSignUpButton.isDisplayed());
		Assert.assertTrue(launch.emailSignUpButon.isDisplayed());
		Assert.assertTrue(launch.termsOfServiceLink.isDisplayed());
		Assert.assertTrue(launch.haveAnAccountLink.isDisplayed());
		Assert.assertTrue(launch.logInHereLink.isDisplayed());

		log.info("###########Komoot Application Launch Page has been Verified###########");

		launch.clickOnTermsOfServiceLink();
		waitForElement(driver, launch.termsPage, defaultTimeout);
		Assert.assertTrue(launch.termsPage.isDisplayed());

		log.info("###########Terms of service Navigation has been verified###########");
		driver.navigate().back();

		launch.clickOnLogInHereKLink();
		waitForElement(driver, launch.cancelEmailAccountSelecion, defaultTimeout);
		Assert.assertTrue(launch.cancelEmailAccountSelecion.isDisplayed());

		log.info("###########Login Using email option has been verified###########");

		launch.clickCancelExistingEmailAccountselection();

	}

}
