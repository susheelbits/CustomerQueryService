package com.bits.cexp.custquery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.bits.cexp.custquery.model.Customer;


public interface CustomerQueryRepository  extends JpaRepository<Customer, Long> {

}
