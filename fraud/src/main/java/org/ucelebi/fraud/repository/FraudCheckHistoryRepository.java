package org.ucelebi.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ucelebi.fraud.model.FraudCheckHistory;

/**
 * @author UMITCELEBI
 */
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory,Integer> {
}
