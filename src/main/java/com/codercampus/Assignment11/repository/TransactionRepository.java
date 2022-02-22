package com.codercampus.Assignment11.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.codercampus.Assignment11.domain.Transaction;

@Repository
public class TransactionRepository {
	private List<Transaction> transactions = new ArrayList<>(100);
	
	public TransactionRepository () {
		super();
		populateData();
	}
	
	public List<Transaction> findAll () {
		Collections.sort(transactions, new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.compareTo(o2);
			}
		});
		return transactions;
	}

	@SuppressWarnings("unchecked")
	private void populateData() {
		try (FileInputStream fileInputStream = new FileInputStream("transactions.txt");
			 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			this.transactions = (List<Transaction>) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	public Transaction findById(Integer transactionId) {
		// Find the second view of a single transaction.
		return transactions.get(transactionId);
		
	}
}
