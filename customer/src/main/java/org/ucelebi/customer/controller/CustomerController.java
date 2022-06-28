package org.ucelebi.customer.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ucelebi.customer.CustomerRegistrationRequest;
import org.ucelebi.customer.service.CustomerService;

/**
 * @author UMITCELEBI
 */
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        log.info("new customer registration {}",customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
