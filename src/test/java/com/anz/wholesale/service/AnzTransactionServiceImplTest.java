package com.anz.wholesale.service;

import com.anz.wholesale.model.AnzAccount;
import com.anz.wholesale.model.AnzCustomer;
import com.anz.wholesale.model.AnzTransaction;
import com.anz.wholesale.repository.AnzTransactionRepository;
import com.anz.wholesale.service.impl.AnzTransactionServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class AnzTransactionServiceImplTest {

	@Autowired
    private AnzTransactionService transactionService;

    @MockBean
    private AnzTransactionRepository transactionRepository;
	
	@TestConfiguration
    static class contextConfiguration {

        @Bean
        public AnzTransactionService transactionService() {
            return new AnzTransactionServiceImpl();
        }
    }

    @Before
    public void dataSetup() {

        AnzCustomer customer = new AnzCustomer();
        customer.setId(987654l);
        customer.setFirstName("Ashley");
        customer.setLastName("Jade");
        customer.setEmailId("ashley@demo.com");
        customer.setAddress("dummy Address");

        AnzAccount account = new AnzAccount();
        account.setNumber(123456l);
        account.setName("AUDAshleys895");
        account.setAvailableBal(new BigDecimal(8745.55));
        account.setCurrency("AUD");
        account.setType("Current");
        account.setCustomer(customer);

        AnzTransaction transaction = new AnzTransaction();
        transaction.setAccount(account);
        transaction.setCreditAmt(new BigDecimal(5642.25));
        transaction.setDebitCredit("Credit");
        transaction.setValueDate(LocalDate.now());

        List<AnzTransaction> transactions = new ArrayList<>();
        transactions.add(transaction);

        Mockito.when(transactionRepository.findAllTransactions(account.getNumber()))
                .thenReturn(transactions);
    }

    @Test
    public void validAccountNumber() {
       
    	Long acctNumber = 123456l;
        List<AnzTransaction> found = transactionService.findAll(acctNumber);
        Assert.assertEquals(found.get(0).getAccount().getNumber(), acctNumber);
    }
}
