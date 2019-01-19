package com.moneymoney.app.Transaction.service;

import java.time.LocalDateTime;

public interface TransactionService {

	Double deposit(Integer accountNumber, String transactionDetails, Double currentBalance, Double amount, LocalDateTime transactionDate);

}
