package com.project.bank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bank.model.Customer;





@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}