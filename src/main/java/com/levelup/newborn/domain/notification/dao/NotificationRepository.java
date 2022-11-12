package com.levelup.newborn.domain.notification.dao;

import com.levelup.newborn.domain.notification.domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Page<Notification> findAll(Pageable pageable);
}
