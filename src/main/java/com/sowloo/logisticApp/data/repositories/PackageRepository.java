package com.sowloo.logisticApp.data.repositories;

import com.sowloo.logisticApp.data.models.Package;
import java.util.List;

public interface PackageRepository {
    Package save(Package aPackage);

    List<Package> findAll();

    void delete(Package aPackage);

    void delete(Integer trackingNumber);

    Package findById(Integer id);

    void deleteAll();
}
