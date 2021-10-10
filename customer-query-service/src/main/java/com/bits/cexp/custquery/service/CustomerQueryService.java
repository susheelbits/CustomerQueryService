package com.bits.cexp.custquery.service;

import java.util.List;

import com.bits.cexp.custquery.dto.CustomerDTO;
import com.bits.cexp.custquery.model.Customer;


/**
 * Interface for Customer Query Service
 * 
 * It exposes methods for retrieving
 *
 */
public interface CustomerQueryService {

	 public CustomerDTO getCustomerById(Long customerId);
	 
	 List<Customer> getAllCustomers();
}
