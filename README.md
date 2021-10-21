Cucumber BDD Framework (Selenium + maven+ page object model)

This is automation framework based on BDD using cucumber tool and selenium to automate the web application


Steps to run the framework
1. Import the project in eclipse as Maven project
2. To run, select Run as TestNG and provide the dataproviderthreadcount={numberofthreads} as system property in 	testng run configuration under VM argument section  in eclise Run configuration to run feature scenarios in parallel 
3. run the Testng config from Run Configurations
4.OR  you can test script using maven command
   mvn test -Ddataproviderthreadcount=1
5.Script execution Html report can be found in folders :CucumberExtend-reports* with timestamp
 
further Improvements:
1. Multiple browsers handling for cross-browser testing
2. Better html reporting
3. updating result in defect management tool
4. if we are running through maven command then we need to pass number parallel thread count in pom file as a part of surefire plugin instead of passing       from command prompt 
5. need to implement the logic to pass the data between scenario steps using ThreadLocal class to run the scenarios in parallel


Execution Report Image:Attached in repo Capture*.PNG

![Capture1](https://user-images.githubusercontent.com/35453017/138347778-5dde4eac-48f6-4b3e-952b-8cd5283e834c.PNG)

![Capture2](https://user-images.githubusercontent.com/35453017/138347832-198ddeb5-e646-405c-bcf4-1548464eb5d4.PNG)
![Capture3](https://user-images.githubusercontent.com/35453017/138347842-9557a659-321c-489e-b3c2-eba4637ee109.PNG)
![Capture4](https://user-images.githubusercontent.com/35453017/138347848-6411c083-b8a0-4d95-851e-6fe046d8b4fa.PNG)
![Capture5](https://user-images.githubusercontent.com/35453017/138347860-e35c0ea7-9f9b-4e88-bfda-6cbd817353b2.PNG)
![Capture6](https://user-images.githubusercontent.com/35453017/138347865-20d37a43-4586-4f14-b8a2-a1cf31f70988.PNG)
