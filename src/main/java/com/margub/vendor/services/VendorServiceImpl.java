package com.margub.vendor.services;

import com.margub.vendor.entities.Vendor;
import com.margub.vendor.repos.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements IVendorService {

    @Autowired
    IVendorRepository vendorRepository;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendor(Vendor vendor) {
        vendorRepository.delete(vendor);
    }

    @Override
    public Vendor getVendorById(int id) {
        Optional<Vendor> vendorById = vendorRepository.findById(id);
        return vendorById.orElse(null);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
