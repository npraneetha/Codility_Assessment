# Codility_Assessment



Used selenium Webdriver and Java to Automate this application.
Have used Intellij as my IDE to build the Cucumber framework using Gherkin language.

Need to install few jars and drivers to execute this:

1. Java jdk 1.8
2. Intellij community 2021 version
3. As its maven project all the dependencies are on pom xml and its from repo.
4. Install Apache-maven 3.6.3
5. Install Seleniun-webdriver 3.14.59 version
6. I have installed the chrome driver 

I have created feature file using the below acceptance criteria:

This application displays all the textile products for shopping

**Features**
The requirments was to write two scenarios:
1.Buy a T-shirt and verify the Order history
2.To edit First Name in Account and save

I have written only the happy path scenarios, we can also have multiple Negative scenarios as well. 

Validations on all the Input fields
-Invalid values
-Special characters
-Empty spaces in the values
-Mandatory fields

The tests can be run in multiple Browser like
Firefox
Chrome
Safari
IE and Edge
 Requite would be the respective drivers to be installed.



I have created **Stepdefs** file under a package com.test.praneetha  as stepdef.java

Created a utility file called **utilities** to launch the browser and exit .

Have created **testRunner** to execute the tests using Junit and Cucumber tests

Implemented Hooks for cucumber reports.

Run The test runner as it is ,As the scenarios are tagged to the runner.

Can show a demo/ execution if required.




