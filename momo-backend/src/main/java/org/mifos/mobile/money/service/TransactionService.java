package org.mifos.mobile.money.service;

import org.mifos.mobile.money.domain.Transaction;

import java.util.Collection;

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
