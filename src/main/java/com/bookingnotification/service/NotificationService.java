package com.bookingnotification.service;

import com.bookingnotification.model.Notification;
import com.bookingnotification.model.UserPreference;
import com.bookingnotification.model.dto.NotificationDTO;
import com.bookingnotification.model.enums.NotificationType;
import com.bookingnotification.repository.NotificationRepository;
import com.bookingnotification.repository.UserPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserPreferenceRepository userPreferenceRepository;

    public void save(NotificationDTO notificationDTO){
        notificationRepository.save(
                Notification.builder()
                        .notificationType(notificationDTO.getNotificationType())
                        .userId(notificationDTO.getUserId())
                        .message(notificationDTO.getMessage())
                        .build()
        );
    }

    public List<Notification> getAllForUser(String userId){
        List<Notification> allNotifications = notificationRepository.findAll(userId);
        Optional<UserPreference> optionalUserPreference = userPreferenceRepository.findByUserId(userId);

        if(optionalUserPreference.isPresent()){
            List<Notification> filtered = new ArrayList<>();
            UserPreference userPreference = optionalUserPreference.get();

            for(Notification notification : allNotifications){
                if(notification.getNotificationType().equals(NotificationType.BOOKING_REQUEST)
                        && userPreference.isBookingRequests()){
                    filtered.add(notification);
                }
                else if(notification.getNotificationType().equals(NotificationType.BOOKING_REQUEST_ANSWER)
                        && userPreference.isBookingRequestAnswers()){
                    filtered.add(notification);
                }
                else if(notification.getNotificationType().equals(NotificationType.NEW_ACCOMODATION_REVIEW)
                        && userPreference.isNewAccomodationReviews()){
                    filtered.add(notification);
                }
                else if(notification.getNotificationType().equals(NotificationType.NEW_PROFILE_REVIEW)
                        && userPreference.isNewProfileReviews()){
                    filtered.add(notification);
                }
                else if(notification.getNotificationType().equals(NotificationType.RESERVATION_CANCELED)
                        && userPreference.isReservationsCanceled()){
                    filtered.add(notification);
                }
            }

            return filtered;
        }

        return allNotifications;
    }

    public UserPreference createOrUpdateUserPreference(UserPreference userPreference) {
        return userPreferenceRepository.save(userPreference);
    }
}
