package com.busbooking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDate;

@Entity
@Table(name = "agent")
@Getter
@Setter
@ToString(exclude = "password")
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @Column(name = "agent_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long agentId;

    @NotBlank
    @Column(name = "agency_name", nullable = false, unique = true)
    private String agencyName;

    @NotBlank
    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Email
    @NotBlank
    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    @NotBlank
    @jakarta.validation.constraints.Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Phone number must be a valid 10-digit Indian mobile number"
    )
    private String phone;

    @NotBlank
    @Column(nullable = false,)
    private String password;

//    business type

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String pincode;

    @Column(name = "gst_number",nullable = false, unique = true)
    private String gstNumber;

    @Column(name = "pan_number",nullable = false, unique = true)
    private String panNumber;

//    id_proof_path

    private boolean status;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
