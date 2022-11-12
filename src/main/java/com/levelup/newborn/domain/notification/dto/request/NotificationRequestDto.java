package com.levelup.newborn.domain.notification.dto.request;

import com.levelup.newborn.domain.notification.domain.Notification;
import com.levelup.newborn.domain.notification.domain.NotificationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class NotificationRequestDto {
    private Long senderMemberId;
    private Long receiverMemberId;
    private NotificationType notificationType;
    private String url;
    private String title;
    private String notificationMessage;
    private LocalDateTime notificationDateTime;

    public Notification toEntity() {
        return Notification.builder()
                .senderMemberId(senderMemberId)
                .receiverMemberId(receiverMemberId)
                .url(url)
                .title(title)
                .notificationType(notificationType)
                .notificationMessage(notificationMessage)
                .notificationDateTime(notificationDateTime)
                .build();
    }
}