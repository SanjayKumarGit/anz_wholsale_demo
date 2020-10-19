package com.anz.wholesale.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.anz.wholesale.model.AnzAccount;
import com.anz.wholesale.service.AnzAccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/account")
public class AnzAccountController {

    @Autowired
    private AnzAccountService accountService;

    @RequestMapping(method = RequestMethod.GET, path = "/getallaccounts", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AnzAccount> getAllAccounts(@RequestParam(value = "customerId") Long customerId) throws ResponseStatusException {

        List<AnzAccount> accounts = null;

        try {
            accounts = accountService.findAllAccountsByCustomerId(customerId);

        } catch (Exception e) {
            log.error(String.format("Error occurred while fetching accounts for customer ID: " + customerId));
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occured while fetching accounts ");
        }
        return accounts;
    }

}
