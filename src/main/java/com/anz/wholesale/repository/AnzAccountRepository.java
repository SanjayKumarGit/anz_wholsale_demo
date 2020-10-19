package com.anz.wholesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anz.wholesale.model.AnzAccount;

import java.util.List;

@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
@Repository
public interface AnzAccountRepository extends JpaRepository<AnzAccount, Long> {

	@Query("from Account account left join account.customer customer where customer.id=:customerId")
	List<AnzAccount> findAllAccountsByCustomerId(@Param("customerId") Long customerId);

	AnzAccount findByName(String name);
}
