package com.example.backendproject.repository;
import com.example.backendproject.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByUploadedById(Long userId);
}
