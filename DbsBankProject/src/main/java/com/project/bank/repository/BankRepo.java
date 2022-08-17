package com.project.bank.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.model.BankBic;



public interface BankRepo extends JpaRepository<BankBic, String> {

}
