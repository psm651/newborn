package com.levelup.newborn.domain.notification.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "notification")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "notification_id", nullable = false)
    private Long id;

    @Column(name = "sender_member_id", nullable = false)
    private Long senderMemberId;
    @Column(name = "receiver_member_id", nullable = false)
    private Long receiverMemberId;
    @Column(name = "notification_type", nullable = false)
    private NotificationType notificationType;
    @Column(name = "url", nullable = false)
    private String url;
    @Column(name = "notification_title", nullable = false)
    private String title;
    @Column(name = "notification_message", nullable = false)
    private String notificationMessage;
    @CreationTimestamp
    @Column(name = "notification_datetime", nullable = false)
    private LocalDateTime notificationDateTime;
    @Column(name = "notification_read_datetime", nullable = true)
    private LocalDateTime notificationReadDateTime;

    @Builder
    public Notification(Long id, Long senderMemberId, Long receiverMemberId, NotificationType notificationType, String url, String title, String notificationMessage, LocalDateTime notificationDateTime, LocalDateTime notificationReadDateTime) {
        this.id = id;
        this.senderMemberId = senderMemberId;
        this.receiverMemberId = receiverMemberId;
        this.notificationType = notificationType;
        this.url = url;
        this.title = title;
        this.notificationMessage = notificationMessage;
        this.notificationDateTime = notificationDateTime;
        this.notificationReadDateTime = notificationReadDateTime;
    }
}
