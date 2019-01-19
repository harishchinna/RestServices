package com.moneymoney.app.Transaction.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moneymoney.app.Transaction.Details.Transaction;
import com.moneymoney.app.Transaction.Details.TransactionType;
import com.moneymoney.app.Transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepository repository;
	
	
	public Double deposit(Integer accountNumber, String transactionDetails, Double currentBalance, Double amount, LocalDateTime transactionDate) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(accountNumber);
		transaction.setAmount(amount);
		currentBalance +=amount;
		transaction.setCurrentBalance(currentBalance);
		transaction.setTransactionDetails("ATM");
		transaction.setTransactionDate(transactionDate);
		transaction.setTransactionType(TransactionType.DEPOSIT);
		Double updatedCurrentBalance=repository.save(transaction).getCurrentBalance();
		return updatedCurrentBalance;
	}
	
}
