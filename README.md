ReadMe Notes


***Summary:***
The following notes explain the automation strategy for Walmart end to end e-commerce transaction

***Problem Statement:***
Automate an end to end user e-commerce transaction flow using any open source tool for a website with an existing customer on chrome or safari browser

***Technology Used:***

1) Java – 1.7

2) Selenium Webdriver – 2.45

3) TestNG

4) Apache-POI – For using data driven approach

5) Log4j utility – For Logging purposes


***Framework Used:***

1) Page Object Pattern (POP)

2) Data driven model

3) Modular Driven model

4) Custom Exception Handling model


***Solution:***

***1) Creating Page Objects***

a) Created Walmart_java page object class under pageObjects package

b) In this class, identified all the web elements which will be used for performing the E2E transaction flow for Walmart


***2) Create Module Functions***

Created modular functions needed to accomplish the end-to-end transaction flow

a) searchItem

b) addItemToCart

c) login

d) proceedToCheckout

e) verifyPaymentDetails

f) removeItemFromCart

g) logout


***3) Create Testscript***

Created testscript using testNG annotations with 3 methods overridden from the Testcase class (abstract class defined in runManager package):

a) Prescript – This method will hold the prerequisites before you jump into the actual test.  For e.g. you can open a browser, load the testdata, and goto the target url, etc. in this method

b) Main – This method contains the meat of your logic, i.e. how I will perform the e2e transaction flow.  I will simply call the actions defined in the Walmart projectModule.  So, I won’t have write all the complex code pertaining to Selenium in this file, thus making it extremely readable and easy to use

c) postScript – This method contains any logic which one wants to execute as a post condition.  For e.g., this method could contain actions like browser closing, database connections cleanup, bringing back the test to the base state (so the following tests are not impacted by this one), etc


***4)	Other Framework components***

Other framework components include the following:

***Utility Folder***

Utility consists of the following class files with their respective methods:

a) ***Excel Utils.java*** : This file has been made with the intention to provide data driven ability to the framework.  It uses the apache-poi library and its associated methods.  Following are the methods used in this class:

Excel_Utils – Constructor which provides the connection to the intended excel testdata 

       i)	Arguments – Path (String) – Path of the testdata sheet to load; Sheetname (String) – The sheet number of the                   excel sheet to connect to

       ii)	Return type – Object of type Excel_Utils

       iii)	Exceptions – IOStream exception related to file handling



getCellData – This method provides the value of the column which has been requested
          
          i)	Arguments – obj (Object) – The testScript class which is loaded for retrieval of test data; Field (String) – the               column for which the value needs to be retrieved from the test data

          ii) Return type – String (value of the specified column)

          iii)	Exceptions – IllegalStateException, Unknown exceptions
                In this method, I first fetch the header row of the testdata.  For e.g. I need to fetch the value for the URL                  column.  I iterate through this first header row, and figure out at which column index URL column is present.                  I store that column index value in a variable, and break from the loop as soon as I get where the target column is present
                Now I need to fetch the row where the value of this URL column is.  I iterate through the rows until I find the row which has the name of the testscript class.  As soon as I get that row index, I are now sure that I have bound to the correct row to fetch the URL column (or any target column)
                Finally, I fetch the cell data using the row and column index from the bound Excel worksheet, and return it to the calling function
  
  
  ***b) TestData Loader*** – This is a static class which loads the testdata file, and returns an object of type Excel_Utils, so that Ican call the methods of Excel_Utils class and get the test data for any column I need.  Following class method is used in this:

loadTestData – loads the testdata file, and returns object of type Excel_Utils to the caller method

        i)	Arguments – obj (Object)	- The testscript class for which the testdata needs to be loaded
   
       ii)	Return type – Excel_Utils – Object of type Excel_Utils
   
       iii)	Exceptions – Unknown


***c) Custom Exception (Element_Not_Found_Exception)*** – The idea behind creating custom exceptions is to provide the user ease of access to troubleshoot his test script.  If the custom exceptions are not made, the user would have to deal with high level technical exceptions throd by the tool which will be much cumbersome to analyze/troubleshoot.  Following custom exception has been made:

Element_Not_Found_Exception – This is an exception which will be thrown when I catch a Selenium specific exception of type “NoSuchElementException”

         i) Arguments – exception_msg (String) – A very intuitive user friendly message to be provided (in the report) to the user when a particular web element is not found; e (Exception) – The complete stack trace of the error

         ii) Return Type – none

         iii)	Exceptions – Unknown
              
              This method Is thrown in the pageObject class for every web element so as to ensure consistency whenever a particular web element is not found on the page
              

