package com.sowloo.logisticApp.utils;

import com.sowloo.logisticApp.data.models.Sender;
import com.sowloo.logisticApp.data.models.Package;
import com.sowloo.logisticApp.data.models.TrackingData;
import com.sowloo.logisticApp.dtos.requests.AddPackageRequest;
import com.sowloo.logisticApp.dtos.requests.AddTrackingInfoRequest;
import com.sowloo.logisticApp.dtos.requests.RegisterSenderRequest;
import com.sowloo.logisticApp.dtos.responses.AddPackageResponse;
import com.sowloo.logisticApp.dtos.responses.AddTrackingInfoResponse;
import com.sowloo.logisticApp.dtos.responses.RegisterSenderResponse;

public class ModelMapper {
    public static Package map(AddPackageRequest addPackageRequest) {
        Package aPackage = new Package();
        aPackage.setSenderEmail(addPackageRequest.getSenderEmail());
        aPackage.setName(addPackageRequest.getPackageDescription());
        aPackage.setDeliveryAddress(addPackageRequest.getDeliveryAddress());
        aPackage.setReceiverName(addPackageRequest.getReceiversName());
        aPackage.setNetWeight(addPackageRequest.getPackageWeight());
        aPackage.setReceiverPhone(addPackageRequest.getReceiverPhone());

        return aPackage;
    }

    public static AddPackageResponse map(Package savedPackage) {

        AddPackageResponse response = new AddPackageResponse();
        response.setPackageName(savedPackage.getName());
        response.setPackageWeight(savedPackage.getNetWeight());
        response.setReceiverPhone(savedPackage.getReceiverPhone());
        response.setReceiverName(savedPackage.getReceiverName());
        response.setTrackingNumber(savedPackage.getId());
        return response;
    }
    public static Sender map(RegisterSenderRequest registerSenderRequest) {

        Sender sender = new Sender();
        sender.setSenderName(registerSenderRequest.getSenderName());
        sender.setPhoneNumber(registerSenderRequest.getPhoneNumber());
        sender.setEmailAddress(registerSenderRequest.getSenderEmail());

        return sender;
    }

    public static RegisterSenderResponse map(Sender savedSender) {

        RegisterSenderResponse response = new RegisterSenderResponse();
        response.setSenderEmail(savedSender.getEmailAddress());

        return response;
    }
    public static AddTrackingInfoResponse map(TrackingData trackingData, AddTrackingInfoRequest addTrackingInfo) {

        AddTrackingInfoResponse addTrackingInfoResponse = new AddTrackingInfoResponse();
        addTrackingInfoResponse.setLocalDateTime(trackingData.getLocalDateTime());
        addTrackingInfoResponse.setEvent(trackingData.getEvent());
        addTrackingInfoResponse.setPackageId(addTrackingInfo.getPackageId());

        return addTrackingInfoResponse;
    }
}
