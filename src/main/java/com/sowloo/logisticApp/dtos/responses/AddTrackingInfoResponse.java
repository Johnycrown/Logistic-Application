package com.sowloo.logisticApp.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddTrackingInfoResponse {
    private Integer packageId;
    private LocalDateTime localDateTime;
    private String event;
}
