package org.ucelebi.fraud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ucelebi.fraud.model.FraudCheckHistory;
import org.ucelebi.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

/**
 * @author UMITCELEBI
 */
@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }
}
