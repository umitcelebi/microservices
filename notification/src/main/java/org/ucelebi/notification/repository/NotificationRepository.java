package org.ucelebi.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ucelebi.notification.model.Notification;

/**
 * @author UMITCELEBI
 */
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
}
