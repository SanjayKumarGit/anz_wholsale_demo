package com.anz.wholesale.service.impl;

import com.anz.wholesale.model.AnzAccount;
import com.anz.wholesale.repository.AnzAccountRepository;
import com.anz.wholesale.service.AnzAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnzAccountServiceImpl implements AnzAccountService {

    @Autowired
    private AnzAccountRepository accountRepository;

    @Override
    public List<AnzAccount> findAllAccountsByCustomerId(final Long customerId) {
        return accountRepository.findAllAccountsByCustomerId(customerId);
    }
}
