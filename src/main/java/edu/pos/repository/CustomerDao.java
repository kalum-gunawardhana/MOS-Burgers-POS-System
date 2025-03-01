package edu.pos.repository;

import edu.pos.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<CustomerEntity, Integer> {

}
