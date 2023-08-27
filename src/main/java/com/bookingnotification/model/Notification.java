package com.bookingnotification.model;

import com.bookingnotification.model.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Notifications")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Notification {
    private String userId;
    private String message;
    private NotificationType notificationType;
}
