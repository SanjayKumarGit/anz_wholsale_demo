package com.anz.wholesale.service;

import java.util.List;

import com.anz.wholesale.model.AnzAccount;

public interface AnzAccountService {

    List<AnzAccount> findAllAccountsByCustomerId(final Long customerId);
}
