package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.models.TrackingInformation;
import com.sowloo.logisticApp.dtos.requests.AddTrackingInfoRequest;
import com.sowloo.logisticApp.dtos.responses.AddTrackingInfoResponse;

public interface TrackingService {
    AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest);

    TrackingInformation trackPackage(Integer packageId);
}
