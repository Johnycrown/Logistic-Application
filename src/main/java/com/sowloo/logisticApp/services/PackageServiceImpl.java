package com.sowloo.logisticApp.services;

import com.sowloo.logisticApp.data.exceptions.SenderDoesNotExistException;
import com.sowloo.logisticApp.data.models.Sender;
import com.sowloo.logisticApp.data.models.Package;
import com.sowloo.logisticApp.data.repositories.PackageRepository;
import com.sowloo.logisticApp.data.repositories.PackageRepositoryImpl;
import com.sowloo.logisticApp.dtos.requests.AddPackageRequest;
import com.sowloo.logisticApp.dtos.responses.AddPackageResponse;
import com.sowloo.logisticApp.utils.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PackageServiceImpl implements PackageService {
    private static final PackageRepository packageRepository = new PackageRepositoryImpl();
    private final SenderService senderService = new SenderServiceImpl();

    @Override
    public AddPackageResponse addPackage(AddPackageRequest addPackageRequest) {

        Optional<Sender> senderOptional = senderService.findSenderByEmail(addPackageRequest.getSenderEmail());
        if (senderOptional.isEmpty()) throw new SenderDoesNotExistException("Sender not Registered");
        Package aPackage = ModelMapper.map(addPackageRequest);

        Package savedPackage = packageRepository.save(aPackage);

        return ModelMapper.map(savedPackage);
    }

    @Override
    public Package findMyPackageWith(Integer id) {
        return packageRepository.findById(id);
    }

    @Override
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public void deleteAllPackages() {

        packageRepository.deleteAll();
    }
}
