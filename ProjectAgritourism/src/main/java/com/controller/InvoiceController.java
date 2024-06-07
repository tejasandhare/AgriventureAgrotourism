package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Invoice;
import com.service.InvoiceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/latest")
	public ResponseEntity<byte[]> downloadLatestInvoice() {
		Invoice invoice = invoiceService.getLatestInvoice();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=receipt." + invoice.getFileType())
				.body(invoice.getFileData());
	}
}
