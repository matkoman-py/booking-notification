package com.bookingnotification.repository;

import com.bookingnotification.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    @Query(value="{userId:'?0'}")
    List<Notification> findAll(String userId);
}
