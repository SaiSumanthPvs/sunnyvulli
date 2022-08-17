package com.project.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bank.model.MessageCode;





public interface MessageRepository extends JpaRepository<MessageCode, String> {

}