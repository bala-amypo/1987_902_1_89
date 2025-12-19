package com.example.backendproject.service.impl;
import com.example.backendproject.model.Invoice;
import com.example.backendproject.model.User;
import com.example.backendproject.model.Vendor;
import com.example.backendproject.repository.InvoiceRepository;
import com.example.backendproject.repository.UserRepository;
import com.example.backendproject.repository.VendorRepository;
import com.example.backendproject.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              UserRepository userRepository,
                              VendorRepository vendorRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        User user = userRepository.findById(userId).orElse(null);
        Vendor vendor = vendorRepository.findById(vendorId).orElse(null);

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);

        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice categorizeInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        return invoiceRepository.findByUploadedById(userId);
    }

    @Override
    public Invoice getInvoice(Long invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }
}
