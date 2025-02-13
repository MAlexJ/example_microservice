### How to implement Rate Limiting in Spring Boot

#### Resilience4j

`Resilience4j` — General fault tolerance (circuit breaker, retries, bulkhead, etc.), including rate limiting.
Can limit at a `per-service` level using annotations and integration with Spring Boot.
Highly granular control over rate limits (per API, service, etc.).
`In-memory rate limiting `- no distributed support out-of-the-box.
Easy to use with Spring Boot annotations.

link: https://medium.com/@ketan.patel_46870/how-to-implement-rate-limiting-in-spring-boot-61a4e9924f6e

#### Info and Spring boot: Getting Started

link: https://resilience4j.readme.io/docs/getting-started-3

Add dependencies:

```
dependencies {
  implementation "io.github.resilience4j:resilience4j-spring-boot3:${resilience4jVersion}"
  implementation "org.springframework.boot:spring-boot-starter-actuator"
  implementation "org.springframework.boot:spring-boot-starter-aop"
}
```

Configuration application.yaml

```
resilience4j.ratelimiter:
    instances:
        my-api-controller:
            limitForPeriod: 10
            limitRefreshPeriod: 1s
            timeoutDuration: 0
            registerHealthIndicator: true
            eventConsumerBufferSize: 100
```

* `timeoutDuration` : 5 [s]  
  The default wait time a thread waits for a permission

* `limitRefreshPeriod` : 500 [ns]    
  The period of a limit refresh. After each period the rate limiter sets its permissions
  count back to the limitForPeriod value

* `limitForPeriod` : 50
  The number of permissions available during one limit refresh period

Exception handler:

```
import io.github.resilience4j.ratelimiter.RequestNotPermitted;

@RestControllerAdvice
public class RateLimitExceptionHandler {

    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<String> handleRateLimitExceeded(RequestNotPermitted exception) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Rate limit exceeded. Try again later.");
    }
}
```
