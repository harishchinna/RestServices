package com.moneymoney.app.Transaction.resource;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.moneymoney.app.Transaction.Details.Transaction;
import com.moneymoney.app.Transaction.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {
	
	@Autowired
	private TransactionService service;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping
	public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction)
	{
		/* System.out.println("welcome"); */
		ResponseEntity<Double> entity = restTemplate.getForEntity("http://localhost:1122/accounts/"+transaction.getAccountNumber() +"/balance", Double.class);
		/* System.out.println(entity); */
		Double CurrentBalance=entity.getBody();
		transaction.getTransactionDate();
		Double updatedBalance = service.deposit(transaction.getAccountNumber(),transaction.getTransactionDetails(),CurrentBalance , transaction.getAmount(),LocalDateTime.now());
		System.out.println(updatedBalance);
		restTemplate.put("http://localhost:1122/accounts/"+transaction.getAccountNumber()+"?currentBalance="+updatedBalance, null);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
