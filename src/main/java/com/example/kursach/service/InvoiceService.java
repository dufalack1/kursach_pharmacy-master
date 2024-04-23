package com.example.kursach.service;

import com.example.kursach.entity.Invoice;
import com.example.kursach.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoice()
    {
        List<Invoice> invoices = new ArrayList<Invoice>();
        invoiceRepository.findAll().forEach(invoice1 -> invoices.add(invoice1));
        return invoices;
    }

    public Invoice getInvoiceById(int id)
    {
        return invoiceRepository.findById(id).get();
    }
    public void saveOrUpdate(Invoice invoice)
    {
        invoiceRepository.save(invoice);
    }
    public void delete(int id)
    {
        invoiceRepository.deleteById(id);
    }
    public void update(Invoice invoice, int id)
    {
        invoiceRepository.save(invoice);
    }
}
