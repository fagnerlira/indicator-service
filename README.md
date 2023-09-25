## Welcome to the Indicator-Service module

The way to execute all tests is to execute

```mvn clean install```

Run the app
```docker-compose up```

URL Swagger
```http://localhost:8080/swagger-ui/index.html```

Acceptance Criteria 
-
|               Given               |          When           |                                        Then                                         |
|:---------------------------------:|:-----------------------:|:-----------------------------------------------------------------------------------:|
|       param countryCode=BRA       | calling GET /indicators |                it should return http status code 200 with indicators                | 
|       param countryCode=ABW       | calling GET /indicators |                it should return http status code 200 with indicators                | 
| param invalid countryCode=invalid | calling GET /indicators | it should return http status code 400 with message error 'The country code not found' | 








