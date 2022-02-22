package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {
	Transaction transaction = new Transaction();
	TransactionRepository transactionRepo = new TransactionRepository();
	
	public List<Transaction> populateData() {
		return transactionRepo.findAll();
	}

	public Transaction findById(Long transactionId) {
		transaction = transactionRepo.findById(transactionId);
		return transaction;
	}
}
