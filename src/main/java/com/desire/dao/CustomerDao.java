package com.desire.dao;

import com.desire.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

}


