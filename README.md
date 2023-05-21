This is master automation framework to automate Web, mobile, desktop and api application using Selenium, Appium, WinAppDriver, RestAssured along with Visual automation using Applitools Eyes and Percy.io, ZAP scan using OWASP ZAP, Accessibility testing using Axe-Core library, Monkey testing using Gremlins, live AI powered dashboard using ELK, Influxdb-Grafana, ReportPortal.io, ML based auto healing using Healenium etc. Docker is used to do the setup for all these tools and running automation test cases.

![image](https://user-images.githubusercontent.com/70449523/228219095-3b8a9237-7e2b-4e46-b021-55cd5599206a.png)


Web Automation:.

Selenium (4.x version) is used to automate the web application along with TestNG for test framework. This is using POM based design and test are running using Docker custom image file. 

Both local and remote executions are handled. Local execution can be done using local browsers as well as BrowserInDocker feature of WebDriverManager. BrowserInDocker feature will provide video recording as well as live execution feature using VNC viewer. Docker must be running in order to use this functionality otherwise test will be executed on local machine in case Docker is down.

Remote execution for web test is implemented using Selenoid, Docker Grid, SeleniunGrid and browserstack. Selenoid will provide video recording as well as out of the box screenshot capture feature without writing any extra code.

-------------------------------------------------
Mobile Automation:

Appium (8.x version) is used to automate the mobile application for Android and iOS platform.

Remote and local execution are handled. Local execution can be executed using connected physical device or using emulators. For remote execution, framework has leveraged Browserstack and SauceLab execution.

--------------------------------------------------.
API automation:

RestAssured is used for api automation. Local and remote can be executed using Docker image. Custom docker image is created to run the test for API automation. Authorization is handled for basic auth, Bearer token and OAuth 2.0.

----------------------------------------------------
Desktop Application Automation:

WinAppDriver is used for desktop application automation. Currently WinAppDriver is supporting 7.6 version of Appium and 3.141.59 version of Selection but this project has latest dependencies for Appium and Selenium. Therefore, Appium and Selenium dependencies has to be downgraded to run the WinAppDriver. All other coding component are working as expected. Notepad is the sample application which is targeted for test case writing in this framework.

----------------------------------------------------
Visual Automation:

Applitools Eyes and Percy.io are used for visual automation. This is covered for both Web application as well as Mobile application. Classic runner which is free for use in Applitools Eyes is used in this framework. Although, Ultra Grid runner is also covered in framework from coding perspective but default configuration is set for Classic runner.

Percy.io is another option provided for visual test automation. In real time project, we have to use of these two tools for visual comparison. Percy.io is pixel based image comparison meanwhile Applitools Eyes is having AI powered algoritham which emulates the human eye visualization.

--------------------------------------------------
Live execution dashboard:

ReportPortal.io, Elastic-Kibana, Influxdb-Grafana are used for visualize the live execution. We can use any one of these three option in real project. We don't have to wait for the complete test execution to see the test results. We can also see the trend of test status which is not possible while using Extent and any other report. We can capture test results for all types of tests like Web, mobile, api and desktop application.

ReportPortal.io is AI/ML powered powerful dashboard to see test results and report analysis. kNN(k-nearest neighbour) ML algoritham is used to identify the reason of  failure for any test failure.

Elastic-Kibana: is easy setup for dashboard where we can push the results in elastic database and then same can be visualize on Kibana in real time. 

Influxdb-Grafana: is also similar setup like ELK. We can have same dashboard for performance as well as automation if we want to use this.

Docker-compose file is attached in project to do the setup for ReportPortal.io, Elastic-Kibana, Influxdb-Grafana.

---------------------------------------------------
Accessibility testing:

Axe-core library is used for accessibility testing. We have targeted web application for this testing. Axe-core is based on all WCAG rules specified under 1.0 and 2.0. We can see the reports for accessibility testing results after execution of respective test cases.

--------------------------------------------------
Monkey Testing:

Gremlins is used for monkey or ad hoc testing. This is one java script which we can inject in web application to test the application without any test cases. It used to have some components called mogwai which used to do click, sendkeys, select type of operations.

--------------------------------------------------
Security Scan:

We are using OWASP ZAP to perform the security test as part of functional pipeline for web application. We are just using the passive scan of ZAP as part of automation and not full security scan so their is no chance of any impact on server. We used to call one proxy of ZAP from selenium/browser which used to handle this scan. OWASP ZAP also provide one colourful html report for test results.

----------------------------------------------------
Auto healing:

Healenium is used for auto locator healing for Web and mobile automation. Healenium is AI powered auto healing of locator using LCS (Longest common subsequence) algoritham to heal the failed locator based on percentage weightage. This will stable the whole pipeline execution for UI test cases.
Docker-compose file is attached in project to do the setup.

----------------------------------------------------
Reporting:

Extent report is used for reporting purpose. Framework will keep all the old reports in project folder and will not delete the older reports automatically to maintain the history. We can also refer testng reports as well which is also getting generated for all the test cases.

----------------------------------------------------
Configuration:

Owner’s library is used for configuration handling where we just need to pass the key to get the values from configuration file.

----------------------------------------------------
Assertions:

AssertJ is used fluent and rich assertions using method chaining in test cases.

----------------------------------------------------
Quality gates:

SonarQube is used for quality code scan. JoCoco can be used in addition with SonarQube for test code coverage. Setup is provided using docker-compose file which is attached in project.

---------------------------------------------
Token-Password encryption:

To store the sensitive information like user credentials, token, api keys etc. are handled using git encrypt which will encrypt the details os that people will not be able to access the details from Github repo.

--------------------------------------------
Test data management:

Apache POI is used to read the data from excel file for test data as well as test cases. Test case execution is handled using excel sheet. Fixture Factory is implemented to pass the data in specified format. Faker library is used to generate the random data in test cases. For API request/responses, json files are used to hold the test data.

-------------------------------------------
Observability:

Docker-Prometheus-Grafana: are used to extract the exposed docker daemon data from docker, change it in metrics format using Prometheus and push it to Grafana for visualization. We can keep a track of container logs as well as status of all the running containers on docker.
Docker-compose file is attached in project to do the setup.

------------------------------------------
Miscellaneous:

Lombok plugin is used in API automation for generating getter/setter/constructor and other details like Sneaky Throw for handling exceptions.

Jackson-databind: is used for serialization and deserialization in API test.

No-exception: is used to declare the exception using functional programming way to remove the try/catch/exception code.

WebDriverManager: is used for web driver management for web automation. 5.x version is also helped us to run the test directly inside docker container.

Monte API : Screen recorder to record the video of test execution without using any external tool like Seleniod, WebDriverManager etc.
