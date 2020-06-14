package com.margub.vendor.controller;

import com.margub.vendor.dto.VendorUpdateRequest;
import com.margub.vendor.entities.Vendor;
import com.margub.vendor.repos.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/vendors")
public class VendorRestController {

    @Autowired
    IVendorRepository vendorRepository;


    @GetMapping
    public List<Vendor> getVendors() {
        return vendorRepository.findAll();
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @PutMapping
    public Vendor updateVendor(@RequestBody Vendor vendor) {
        return vendorRepository.save(vendor);
    }


    @DeleteMapping("/{id}")
    public void deleteVendor(@PathVariable("id") int id) {
        vendorRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Vendor findVendor(@PathVariable("id") int id) {
        return vendorRepository.getOne(id);
    }


    @RequestMapping("/updateRequest")
    public Vendor updateVendor(@RequestBody VendorUpdateRequest request) {
        Vendor vendor = vendorRepository.getOne(request.getId());
        vendor.setType(request.getType());

        return vendorRepository.save(vendor);
    }


}
