Rabobank Customer Statement Processor 

Technologies Used:
------------------
Spring Boot
Java 

Project Description
-------------------

Controller
----------
RecordController is the controller for our application which handles the POST request and return the RecordResponse.

Service
-------
RecordService is the service interface and RecordServiceImpl consist of the implementation of the RecordService interface.
We have a saveRecord() which will save the record.
First it will check whether the reference is already present or not.If the reference is already present then an errorRecord object will be created with result AS DUPLICATE_REFERENCE. AFter that we have scenario.
1 - Incorrect End Balance : If the balance is incorrect then errorRecords will display like :
	"result" : "DUPLICATE_REFERENCE_INCORRECT_END_BALANCE",
    "errorRecord": [..error message]
2 - Correct End Balance : If the end balance is correct, then the error will be like.
	"result" : " DUPLICATE_REFERENCE",
	"errorRecord": [..error message]
	
Secondly, if the reference is not present. Then we again have 2 scenarios.

1 - Incorrect End Balance - If the end balance is incorrect then errorRecords will disply like:
	"result" : "INCORRECT_END_BALANCE",
    "errorRecord": [..error message]
2 - Correct End Balance - If the end balance is correct, then the record will be inserted and response returned is.
	"result" : "Successfull",
    "errorRecord": []
	
Running of the application
--------------------------

In order to run the application, we need to maven clean install the source. So, using the command below:

mvn clean install

a jar will be created inside the /target folder. We can directly run the jar file and the build in tomcat server will be up on port specified inside the properties file.

Using postman request 
POST <host>:<port>/customerStatement along with the data sent in the body, a response will be generated back along with the status code.


	