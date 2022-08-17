package com.project.bank.controller;



import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.model.BankBic;
import com.project.bank.model.CustomResponse;
import com.project.bank.model.Customer;
import com.project.bank.model.MessageCode;
import com.project.bank.model.Transaction;
import com.project.bank.model.TransactionRequest;
import com.project.bank.service.BankService;





@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class BankController {
	
    @Autowired
	BankService customerService;
   
	@GetMapping("customer/{cid}")
    public ResponseEntity<Object> getCustomerById(@PathVariable String cid) {
        try {
		Optional<Customer> customer = customerService.getCustomerById(cid);
        System.out.println(customer);
        return customer.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        new CustomResponse("Account Doesn't Exist!", "Account with given A/C(" + cid + ") does not Exist!")
                ));
        }
        catch(Exception e)
        {
        	return null;
        }
       
	}
	  @GetMapping("bank/{bic}")
	 
	    public ResponseEntity<Object> getBankByBIC(@PathVariable String bic) {
		  
		  try {
				Optional<BankBic> bankBIC = customerService.getBankByBIC(bic);
		    
		        return bankBIC.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK).body(value)).orElseGet(() -> ResponseEntity
		                .status(HttpStatus.NOT_FOUND)
		                .body(
		                        new CustomResponse("Bank Doesn't Exist!", "Bank with given BIC(" + bic + ") does not Exist!")
		                ));
		        }
		        catch(Exception e)
		        {
		        	return null;
		        }

	    }
	  @GetMapping("messageCode")
	    public List<MessageCode> getAllMessageCodes() {
	        return customerService.getMessageCodes();
	    }
	  @PostMapping("transaction")
	    public ResponseEntity<Object> processTransaction(@RequestBody TransactionRequest request) {
		  System.out.print(request);
	        return customerService.processTransaction(request);
	    }
	  @GetMapping("transactionHistory")
	  public List<Transaction> getAllTransactions()
	  {
		  return customerService.getTransaction();
	  }
}

