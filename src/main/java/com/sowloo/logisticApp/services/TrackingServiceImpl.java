package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.exceptions.InvalidPackageIdException;
import com.sowloo.logisticApp.data.models.TrackingData;
import com.sowloo.logisticApp.data.models.TrackingInformation;
import com.sowloo.logisticApp.data.repositories.TrackingInformationRepository;
import com.sowloo.logisticApp.data.repositories.TrackingInformationRepositoryImpl;
import com.sowloo.logisticApp.dtos.requests.AddTrackingInfoRequest;
import com.sowloo.logisticApp.dtos.responses.AddTrackingInfoResponse;
import com.sowloo.logisticApp.utils.ModelMapper;

import java.util.Optional;

public class TrackingServiceImpl implements TrackingService {
    private static final TrackingInformationRepository trackingInformationRepository = new TrackingInformationRepositoryImpl();
    private PackageService packageService = new PackageServiceImpl();

    @Override
    public AddTrackingInfoResponse updateTrackingInfo(AddTrackingInfoRequest addTrackingInfoRequest) {
        // verify package id is correct
        var aPackage  = packageService.findMyPackageWith(addTrackingInfoRequest.getPackageId());
        if (aPackage == null) throw new InvalidPackageIdException("Package id is invalid");

        TrackingData trackingData = new TrackingData(addTrackingInfoRequest.getEvent());
        // find previous package info
        Optional<TrackingInformation> optionalInfo = trackingInformationRepository.findByPackageId(addTrackingInfoRequest.getPackageId());


        // if exist add new event and save
        if (optionalInfo.isPresent()) {
            optionalInfo.get().getTrackingData().add(trackingData);
            trackingInformationRepository.save(optionalInfo.get());
        }else {
            // else create new tracking info, add new event and save
            TrackingInformation trackingInformation = new TrackingInformation();
            trackingInformation.setPackageId(addTrackingInfoRequest.getPackageId());
            trackingInformation.getTrackingData().add(trackingData);
            trackingInformationRepository.save(trackingInformation);
        }
        // convert saved tracking info to a response dto
        // return response dto
        return ModelMapper.map(trackingData, addTrackingInfoRequest);
    }

    @Override
    public TrackingInformation trackPackage(Integer packageId) {
        return trackingInformationRepository.findByPackageId(packageId).get();
    }
}
