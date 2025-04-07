package com.speedy.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/keep-alive")
public class KeepAliveController {
    @GetMapping
    public ResponseEntity<Object> keepAlive() {
        return ResponseEntity.ok("beep boop");
    }
}
