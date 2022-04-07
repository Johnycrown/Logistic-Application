package com.sowloo.logisticApp.data.repositories;

import com.sowloo.logisticApp.data.models.Package;
import java.util.*;

public class PackageRepositoryImpl implements PackageRepository {
    private final Map<Integer, Package> database = new HashMap<>();

    @Override
    public Package save(Package aPackage) {
        Integer id = null;
        if (aPackage.getId() == null) {
            id = database.size() + 1;
            aPackage.setId(id);
        }
        id = aPackage.getId();
        database.put(id, aPackage);
        return database.get(id);
    }

    @Override
    public List<Package> findAll() {
        List<Package> packages = new ArrayList<>();
        Set<Integer> keys = database.keySet();
        for (Integer key : keys) {
            packages.add(database.get(key));
        }
        return packages;
    }

    @Override
    public void delete(Package aPackage) {
        database.remove(aPackage.getId());
    }

    @Override
    public void delete(Integer trackingNumber) {
        database.remove(trackingNumber);
    }

    @Override
    public Package findById(Integer id) {
        return database.get(id);
    }

    @Override
    public void deleteAll() {
        database.clear();
    }
}
