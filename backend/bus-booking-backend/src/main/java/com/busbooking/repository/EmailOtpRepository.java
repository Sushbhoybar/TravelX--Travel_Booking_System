package com.busbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.EmailOtp;

public interface EmailOtpRepository
        extends JpaRepository<EmailOtp, Long> {

	Optional<EmailOtp> findTopByEmailAndPurposeOrderByCreatedAtDesc(
            String email,
            String purpose);

    Optional<EmailOtp> findTopByEmailAndPurposeAndVerifiedOrderByCreatedAtDesc(
            String email,
            String purpose,
            Boolean verified);
    
    void deleteByEmailAndPurpose(
            String email,
            String purpose);

}