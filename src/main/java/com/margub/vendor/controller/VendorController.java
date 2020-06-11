package com.margub.vendor.controller;

import com.margub.vendor.entities.Vendor;
import com.margub.vendor.services.IVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Id;
import java.util.List;

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

    @RequestMapping("/displayVendors")
    public String displayVendors(ModelMap modelMap) {
        List<Vendor> allVendors = vendorService.getAllVendors();
        modelMap.addAttribute("vendors", allVendors);
        return "displayVendors";
    }

    @RequestMapping("/updateVendor")
    public String updateVendor(@RequestParam("id")int id, ModelMap modelMap) {
        Vendor vendorById = vendorService.getVendorById(id);
        modelMap.addAttribute("vendor", vendorById);
        return "updateVendor";
    }

    @RequestMapping("/saveUpdate")
    public String updateVendor(@ModelAttribute Vendor vendor, ModelMap modelMap) {
        vendorService.updateVendor(vendor);

        List<Vendor> allVendors = vendorService.getAllVendors();
        modelMap.addAttribute("vendors", allVendors);
        return "displayVendors";
    }

    @RequestMapping("/deleteVendor")
    public String deleteVendor(@RequestParam("id") int id, ModelMap modelMap) {
        vendorService.deleteVendor(vendorService.getVendorById(id));
        List<Vendor> allVendors = vendorService.getAllVendors();
        modelMap.addAttribute("vendors", allVendors);
        return "displayVendors";
    }
}
