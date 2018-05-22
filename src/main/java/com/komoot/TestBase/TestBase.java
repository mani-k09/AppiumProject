package com.komoot.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class TestBase {

	// Appium Driver
	protected AppiumDriver<WebElement> driver;

	// Default Timeout
	protected final int defaultTimeout = 3000;

	// To print logs
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	// Extent Report
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extent;
	protected ExtentTest logger;

	@SuppressWarnings("rawtypes")
	protected static ThreadLocal parentTest = new ThreadLocal();
	protected static ThreadLocal test = new ThreadLocal();
	public ExtentTest parent;
	public ExtentTest child;

	// Json parser to read test data
	private JsonParser parser = new JsonParser();

	public String currentWorkingDirectory = System.getProperty("user.dir");
	public String fileLocation = currentWorkingDirectory + "\\Testdata.json";
	
	@BeforeClass
	public synchronized void beforeClass_ExtentReport() throws MalformedURLException {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		log.debug("## Before Class :" + getClassName());
		defineDriver();
		createReport();
		parent = extent.createTest(getClass().getSimpleName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public void initClient_ExtentReport(Method method) {
		child = ((ExtentTest) parentTest.get()).createNode(method.getName());
		test.set(child);
	}

	@AfterClass
	public void postTestRun() throws FileNotFoundException {
		log.info("Follwing Test case execution was completed :" + getClassName());
		closeReport();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown_ExtentReport(ITestResult result) throws IOException {

		closeAndroidDriver();

		if (result.getStatus() == ITestResult.FAILURE) {

			((ExtentTest) test.get()).fail(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {

			((ExtentTest) test.get()).skip(result.getThrowable());
		} else {

			((ExtentTest) test.get()).pass("Test passed");
		}
		extent.flush();
	}

	public void defineDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.1.2");
		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\KailasamM\\Desktop\\komoot\\de.komoot.android-1.apk");
		cap.setCapability("appWaitActivity", "de.komoot.android.app.JoinKomootActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		log.info("Appium Capabilities setUp has been completed for the class :" + getClassName());

	}

	public void closeAndroidDriver() {
		driver.quit();
		log.info("Appium Driver has been successfully closed");
	}

	public WebElement waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void clickNativeElementbyXpath(String element) {
		driver.findElement(By.xpath(element)).click();
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public static void scrollTillElementView(WebDriver driver, WebElement element) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("window.scrollBy(0,-50)", "");
	}

	public void switchToWebView() {

		Set<String> contextNames = driver.getContextHandles();
		System.out.println(contextNames.size());
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")) {
				driver.context(contextName);
			}
		}
	}

	public void createReport() {

		htmlReporter = new ExtentHtmlReporter(
				currentWorkingDirectory + "/testReport/" + getClassName() + getTimeStamp() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Appname", "Komoot");
		extent.setSystemInfo("Platform", "Android");
		extent.setSystemInfo("AppVersion", "7.3.5");
		htmlReporter.config().setDocumentTitle("Komoot-Android Test");
		htmlReporter.config().setReportName("Komoot- Android Smoke Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		log.info("Extend Report configuration was successfull");
	}

	public String getClassName() {
		// To get current class Name
		return this.getClass().getSimpleName();
	}

	public String getTimeStamp() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = timestamp.toString().replace(":", "-").replace(".", "-");
		return time;
	}
	
	public void closeReport() {
		extent.flush();
		log.info("Extend Report has been closed");
	}

	// Read test data from the testdata.json
	public String getTestData(String className, String value) throws FileNotFoundException {
		Object obj = parser.parse(new FileReader(fileLocation));
		JsonObject jso = (JsonObject) obj;
		JsonObject innerObject = jso.get(className).getAsJsonObject();
		String data = innerObject.get(value).getAsString();
		log.info("Following data was retrieved from the test data file :" + data);
		return data;
	}
	public void verticalSwipe()
	{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int starty = (int)(height*0.80);
		int endy = (int)(height*0.20);
		driver.swipe(x, starty, x, endy, 500);
		
	}
}
