package com.sowloo.logisticApp.dtos.requests;

import lombok.Data;

@Data
public class AddTrackingInfoRequest {
    private Integer packageId;
    private String event;
}
