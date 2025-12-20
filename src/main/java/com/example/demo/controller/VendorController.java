package com.example.backendproject.controller;

import com.example.backendproject.model.Vendor;
import com.example.backendproject.service.VendorService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService service) {
        this.vendorService = service;
    }

    @PostMapping
    public Vendor create(@RequestBody Vendor vendor) {
        return vendorService.createVendor(vendor);
    }

    @GetMapping
    public List<Vendor> all() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor get(@PathVariable Long id) {
        return vendorService.getVendor(id);
    }
}
