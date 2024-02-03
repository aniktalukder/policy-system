package com.example.policysystem.service;

import com.example.policysystem.entity.Policy;
import com.example.policysystem.repository.PolicyRepo;
import com.example.policysystem.request.CustomerInfo;
import com.example.policysystem.response.PolicyVerificationStatusResponse;
import com.example.policysystem.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepo policyRepo;

    //TODO Improve this function with more conditions
    public PolicyVerificationStatusResponse verifyPolicy(CustomerInfo customerInfoRequestEntity) {

        String incomingPolicyNo = customerInfoRequestEntity.getPolicyNo();
        Optional<List<Policy>> responsePolicy = policyRepo.findPolicyByPolicyNo(incomingPolicyNo);
        String policyN0 = responsePolicy.map(policies -> policies.get(0).getPolicyNo()).orElse(null);
        return policyN0 != null
                ? new PolicyVerificationStatusResponse(Status.SUCCESS, "Policy Verified")
                : new PolicyVerificationStatusResponse(Status.FAILED, "No Policy Found");
    }
}
