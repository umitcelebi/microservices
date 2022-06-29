package org.ucelebi.clients.notification;

/**
 * @author UMITCELEBI
 */
public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
