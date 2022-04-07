package com.sowloo.logisticApp.data.repositories;

import com.sowloo.logisticApp.data.models.TrackingInformation;

import java.util.List;
import java.util.Optional;

public interface TrackingInformationRepository {
    TrackingInformation save(TrackingInformation trackingInformation);
    List<TrackingInformation> findAll();
    void deleteAll();
    Optional<TrackingInformation> findByPackageId(Integer packageId);
    void delete(Integer packageId);
    void delete(TrackingInformation trackingInformation);
}
