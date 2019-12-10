# Payment Service

This is a configuration service for a payment method. It can create multiple payment gateways dynamically based on available payment types.

## Getting Started

This is a maven based java application.  

### Prerequisites

* Java 8
* Maven 3.x
* Git

### Installing

Clone this repository on your hard drive and run the following commands.


```
mvn clean install
```

And then run the jar file from Maven Target directory

```
Java -jar payment-service-0.0.1-SNAPSHOT.jar
```

## Running the tests

There are few Unit test and integration tests added in this service.

Run the following for Unit tests

```
mvn clean test
```

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The Spring boot framework used for MVC, Data JPA and Tests.
* [Maven](https://maven.apache.org/) - Dependency Management
* [Java](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - JDK 8
* [H2 Database](https://www.h2database.com/html/main.html) H2 in memory and file based database.


## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Mubasher Usman** - *Initial work* - [Mubasher Usman](https://github.com/mubasherusman)

## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details
