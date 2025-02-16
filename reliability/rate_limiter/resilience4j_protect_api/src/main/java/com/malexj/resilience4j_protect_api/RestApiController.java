package com.malexj.resilience4j_protect_api;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiController.API_PATH)
public class RestApiController {

  public static final String API_PATH = "/api/info";

  @RateLimiter(name = "apiRestController")
  @GetMapping
  public ResponseEntity<String> info() {
    String info = "Hello World!";
    return ResponseEntity.ok(info);
  }
}
