# :crystal_ball: Automated tests for Fakestore API
<p align="center"><img title="fakestore" src="images/fsaLogo.png">
</p>

## :page_with_curl:	Contents
+ [Test cases run](#runner-test-cases-run)
+ [Instruments used](#toolbox-instruments-used)
+ [How to run these tests](#compass-how-to-run-these-tests)
    + [Using command prompt](#using-command-prompt)
    + [Using Jenkins](#using-jenkins)
+ [The final report in Allure Reports](#bar_chart-final-report-in-allure-reports)
+ [Allure TestOps integration](#dart-allure-testops-integration)
+ [Test results](#trophy-test-results)
+ [Jira integration](#ticket-jira-integration)

## :runner: Test cases run
### Automated test cases
- CRUD (create, read, update and delete) products tests
    - [x] Correct addition of a new product
    - [x] Get the list of all products in the database
    - [x] Correct updating of a chosen product
    - [x] Correct deletion of a chosen product
- CRUD (create, read, update and delete) cart tests
    - [x] Correct addition of a new cart
    - [x] Get the list of all carts in the database
    - [x] Correct updating of a chosen cart
    - [x] Correct deletion of a chosen cart

# :toolbox: Instruments used
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="images/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="images/java-logo.svg"></code>
  <code><img width="5%" title="REST Assured" src="images/RestAssured-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="images/gradle-logo.svg "></code>
  <code><img width="5%" title="JUnit5" src="images/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="images/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="images/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="images/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="images/jenkins-logo.svg"></code>
<!--   <code><img width="5%" title="Jira" src="images/jira-logo.svg"></code> -->
  <code><img width="5%" title="Telegram" src="images/Telegram.svg"></code>

</p>

+ **Java** is the primary programming language for this project.
+ **Selenide** framework was used for writing the automated tests.
+ **JUnit 5** is used as a unit testing framework.
+ **Gradle** is used to build the project.
+ **Jenkins** is used for running the tests.
+ **Selenoid** is used to launch browsers in **Docker** containers.
+ **Allure Report** is used to visualize test results.
+ **Telegram API** is used for receiving the final report via Telegram Bot.



# :compass: How to run these tests

### Using command prompt
Please note that the following method will run the tests with the following parameters:
+ Browser: **Google Chrome**
+ Browser version: **112.0**
+ Browser size: **1920x1080**

To run the automated tests:
```bash
gradle clean test
```
To get the report:
```bash
allure serve build/allure-results
```

### Using [Jenkins](https://jenkins.autotests.cloud/job/c18-Ailinyan-MiniProject15/)

Please note that the following method will run the tests with the following parameters:
+ Browser: **Google Chrome**
+ Browser version: **100.0**
+ Browser size: **1920x1080**

To run this test through Jenkins, please use this [job](https://jenkins.autotests.cloud/job/c18-Ailinyan-FakestoreAPI/), specially created for this project.
The environment is set up for the Russian language, to run it please use the button with an :arrow_forward:.
You can see the results via Allure Reports, or use the link to Allure TestOps.

<p  align="center">
<img src="images/jenkins.png" alt="How to run the tests with Jenkins" width="500">
</p>


# :bar_chart: <a name="AllureReports">Final report in [Allure Reports](https://jenkins.autotests.cloud/job/c18-Ailinyan-MiniProject15/)</a>

#### Overview
The main page of the Allure report contains the following information blocks:

>- <code><strong>*ALLURE REPORT*</strong></code> - displays the following info for the given run:
>>- Date and time;
>>- The total number of cases in the given run;
>>- A pie chart indicating the percentage and number of test results: successful, failed, or broken.
>- <code><strong>*TREND*</strong></code> - a line chart that displays the trend of passing tests from build to build
>- <code><strong>*SUITES*</strong></code> - displays the distribution of test results across test suites
>- <code><strong>*CATEGORIES*</strong></code> - displays the distribution of failed tests sorted by defect types
<p align="center">
  <img src="images/allure distributed.PNG" alt="Allure Report" width="650">
</p>

### List of tests with a description of steps and visualization of results
This page presents the standard distribution of the tests run by user stories and test suites.

<p align="center">
  <img src="images/Allure Report steps.png" alt="Allure Report" width="650">
</p>



# :dart: [Allure TestOps](https://allure.autotests.cloud/project/2195/) integration

> [AllureTestOps project link](https://allure.autotests.cloud/project/2195) (access request: admin@qa.guru)

### The main dashboard
<p align="center">
  <img src="images/allureTestOPS dashboards.png" alt="dashboards" width="650">
</p>

### Project's test plans
<p align="center">
  <img src="images/allure_testplans.PNG" alt="Test plans" width="650">
</p>

#### Manual test cases
<p align="center">
  <img src="images/testops_testplan1.PNG" alt="Manual test cases" width="750">
</p>

#### Automated test cases
<p align="center">
  <img src="images/testops_testplan2.PNG" alt="Manual test cases" width="750">
</p>

### All test cases
<p align="center">
  <img src="images/Test cases.png" alt="test cases" width="750">
</p>

### Launches
<p align="center">
  <img src="images/allureTestOPS launches.png" alt="launches" width="650">
</p>

### Launch details
<p align="center">
  <img src="images/allureTestOPS launch.png" alt="launch" width="750">
</p>

### Defects
<p align="center">
  <img src="images/testOps_defect.png" alt="defects" width="750">
</p>



# :trophy: Test results

### Example of a report of an autotest

<p align="center">
  <img src="images/allureTestOPS result demo.png" alt="Results demo" width="750">
</p>

### Telegram notification example
<p align="center">
<img src="images/tlgrm.png" alt="Telegram" width="550">
</p>



# :ticket: [Jira](https://jira.autotests.cloud/) integration

### [Ticket linked with Allure TestOps defect](https://jira.autotests.cloud/browse/HOMEWORK-685)
<p align="center">
  <img src="images/jira-issue.PNG" alt="The defect in Jira" width="750">
</p>

###  [Main page content layout Jira task](https://jira.autotests.cloud/browse/HOMEWORK-677)
<p align="center">
  <img src="images/jira-task-main.PNG" alt="The main page layout task" width="750">
</p>

###  [Search from the main page Jira task](https://jira.autotests.cloud/browse/HOMEWORK-678)
<p align="center">
  <img src="images/jira-task-search.PNG" alt="Search from the main page task" width="750">
</p>