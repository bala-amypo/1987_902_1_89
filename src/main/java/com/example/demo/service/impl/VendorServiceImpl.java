package com.example.backendproject.service.impl;
import com.example.backendproject.model.Vendor;
import com.example.backendproject.repository.VendorRepository;
import com.example.backendproject.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor getVendor(Long vendorId) {
        return vendorRepository.findById(vendorId).orElse(null);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
