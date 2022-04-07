package com.sowloo.logisticApp.controllers;

import com.sowloo.logisticApp.data.models.TrackingInformation;
import com.sowloo.logisticApp.dtos.requests.AddTrackingInfoRequest;
import com.sowloo.logisticApp.dtos.responses.AddTrackingInfoResponse;
import com.sowloo.logisticApp.services.TrackingService;
import com.sowloo.logisticApp.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PostMapping("/api/trackingInfo")
    public AddTrackingInfoResponse addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest){
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo/{id}")
    public TrackingInformation getTrackingInfo(@PathVariable("id") Integer trackingId){

        return trackingService.trackPackage(trackingId);
    }
}
