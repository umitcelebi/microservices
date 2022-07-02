package org.ucelebi.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author UMITCELEBI
 */
@SpringBootApplication(
        scanBasePackages = {
                "org.ucelebi.amqp",
                "org.ucelebi.notification"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }
}
