package org.ucelebi.notification.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.ucelebi.clients.notification.NotificationRequest;
import org.ucelebi.notification.service.NotificationService;

/**
 * @author UMITCELEBI
 */
@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest){
        log.info("Comsumed {} from queue",notificationRequest);
        notificationService.send(notificationRequest);
    }
}
