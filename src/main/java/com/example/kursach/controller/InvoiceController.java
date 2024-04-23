package com.example.kursach.controller;

import com.example.kursach.entity.Invoice;
import com.example.kursach.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
    @GetMapping("/invoice")
    private List<Invoice> getAllInvoice()
    {
        return invoiceService.getAllInvoice();
    }
    @GetMapping("/invoice/{id}")
    private Invoice getInvoiceById(@PathVariable("id") int id)
    {
        return invoiceService.getInvoiceById(id);
    }
    @DeleteMapping("/invoice/{id}")
    private void delete(@PathVariable("id") int id)
    {
        invoiceService.delete(id);
    }
    @PostMapping("/invoice")
    private int saveInvoice(@RequestBody Invoice invoice)
    {
        invoiceService.saveOrUpdate(invoice);
        return invoice.getId();
    }
    @PutMapping("/invoice")
    private Invoice update(@RequestBody Invoice invoice)
    {
        invoiceService.saveOrUpdate(invoice);
        return invoice;
    }
}
