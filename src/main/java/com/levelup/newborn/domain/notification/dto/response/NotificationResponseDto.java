package com.levelup.newborn.domain.notification.dto.response;

import com.levelup.newborn.domain.notification.domain.Notification;
import com.levelup.newborn.domain.notification.domain.NotificationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NotificationResponseDto {

    private Long senderMemberId;
    private Long receiverMemberId;
    private NotificationType notificationType;
    private String url;
    private String title;
    private String notificationMessage;
    private LocalDateTime notificationDateTime;
    private LocalDateTime notificationReadDateTime;

    public NotificationResponseDto(Notification notification) {
        this.senderMemberId = notification.getSenderMemberId();
        this.receiverMemberId = notification.getReceiverMemberId();
        this.notificationType = notification.getNotificationType();
        this.url = notification.getUrl();
        this.title = notification.getTitle();
        this.notificationMessage = notification.getNotificationMessage();
        this.notificationDateTime = notification.getNotificationDateTime();
        this.notificationReadDateTime = notification.getNotificationReadDateTime();
    }
}
