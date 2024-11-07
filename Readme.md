<h1>Test automation for a Fintech API using rest assured  .</h1>


<h3>Hello and welcome to My project. :wave: </h3>


This is a simple test automation framework using rest assured, in order to test the data and functionality, of a fintech endpoint This is a maven project and should be able to run on any machine having Java 17+ and maven.

The libs used to create this framework are:
- Rest Assured.
- Extent report.


Main challenges of automating tests for a fintech is that there are too much data, and too many variable property names in the response.

1. Property names in Json response are usually dates and the Schema changes every 1 minute or so, as well as the dates must be consistent in order for the frontend to be able to use them in graph, so consistent dates differences should be tested and verified.
2. With each update to the market events or prices, the code must be tested that it can deal with the already existing stock prices, example stock splits any date where the markets had to close.

Those challenges make the ability to create automation test scenarios for fintech hectic and unreliable and the need for repetitive manual tests also increases the time to delivery and the cost for the company. 

How to fix:
1. Use a relative schema that verifies the responses, for each kind of response use pattern functionality on the JSON schema in order to get the data and its format.
2. Applying OOP principals for the test cases, use objects that will contain the needed tests, example test the time difference between each data point.
3. Create independent tests for each feature can also use Cucumber to add the features needed for each endpoint.
4. Remember that APIs are all about the data they provide a simple 200 ok is not a test, the data should be analyzed and verified before it goes to the end user.

How to run:  pull the code and run the following in the terminal
```Bash 
mvn clean package -DskipTests
 ```
<h5> then  Run </h5>


``` Bash
cd target/built-resources
```
```Bash
java -cp 'libs/*' org.testng.TestNG test-suites/SmokeTestStocks.xml
```
<h3>Important notice : that is a work in progress still, so it should be continued.
Attached is a reporting sample<h3>