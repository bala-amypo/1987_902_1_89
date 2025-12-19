package com.example.backendproject.service;
import com.example.backendproject.model.Vendor;

import java.util.List;

public interface VendorService {
    Vendor createVendor(Vendor vendor);
    Vendor getVendor(Long vendorId);
    List<Vendor> getAllVendors();
}
