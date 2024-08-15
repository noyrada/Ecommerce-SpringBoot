package com.project.samplecrud_sb.repository;

import com.project.samplecrud_sb.model.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Long> {

}
