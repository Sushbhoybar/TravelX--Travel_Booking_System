package com.busbooking.dtos;

import com.busbooking.entities.ApprovalStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentResponse {

    private Long userId;

    private String agencyName;

    private String ownerName;

    private String email;

    private String phone;

    private String city;

    private ApprovalStatus status;

}