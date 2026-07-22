package com.busbooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FeedbackResponse {

    private Long feedbackId;

    private String name;

    private Integer rating;

    private String review;

    private String date;
}