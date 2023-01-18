# githubAPI
simple REST service to obtain data from github API 

Endpoints descriptions for user
| HTTP Method | URI |Description |
| --- | --- | --- |
| GET | `/users/{login}/reposHistogram` | Get histogram of the number of characters used in repository names |


## Technologies
* Java 11
* Spring Boot 
* H2 database
* Gradle
* REST Assured


## Run Application
```
$ cd ../githubAPI
$ ./gradlew bootRun
```


## Run tests
```
$ cd ../githubAPI
$ ./gradlew test --tests "TestRestAssured"
```

