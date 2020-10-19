package com.anz.wholesale.service;

import com.anz.wholesale.model.AnzAccount;
import com.anz.wholesale.model.AnzCustomer;
import com.anz.wholesale.repository.AnzAccountRepository;
import com.anz.wholesale.service.impl.AnzAccountServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class AnzAccountServiceImplTest {

	@Autowired
	private AnzAccountService accountService;

	@MockBean
	private AnzAccountRepository accountRepository;

	@TestConfiguration
	static class contextConfiguration {

		@Bean
		public AnzAccountService accountService() {
			return new AnzAccountServiceImpl();
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

		List<AnzAccount> accounts = new ArrayList<>();
		accounts.add(account);

		Mockito.when(accountRepository.findAllAccountsByCustomerId(customer.getId())).thenReturn(accounts);
	}

	@Test
	public void validCustomerId() {

		Long customerId = 987654l;
		List<AnzAccount> found = accountService.findAllAccountsByCustomerId(customerId);
		Assert.assertEquals(found.get(0).getCustomer().getId(), customerId);

	}

}
