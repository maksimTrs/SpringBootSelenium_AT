# Spring Boot For Automation Testing (UI)

**run tests in parallel:**

`./mvnw clean test`

OR with installed maven:

`mvn clean test -Dbrowser=firefox`

**run tests with profile:**

`mvn clean test -Dspring.profiles.active=qa`

`mvn clean test -Dspring.profiles.active=default -Dbrowser=firefox`


**run allure result**

`mvn allure:serve`