d) ***Logger (Log.java) ***– This class contains methods for all log levels which will be used to log in a flat file.  It uses log4j utility to perform logging.  Logging can be done at any stage of your script/framework code to provide a more verbose output to the user who is watching the console.  It consists of the following methods

        i) info – Logs basic information logs on the console

        ii) debug – Logs debug type logs on the console.  Is useful for the developers to troubleshoot their code base

        iii) warn – Logs warning type logs on the console.  Use it when you need to tell that a certain method would be deprecated in future releases, etc

         iv) error – Logs error on the console, helping with troubleshooting script or framework level code     
         
        v) fatal – Logs fatal errors on the console like service down, browser crash, etc.


e) ***	Project Constants (Project_Constants.java)*** – This static class contains project specific constants which will remain static throughout their lifetime.  In our project, the location of the drivers (chromedriver, iedriver, etc) have been made constant and will never change.

f)	***Reusable Common Actions (Common_Actions.java) ***– This class contains methods which are reusable across various web applications.  Consists of the following methods:

1) openBrowser

2) launchApplication

3) closeBrowser

It could consist of a lot more methods which one thinks can be reused by multiple projects.


***Installation Instructions***

1) Installing TestNG

http://www.softwaretestingmentor.com/selenium-tutorials/how-to-setup-testng-with-selenium-webdriver-in-eclipse-ide/

2) Installing Selenium Webdriver
    
    Download selenium webdriver jar files from http://www.seleniumhq.org/download/, and extract it to any place in your hard drive

    Add the java project for Walmart on your Eclipse
 
    Right click on the Project Root Folder and click on Build Path – >Configure Build Path

    Click on the Libraries tab
 
    Click on button “Add external Jars”

    Browse to the location where you have extracted the selenium server jar and click open
 
    Click on OK. You should be able to see selenium jars in the Referenced Libraries

    Installing Apache-POI (for data driven approach)
 
    Download apache poi jar files from http://poi.apache.org/

    Add the jars to your build path using the same procedure as above (that was used for Selenium Webdriver)


3) Installing log4j (for Logger)

    Download log4j jar file from http://logging.apache.org/
    
    Add the jars to your build path using the same procedure as above (that was used for Selenium Webdriver)


4) Installing Drivers

   
     Download the latest version of chromedriver from the following location, https://sites.google.com/a/chromium.org/chromedriver/downloads, and add it to your drivers folder in your root Project folder
and save it in drivers directory

***Code Execution Workflow***

This section explains how this framework would work end to end (with the assumption that the user has written pageObject class, projectModule and testScript):

*Prescript Explanation*

  Trigger point – Right click your testScript (in this case, EWindow_Shopping.java), and click on Run As > TestNG Test

  At this point, all your libraries (which have been imported under this testScript class) are loaded

  TestNG then triggers the @BeforeMethod annotation.  Under this annotation, I have written the prescript method (overridden from runManager/Testcase.java).  This method will get executed first

  In this method, firstly the testdata is loaded for this EWindow_Shopping class, and the code execution goes to TestData_Loader.loadTestData class method.  This method loads the testdata file for this class, creates an Excel_Utils object (execution goes to Excel_Utils.java constructor), and returns it to the EWindow_Shopping class in the “data” variable

  With this data (Excel_Utils object), I call the getCellData method to access URL and Browser fields.  Execution goes to this method defined under Excel_Utils.java file.  It fetches the data for these columns, and returns to the caller function as type String.  Execution returns back to EWindow_Shopping class with the information of URL and browser stored in respective String variables

  Next I launch the browser using Common_Actions.openBrowser class method.  Execution goes to the openBrowser method of the Common_Actions class.  In this method, I create an object of ChromeDriver class, and return it as a driver object of type WebDriver.  This driver object is now available on EWindow_Shopping class

  Next I navigate to the Walmart url using the driver object and Selenium Webdriver specific “get” method



***Main explanation***

Now, after execution of prescript method, TestNG executes its next annotation which is @Test. I have defined main method (overridden from runManager/Testcase.java), which works as follows:


  In this method, I get the search item from the testdata using getCellData method

  Then I call all the respective methods defined in projectModules/Walmart_Actions.java class
  
  Finally, after performing the E2E transaction flow on Walmart, I logout
  
  
  
***PostScript explanation***

Now, after execution of prescript method, TestNG executes its next annotation which is @AfterMethod.  I have defined postScript method (overridden from runManager/Testcase.java), which works as follows:
•	In this method, I can execute Common_Actions.closeBrowser method to trigger the exit point of the script.

After this, TestNG will have no more annotation to run, and hence it will finish execution, and generate its report on the console.


***Time constraint***: If I had more time, I would have implemented the mobile solution.
Also, I would have added more logger capabilities. 

***Issues***: There is a problem with the mobile.walmart.com site. Sometimes it redirects to walmart.com. Just wanted to highlight this issue.


