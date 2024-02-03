package com.example.policysystem.repository;

import com.example.policysystem.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, String> {

    public Optional<List<Policy>> findPolicyByPolicyNo(String policyNo);
}
