package com.sowloo.logisticApp.dtos.requests;

import lombok.Data;

@Data
public class AddPackageRequest {
    private String senderEmail;
    private String receiversName;
    private String deliveryAddress;
    private double packageWeight;
    private String packageDescription;
    private String receiverPhone;
}
