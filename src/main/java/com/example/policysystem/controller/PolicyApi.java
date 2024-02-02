package com.example.policysystem.controller;

import com.example.policysystem.request.CustomerInfo;
import com.example.policysystem.response.PolicyVerificationStatusResponse;
import com.example.policysystem.response.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping(path = "/verify")
    public ResponseEntity<PolicyVerificationStatusResponse> verifyPolicy(@RequestBody CustomerInfo customerInfoRequestEntity) {

        logger.info("#######CLAIMNO######## " + customerInfoRequestEntity.getClaimNo());
        logger.info("#######NAME######## " + customerInfoRequestEntity.getName());
        logger.info("#######INCDATE######## " + customerInfoRequestEntity.getIncidentDate());
        logger.info("#######LOSSCAUSE######## " + customerInfoRequestEntity.getLossCause());
        String dummyClaimNo = "MTC0000001";
        PolicyVerificationStatusResponse res = new PolicyVerificationStatusResponse();
        if (dummyClaimNo.equalsIgnoreCase(customerInfoRequestEntity.getClaimNo())) {
            res.setStatus(Status.SUCCESS);
            res.setMessage("Successfully Verified");
        } else {
            res.setStatus(Status.FAILED);
            res.setMessage("Verification failed");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
