package com.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busbooking.entities.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}