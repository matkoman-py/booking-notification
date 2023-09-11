package com.bookingnotification.controller;

import com.bookingnotification.model.Notification;
import com.bookingnotification.model.UserPreference;
import com.bookingnotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    @GetMapping("/{userId}")
    public ResponseEntity<List<Notification>> getAllForUser(@PathVariable String userId) {
        return ResponseEntity.ok(notificationService.getAllForUser(userId));
    }

    @PostMapping("/user-preferences")
    public ResponseEntity<UserPreference> createOrUpdateUserPreference(@RequestBody UserPreference userPreference) {
        return ResponseEntity.ok(notificationService.createOrUpdateUserPreference(userPreference));
    }

    @GetMapping("/user-preferences/{userId}")
    public ResponseEntity<UserPreference> getUserPreference(@PathVariable String userId) {
        return ResponseEntity.ok(notificationService.getUserPreference(userId));
    }
}
