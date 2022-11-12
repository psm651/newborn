package com.levelup.newborn.domain.notification.service;

import com.levelup.newborn.domain.notification.dao.NotificationRepository;
import com.levelup.newborn.domain.notification.domain.Notification;
import com.levelup.newborn.domain.notification.dto.request.NotificationRequestDto;
import com.levelup.newborn.domain.notification.dto.response.NotificationResponseDto;
import com.levelup.newborn.global.dto.ListParamDto;
import com.levelup.newborn.global.dto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public PageResponseDto<NotificationResponseDto> getNotificationList(ListParamDto listParamDto) {
        Page<NotificationResponseDto> notificationList = notificationRepository.findAll(listParamDto.getPageRequest()).map(NotificationResponseDto::new);
        return new PageResponseDto<>(notificationList);
    }

    public NotificationResponseDto saveNotification(NotificationRequestDto notificationRequestDto) {
        System.out.println(notificationRequestDto.toString());
        Notification notification = notificationRequestDto.toEntity();
        notificationRepository.save(notification);
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto(notification);
        return notificationResponseDto;
    }
}
