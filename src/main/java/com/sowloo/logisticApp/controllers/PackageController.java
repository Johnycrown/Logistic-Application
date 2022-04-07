package com.sowloo.logisticApp.controllers;

import com.sowloo.logisticApp.data.exceptions.SenderDoesNotExistException;
import com.sowloo.logisticApp.data.models.Package;
import com.sowloo.logisticApp.dtos.requests.AddPackageRequest;
import com.sowloo.logisticApp.dtos.responses.AddPackageResponse;
import com.sowloo.logisticApp.services.PackageServiceImpl;
import com.sowloo.logisticApp.services.PackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {
    private final PackageService packageService = new PackageServiceImpl();

    @PostMapping("/api/addpackage")
    public ResponseEntity<?> addPackage(@RequestBody AddPackageRequest addPackageRequest) {
        try {
            AddPackageResponse response = packageService.addPackage(addPackageRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (SenderDoesNotExistException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/api/package/{id}")
    public Package findPackageBy(@PathVariable("id") Integer packageId) {
        return packageService.findMyPackageWith(packageId);
    }
}
