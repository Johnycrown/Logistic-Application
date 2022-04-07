package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.models.Package;
import com.sowloo.logisticApp.dtos.requests.AddPackageRequest;
import com.sowloo.logisticApp.dtos.responses.AddPackageResponse;

import java.util.List;

public interface PackageService {
    AddPackageResponse addPackage(AddPackageRequest addPackageRequest);

    Package findMyPackageWith(Integer id);

    List<Package> getAllPackages();

    void deleteAllPackages();
}
