package com.margub.vendor.controller;

import com.margub.vendor.dto.VendorUpdateRequest;
import com.margub.vendor.entities.Vendor;
import com.margub.vendor.repos.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorRestController {

    @Autowired
    IVendorRepository vendorRepository;

    @RequestMapping("/vendors/{id}")
    public Vendor findVendor(@PathVariable("id") int id) {
        return vendorRepository.getOne(id);
    }


    @RequestMapping("/vendors")
    public Vendor updateVendor(@RequestBody VendorUpdateRequest request) {
        Vendor vendor = vendorRepository.getOne(request.getId());
        vendor.setType(request.getType());

        return vendorRepository.save(vendor);
    }


}
