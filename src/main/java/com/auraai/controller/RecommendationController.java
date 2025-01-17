package com.auraai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @GetMapping("/{type}")
    public String getRecommendations(@PathVariable String type) {
        return "Recommendations for type: " + type; // Këtu vendosni logjikën aktuale
    }
}
