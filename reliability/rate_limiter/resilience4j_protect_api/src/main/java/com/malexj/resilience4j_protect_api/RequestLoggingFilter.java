package com.malexj.resilience4j_protect_api;

import static com.malexj.resilience4j_protect_api.RestApiController.API_PATH;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * A request logging filter that logs details about each incoming HTTP request. This filter runs
 * once per request and logs essential request metadata.
 */
@Slf4j
public class RequestLoggingFilter extends OncePerRequestFilter {

  /**
   * Logs request details including URI, URL, HTTP method, and headers.
   *
   * @param request the HTTP request
   * @param response the HTTP response
   * @param filterChain the filter chain
   * @throws ServletException if an error occurs during request processing
   * @throws IOException if an I/O error occurs during request processing
   */
  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // Incoming request: GET /api/info
    Optional.ofNullable(request.getRequestURI())
        .filter(uri -> uri.equalsIgnoreCase(API_PATH))
        .ifPresent(
            uri -> {
              log.info(
                  "Incoming request: {} {} | IP: {}",
                  request.getMethod(),
                  uri,
                  getClientIp(request));
              log.info("Full URL: {}", request.getRequestURL());

              // Log request headers
              Enumeration<String> headerNames = request.getHeaderNames();
              if (headerNames.hasMoreElements()) {
                StringBuilder headers = new StringBuilder();
                while (headerNames.hasMoreElements()) {
                  String headerName = headerNames.nextElement();
                  headers
                      .append(headerName)
                      .append(": ")
                      .append(request.getHeader(headerName))
                      .append("; ");
                }
                log.info("Request Headers: {}", headers);
              }
            });

    filterChain.doFilter(request, response);
  }

  /**
   * Retrieves the real client IP address, considering possible proxies.
   *
   * @param request the HTTP request
   * @return the client's IP address
   */
  private String getClientIp(HttpServletRequest request) {
    String ip = request.getHeader("X-Forwarded-For"); // Handle proxy cases
    if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr(); // Fallback
    }
    return ip;
  }
}
