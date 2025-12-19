package com.example.demo.controller;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
@Tag(name = "Vendors Endpoints")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @Operation(summary = "Create vendor")
    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        return new ResponseEntity<>(vendorService.createVendor(vendor), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all vendors")
    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        return ResponseEntity.ok(vendorService.getAllVendors());
    }

    @Operation(summary = "Get vendor by ID")
    @GetMapping("/{vendorId}")
    public ResponseEntity<Vendor> getVendor(@PathVariable Long vendorId) {
        return ResponseEntity.ok(vendorService.getVendor(vendorId));
    }
}
