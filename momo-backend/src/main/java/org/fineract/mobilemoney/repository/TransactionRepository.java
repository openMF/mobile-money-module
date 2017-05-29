package org.fineract.mobilemoney.repository;

import org.fineract.mobilemoney.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daniel on 2/3/17.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
