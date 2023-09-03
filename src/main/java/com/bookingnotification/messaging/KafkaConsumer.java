package com.bookingnotification.messaging;

import com.bookingnotification.model.dto.NotificationDTO;
import com.bookingnotification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final NotificationService notificationService;

    @KafkaListener(topics = "notification-topic",
            groupId = "group-id")
    public void consume(NotificationDTO message){
        LOGGER.info(String.format("Message received -> %s", message));
        notificationService.save(message);
    }
}
