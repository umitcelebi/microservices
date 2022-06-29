package org.ucelebi.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ucelebi.clients.notification.NotificationRequest;
import org.ucelebi.notification.model.Notification;
import org.ucelebi.notification.repository.NotificationRepository;

import java.time.LocalDateTime;

/**
 * @author UMITCELEBI
 */
@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("ucelebi")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
