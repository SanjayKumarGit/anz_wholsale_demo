package com.anz.wholesale.service.impl;

import com.anz.wholesale.model.AnzTransaction;
import com.anz.wholesale.repository.AnzTransactionRepository;
import com.anz.wholesale.service.AnzTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnzTransactionServiceImpl implements AnzTransactionService {

    @Autowired
    private AnzTransactionRepository transactionRepository;

    @Override
    public List<AnzTransaction> findAll(Long accountNumber) {
        return transactionRepository.findAllTransactions(accountNumber);
    }
}
