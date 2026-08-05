package com.busbooking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Agent;
import com.busbooking.entities.ApprovalStatus;

@Repository
public interface AgentRepository
        extends JpaRepository<Agent, Long> {

    Optional<Agent> findByUserUserId(Long userId);

    Optional<Agent> findByUserEmail(String email);

    boolean existsByGstNumber(String gstNumber);

    boolean existsByPanNumber(String panNumber);

    boolean existsByBusinessLicense(String businessLicense);

    boolean existsByAgencyName(String agencyName);

    //boolean existsByStatus(ApprovalStatus status);
    
    long countByStatus(ApprovalStatus status);
    
    List<Agent> findAllByOrderByStatusAscAgencyNameAsc();

    List<Agent> findByStatus(ApprovalStatus status);

}