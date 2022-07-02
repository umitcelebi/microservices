package org.ucelebi.customer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author UMITCELEBI
 */
@SpringBootApplication(
        scanBasePackages = {
                "org.ucelebi.customer",
                "org.ucelebi.amqp"

        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.ucelebi.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class,args);
    }
}
