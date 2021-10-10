package com.bits.cexp.custquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bits.cexp.custquery.dto.CustomerDTO;
import com.bits.cexp.custquery.model.Customer;
import com.bits.cexp.custquery.service.CustomerQueryService;


@RestController
@RequestMapping("/api/customers")
public class CustomerQueryController {
	private CustomerQueryService customerQueryService;

	public CustomerQueryController(CustomerQueryService customerQueryService) {
		super();
		this.customerQueryService = customerQueryService;
	}	

	// build get all employees REST API
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerQueryService.getAllCustomers();
	}	

	// build get customer by id REST API
	// http://localhost:8080/api/customers/1
	@GetMapping("{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") long customerId){
		return new ResponseEntity<CustomerDTO>(customerQueryService.getCustomerById(customerId), HttpStatus.OK);
	}

}
