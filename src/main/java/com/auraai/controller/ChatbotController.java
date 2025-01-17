package com.auraai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @PostMapping("/ask")
    public String askChatbot(@RequestBody String question) {
        return "Chatbot response for: " + question; // Këtu vendosni logjikën aktuale të chatbot-it
    }
}
