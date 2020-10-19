package com.anz.wholesale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@Data
public class AnzTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	@Column
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_number", referencedColumnName = "number")
	private AnzAccount account;

	@Column(name = "debit_amt", precision = 12, scale = 2)
	private BigDecimal debitAmt;

	@Column(name = "credit_amt", precision = 12, scale = 2)
	private BigDecimal creditAmt;

	@Column(name = "debit_credit")
	@NotNull
	private String debitCredit;

	@Column(name = "transaction_narrative")
	private String transNarative;
	
	@Column(name = "value_date")
	@NotNull
	private LocalDate valueDate;

}
