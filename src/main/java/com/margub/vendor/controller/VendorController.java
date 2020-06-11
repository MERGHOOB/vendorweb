package com.margub.vendor.controller;

import com.margub.vendor.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VendorController {

    @Autowired
    IVendorService vendorService;

    @RequestMapping("/showCreate")
    public String showCreate() {

        return "createVendor";
    }

}
