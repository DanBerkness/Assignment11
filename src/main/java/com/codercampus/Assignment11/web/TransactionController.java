package com.codercampus.Assignment11.web;


import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	TransactionService transactionService = new TransactionService();
	
	Transaction transaction = new Transaction();

	@GetMapping("/transactions")
	public String generateTransactions(ModelMap model) {
		List<Transaction> allTransactions = transactionService.populateData();
		 model.put("transactions", allTransactions);
		
		return "transactions";
	}
	
	@GetMapping("/transactions/{transactionId}")
	public String getSingularTransactionData (ModelMap model, @PathVariable Long transactionId) {
		Transaction singleTransaction = transactionService.findById(transactionId);
		
		 model.put("id", singleTransaction.getId());
		 model.put("date", singleTransaction.getDate());
		 model.put("amount", singleTransaction.getAmount());
		 model.put("description", singleTransaction.getDescription());
		 model.put("type", singleTransaction.getType());

		return "singletransaction";
		}
}
