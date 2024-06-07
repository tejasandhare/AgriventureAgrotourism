package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceRepository;
import com.model.Invoice;

@Service
public class InvoiceServiceImplement implements InvoiceService 
{
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	
	public Invoice getLatestInvoice() 
	{
        return invoiceRepo.findFirstByOrderByInvoiceDateDesc();
    }
}
