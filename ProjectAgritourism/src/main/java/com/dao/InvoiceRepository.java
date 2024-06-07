package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
	 Invoice findFirstByOrderByInvoiceDateDesc();
}
