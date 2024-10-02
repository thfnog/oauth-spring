package com.example.oauth.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {

  @GetMapping("/public")
  public ResponseEntity<String> publicEndpoint() {
    return ResponseEntity.ok("This endpoint is public!");
  }

  @GetMapping("/private")
  public ResponseEntity<String> privateEndpoint() {
    return ResponseEntity.ok("You access to a private endpoint!");
  }
}
