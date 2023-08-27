package com.bookingnotification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("UserPreferences")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserPreference {
    @Id
    private String userId;
    private boolean bookingRequests;
    private boolean reservationsCanceled;
    private boolean newProfileReviews;
    private boolean newAccomodationReviews;
    private boolean bookingRequestAnswers;
}
