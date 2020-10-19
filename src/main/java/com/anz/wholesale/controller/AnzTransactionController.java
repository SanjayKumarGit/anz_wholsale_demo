package com.anz.wholesale.controller;

import com.anz.wholesale.model.AnzTransaction;
import com.anz.wholesale.service.AnzTransactionService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/transaction")
public class AnzTransactionController {

    @Autowired
    private AnzTransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET, path = "/getalltransactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnzTransaction> getAllTransactions(@RequestParam Long accountNumber) throws ResponseStatusException {

        List<AnzTransaction> transactions = null;

        try {
            transactions = transactionService.findAll(accountNumber);
        } catch (Exception e) {
            log.error(String.format("Error occurred while fetching transactions for account number: "+ accountNumber));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured while fetching transactions");
        }
        return transactions;
    }

}
