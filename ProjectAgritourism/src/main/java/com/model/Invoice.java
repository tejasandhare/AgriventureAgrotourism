package com.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")
	@SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_sequence", allocationSize = 801)
	private long invoiceId;
	private long bookingId; // Foreign key referencing Booking.bookId

	@Lob
	@Column(length = 1000000)
	private byte[] fileData;
	private String fileType; 
	private LocalDate invoiceDate;

	public Invoice() {
		super();
	}

	public Invoice(long invoiceId, long bookingId, byte[] fileData, String fileType, LocalDate invoiceDate) {
		super();
		this.invoiceId = invoiceId;
		this.bookingId = bookingId;
		this.fileData = fileData;
		this.fileType = fileType;
		this.invoiceDate = invoiceDate;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

//	public Invoice(long invoiceId, long bookingId, byte[] fileData, String fileType, Date invoiceDate) {
//		super();
//		this.invoiceId = invoiceId;
//		this.bookingId = bookingId;
//		this.fileData = fileData;
//		this.fileType = fileType;
//		this.invoiceDate = invoiceDate;
//	}
//
//	public long getInvoiceId() {
//		return invoiceId;
//	}
//
//	public void setInvoiceId(long invoiceId) {
//		this.invoiceId = invoiceId;
//	}
//
//	public long getBookingId() {
//		return bookingId;
//	}
//
//	public void setBookingId(long bookingId) {
//		this.bookingId = bookingId;
//	}
//
//	public byte[] getFileData() {
//		return fileData;
//	}
//
//	public void setFileData(byte[] fileData) {
//		this.fileData = fileData;
//	}
//
//	public String getFileType() {
//		return fileType;
//	}
//
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}
//
//	public Date getInvoiceDate() {
//		return invoiceDate;
//	}
//
//	public void setInvoiceDate(Date invoiceDate) {
//		this.invoiceDate = invoiceDate;
//	}

	/*
	 * public Invoice(long invoiceId, long bookingId, byte[] pdfData, Date
	 * invoiceDate) { super(); this.invoiceId = invoiceId; this.bookingId =
	 * bookingId; this.pdfData = pdfData; this.invoiceDate = invoiceDate; }
	 * 
	 * public long getInvoiceId() { return invoiceId; } public void
	 * setInvoiceId(long invoiceId) { this.invoiceId = invoiceId; }
	 * 
	 * public long getBookingId() { return bookingId; } public void
	 * setBookingId(long bookingId) { this.bookingId = bookingId; }
	 * 
	 * public byte[] getPdfData() { return pdfData; } public void setPdfData(byte[]
	 * pdfData) { this.pdfData = pdfData; }
	 * 
	 * public Date getInvoiceDate() { return invoiceDate; } public void
	 * setInvoiceDate(Date invoiceDate) { this.invoiceDate = invoiceDate; }
	 */

}
