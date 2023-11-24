package com.modeln.boot.security.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CSRFRestController {
 @GetMapping("/csrf-token")
 public CsrfToken retrieveCsrfToken(HttpServletRequest request) {
   return (CsrfToken) request.getAttribute("_csrf");
 }
}
