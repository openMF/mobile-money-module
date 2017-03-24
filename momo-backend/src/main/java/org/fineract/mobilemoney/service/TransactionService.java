package org.fineract.mobilemoney.service;

import java.util.Collection;

import org.fineract.mobilemoney.domain.Transaction;

/**
 * Created by daniel on 2/3/17.
 */

public interface TransactionService {

    Collection<Transaction> findAll();

    Transaction findOne(Long id);

    Transaction create(Transaction transaction);

    Transaction update(Transaction transaction);

    void delete(Long id);
}
