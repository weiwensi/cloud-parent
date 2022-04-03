package com.tom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test/deploy")
    public ResponseEntity testDockerDeploy() {
        return ResponseEntity.ok(new String("ok"));
    }
}
