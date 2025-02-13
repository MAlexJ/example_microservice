package com.malexj.resilience4j_protect_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/api/info")
public class RestApiController {

    @RateLimiter(name = "apiRestController")
    @GetMapping
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("info");
    }
}
