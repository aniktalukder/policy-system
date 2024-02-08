package com.example.policysystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "POLICY")
@Data
public class Policy {

    @Id
    @Column(name = "POLICY_NO")
    private String policyNo;

    @Column(name = "POLICY_TYPE")
    @Enumerated(EnumType.STRING)
    private PolicyTypeCodes policyType;

    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    @Column(name = "PRIMARY_INSURER")
    private String primaryInsurer;

    @Column(name = "LAST_UPDATED_TIME")
    @UpdateTimestamp
    private Timestamp updatedTime;
}
