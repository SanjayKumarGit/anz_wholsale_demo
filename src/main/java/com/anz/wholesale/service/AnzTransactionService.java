package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.model.AnzTransaction;

public interface AnzTransactionService {

    List<AnzTransaction> findAll(Long accountNumber);
}
