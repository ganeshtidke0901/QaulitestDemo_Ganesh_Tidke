Cucumber BDD Framework

Steps to run the framework
1. Import the project in eclipse as Maven project
2. To run, Right-click on TestNGTest class and select Run as TestNG and provide the dataproviderthreadcount={numberofthreads} as system property in 	testng Runner configuration
3. Execution Html report can be found in forders :CucumberExtend-reports* with timestamp
4. you can test script using maven command 
 
further Improvements:
1. Multiple browsers handling for cross-browser testing
2. Better html reporting
3. updating result in defect management tool
4. if we are running through maven command then we need to pass number parallel thread count in pom file as a part of surefire plugin

