package com.example.policysystem.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerInfo {

    private String claimNo;
    private String name;
    private String incidentDate;
    private String lossCause;
}
