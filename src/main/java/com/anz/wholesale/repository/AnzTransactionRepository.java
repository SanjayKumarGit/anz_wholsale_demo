package com.anz.wholesale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.anz.wholesale.model.AnzTransaction;

import java.util.List;

@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
@Repository
public interface AnzTransactionRepository extends JpaRepository<AnzTransaction, Long> {

	@Query("from Transaction transaction left join fetch transaction.account account left join fetch account.customer customer where account.number=:accountNumber")
	List<AnzTransaction> findAllTransactions(@Param("accountNumber") Long accountNumber);
}
