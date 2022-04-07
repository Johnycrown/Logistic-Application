package com.sowloo.logisticApp.data.models;

import lombok.Data;

@Data
public class Package {
    private Integer id;
    private String name;
    private String receiverName;
    private String deliveryAddress;
    private double netWeight;
    private String receiverPhone;
    private String senderEmail;
}
