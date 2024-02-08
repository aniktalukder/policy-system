package com.example.policysystem.service;

import com.example.policysystem.entity.Policy;
import com.example.policysystem.repository.PolicyRepo;
import com.example.policysystem.request.CustomerInfo;
import com.example.policysystem.response.PolicyVerificationStatusResponse;
import com.example.policysystem.response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepo policyRepo;

    //TODO Improve this function with more conditions
    public PolicyVerificationStatusResponse verifyPolicy(CustomerInfo customerInfoRequestEntity) {

        String incomingPolicyNo = customerInfoRequestEntity.getPolicyNo();
        Optional<List<Policy>> response = policyRepo.findPolicyByPolicyNo(incomingPolicyNo);
        Policy policy = response
                .map(policies -> policies.get(0))
                .orElse(null);
        String policyNo = policy != null ? policy.getPolicyNo() : null;
        PolicyVerificationStatusResponse res = new PolicyVerificationStatusResponse();
        return (policyNo != null
                && policyNo.equalsIgnoreCase(customerInfoRequestEntity.getPolicyNo())
                && policy.getPrimaryInsurer().equalsIgnoreCase(customerInfoRequestEntity.getName())
                && policy.getPolicyType().name().equalsIgnoreCase(customerInfoRequestEntity.getLossCause())
                && Date.valueOf(customerInfoRequestEntity.getIncidentDate()).after(policy.getEffectiveDate())
                && Date.valueOf(customerInfoRequestEntity.getIncidentDate()).before(policy.getExpiryDate()))
                ? new PolicyVerificationStatusResponse(Status.SUCCESS, "Policy Verified")
                : new PolicyVerificationStatusResponse(Status.FAILED, "No Policy Found");
    }
}
