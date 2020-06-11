package com.margub.vendor.services;

import com.margub.vendor.entities.Vendor;

import java.util.List;

/**
 * Service interface which describes services provided
 */
public interface IVendorService {

    Vendor saveVendor(Vendor vendor);

    Vendor updateVendor(Vendor vendor);

    void deleteVendor(Vendor vendor);

    Vendor getVendorById(int id);

    List<Vendor> getAllVendors();



}
