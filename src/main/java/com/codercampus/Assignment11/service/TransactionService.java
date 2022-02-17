package com.codercampus.Assignment11.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	Transaction transaction = new Transaction();

	TransactionRepository transactionRepo = new TransactionRepository();
	
	private Integer transactionId = 1;
	
	public List<Transaction> populateData() {
		return transactionRepo.findAll();
	}

	public Transaction findById(Integer transactionId) {
		transaction = transactionRepo.findById(transactionId);
		return transaction;
	}
}
