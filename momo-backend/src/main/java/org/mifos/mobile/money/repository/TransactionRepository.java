package org.mifos.mobile.money.repository;

import org.mifos.mobile.money.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daniel on 2/3/17.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
