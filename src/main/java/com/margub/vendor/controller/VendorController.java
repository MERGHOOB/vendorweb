package com.margub.vendor.controller;

import com.margub.vendor.entities.Vendor;
import com.margub.vendor.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;

@Controller
public class VendorController {

    @Autowired
    IVendorService vendorService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createVendor";
    }

    @RequestMapping("/saveVendor")
    public String saveVendor(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
        Vendor savedVendor = vendorService.saveVendor(vendor);

        String message = "Vendor saved with [ID: " + savedVendor.getId() + " ]";
        modelMap.addAttribute("msg", message);
        return "createVendor";
    }

}
