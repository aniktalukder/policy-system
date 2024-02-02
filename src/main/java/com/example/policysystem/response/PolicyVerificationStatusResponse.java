package com.example.policysystem.response;

import lombok.Data;

@Data
public class PolicyVerificationStatusResponse {

    private Status status;
    private String message;
}
