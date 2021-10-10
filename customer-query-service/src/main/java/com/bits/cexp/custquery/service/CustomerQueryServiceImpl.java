package com.bits.cexp.custquery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bits.cexp.custquery.ResourceNotFoundException;
import com.bits.cexp.custquery.dto.CustomerDTO;
import com.bits.cexp.custquery.model.Customer;
import com.bits.cexp.custquery.repository.CustomerQueryRepository;


/**
 * Implementation for Interface of Customer Query Service
 * 
 * It implements methods for retrieving
 *
 */
@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {

	private CustomerQueryRepository customerQueryRepository;

	public CustomerQueryServiceImpl(CustomerQueryRepository customerQueryRepository) {
		super();
		this.customerQueryRepository = customerQueryRepository;
	}	
	

	public CustomerDTO getCustomerById(Long customerId) {
    	System.out.println("Inside getCustomerById method of CustomerQueryServiceImpl");
    	Customer custDb =  customerQueryRepository.findById(customerId).orElseThrow(() -> 
									new ResourceNotFoundException("Customer", "Id", customerId));
    	CustomerDTO custDto = new CustomerDTO (custDb.getFirstName(), custDb.getLastName(), custDb.getCustomerAddress(), custDb.getEmail(), custDb.getPhone(), custDb.getAcknowledgeFlag());
    	custDto.setCustomerId(custDb.getCustomerId());
    	return custDto;
	}	


	@Override
	public List<Customer> getAllCustomers() {
		return customerQueryRepository.findAll();
	}	

}
