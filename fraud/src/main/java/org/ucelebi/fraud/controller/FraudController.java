package org.ucelebi.fraud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ucelebi.clients.fraud.FraudCheckResponse;
import org.ucelebi.fraud.service.FraudCheckService;

/**
 * @author UMITCELEBI
 */
@RestController
@RequestMapping("/api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);

        log.info("fraud check request for customer: {}",customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
