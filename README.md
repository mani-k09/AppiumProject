About Framework:
#################
#This Framework was created based on page factory model
#Test data can be added in "Testdata.json"
#Individual page has been created for each screen in the application

HW Requirement:
##################
Windows 10
Android phone

SW Requirement:
################
1.Andoird SDK 
2.Java ,Maven & Android environment variable setup
3.Appium application v1.6.1
4.Andoird OS Version => 4.2
5.Android device /Android emulator ( if physical device not available)
6.testNG
7.Eclipse IDE
8. komoot.apk (Please find the apk in app folder)

prerequisite to run the scripts:
###################################

1. Active internet connection in the laptop / desktop where you have scripts
2. Active internet connection in the mobile device
3. Location services enabled in mobile device
4. Appium Server should be running

How to run the scripts:
#########################
1. Download / clone the code in your machine.
2. Go to the proecjt home directory in terminal and run "mvn clean install"
3. Test data can be updated in "Testdata.joson", The class name following by other values.
4 .To run Individual Test ,navigate to  "com.komoot.testcases" right click any class an select Run As --> TestNG test
5. Test reports could be found in "\{project_home}\KomootSmokeTest\testReport"

Features to be added in the framework:

1.Start & stop the Appium server using code block
2.Move all the  page objects to common page