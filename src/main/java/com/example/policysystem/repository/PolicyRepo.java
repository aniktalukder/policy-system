package com.example.policysystem.repository;

import com.example.policysystem.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, String> {}
