package com.busbooking.dtos;

import com.busbooking.entities.ApprovalStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentDetailsResponse {

    private Long userId;

    private String agencyName;

    private String ownerName;

    private String email;

    private String phone;

    private String gstNumber;

    private String panNumber;

    private String businessLicense;

    private String accountHolderName;

    private String bankAccountNumber;

    private String ifscCode;

    private String address;

    private String city;

    private String state;

    private String country;

    private String pincode;

    private ApprovalStatus status;

}