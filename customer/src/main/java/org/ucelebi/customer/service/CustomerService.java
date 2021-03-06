package org.ucelebi.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ucelebi.amqp.RabbitMQMessageProducer;
import org.ucelebi.clients.fraud.FraudCheckResponse;
import org.ucelebi.clients.fraud.FraudClient;
import org.ucelebi.clients.notification.NotificationRequest;
import org.ucelebi.customer.CustomerRegistrationRequest;
import org.ucelebi.customer.model.Customer;
import org.ucelebi.customer.repository.CustomerRepository;

/**
 * @author UMITCELEBI
 */
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if email valid
        customerRepository.saveAndFlush(customer);
        //todo: check if email not taken

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, Welcome to microservices...", customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }
}
