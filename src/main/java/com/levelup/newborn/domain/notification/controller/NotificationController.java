package com.levelup.newborn.domain.notification.controller;

import com.levelup.newborn.domain.notification.dto.request.NotificationRequestDto;
import com.levelup.newborn.domain.notification.dto.response.NotificationResponseDto;
import com.levelup.newborn.domain.notification.service.NotificationService;
import com.levelup.newborn.global.dto.ListParamDto;
import com.levelup.newborn.global.dto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {
    private final NotificationService notificationService;

    @GetMapping()
    public PageResponseDto<NotificationResponseDto> getNotificationList(@ModelAttribute ListParamDto listParamDto) {
        return notificationService.getNotificationList(listParamDto);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<MemberResponseDto> getMember(@PathVariable final Long id) {
//        return new ResponseEntity<>(notificationService.getNotification(id), HttpStatus.ACCEPTED);
//    }

    @PostMapping()
    public ResponseEntity<NotificationResponseDto> saveNotification(@RequestBody final NotificationRequestDto notificationRequestDto) {
        return new ResponseEntity<>(notificationService.saveNotification(notificationRequestDto), HttpStatus.CREATED);
    }
}
