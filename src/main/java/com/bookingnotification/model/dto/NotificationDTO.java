package com.bookingnotification.model.dto;

import com.bookingnotification.model.enums.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationDTO {
    private String userId;
    private String message;
    private NotificationType notificationType;
}
