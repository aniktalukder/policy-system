package com.example.policysystem.controller;

import com.example.policysystem.request.CustomerInfo;
import com.example.policysystem.response.PolicyVerificationStatusResponse;
import com.example.policysystem.response.Status;
import com.example.policysystem.service.PolicyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PolicyApi {

    Logger logger = LoggerFactory.getLogger(PolicyApi.class);

    @Autowired
    private PolicyService policyService;

    @GetMapping(path = "/verify")
    public ResponseEntity<PolicyVerificationStatusResponse> verifyPolicy(@RequestBody CustomerInfo customerInfoRequestEntity) {

        logger.info("#######CLAIMNO######## " + customerInfoRequestEntity.getPolicyNo());
        logger.info("#######NAME######## " + customerInfoRequestEntity.getName());
        logger.info("#######INCDATE######## " + customerInfoRequestEntity.getIncidentDate());
        logger.info("#######LOSSCAUSE######## " + customerInfoRequestEntity.getLossCause());
        PolicyVerificationStatusResponse res = policyService.verifyPolicy(customerInfoRequestEntity);
        return ResponseEntity.ok().body(res);
    }
}
