package org.mifos.mobile.money.service.Impl;

import org.mifos.mobile.money.domain.Transaction;
import org.mifos.mobile.money.repository.TransactionRepository;
import org.mifos.mobile.money.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by daniel on 2/3/17.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public Collection<Transaction> findAll() {
        Collection<Transaction> allTrans = transactionRepository.findAll();
        return allTrans;
    }

    @Override
    public Transaction findOne(Long id) {
        Transaction trans = transactionRepository.findOne(id);

        if(trans == null) {
            return null;
        }
        return trans;
    }

    @Override
    public Transaction create(Transaction transaction) {
        if(transaction.getId() != null){
            return null;
        }
        Transaction newTrans = transactionRepository.save(transaction);
        return newTrans;
    }

    @Override
    public Transaction update(Transaction transaction) {
        if(transaction.getId() == null){
            return null;
        }
        Transaction upTrans = transactionRepository.save(transaction);
        return upTrans;
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(id);
    }
}
