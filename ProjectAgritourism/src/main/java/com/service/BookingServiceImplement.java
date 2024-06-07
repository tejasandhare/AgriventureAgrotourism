package com.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.BookingRepository;
import com.dao.GuideRepository;
import com.dao.InvoiceRepository;
import com.dao.LivingHomeRepository;
import com.dao.TourPackageRepository;
import com.model.Booking;
import com.model.Guide;
import com.model.Invoice;
import com.model.LivingHome;
import com.model.TourPackage;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;

@Service
public class BookingServiceImplement implements BookingService
{
	@Autowired
	BookingRepository bookRepo;
	
	@Autowired
	InvoiceRepository invoiceRepo;
	
	@Autowired
	GuideRepository guideRepo;
	
	@Autowired
	TourPackageRepository tourpackRepo;
	
	@Autowired
	LivingHomeRepository liveHomeRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public void saveBookingAndSendEmail(Booking booking) 
	{
		Guide guide = guideRepo.findByGuideName(booking.getGuide().getGuideName());
        if (guide != null) 
        {
            booking.setGuide(guide);
        }
 
        TourPackage tourPackage = tourpackRepo.findByPackageName(booking.getTourPackage().getPackageName());
        if (tourPackage != null) 
        {
            booking.setTourPackage(tourPackage);
        }
        
        LivingHome home = liveHomeRepo.findByHomeType(booking.getLiveHome().getHomeType());
        if (home != null) 
        {
            booking.setLiveHome(home);
        }
        
		// Save booking data
        Booking savedBooking = bookRepo.save(booking);

       /*// Generate PDF
        byte[] pdfData = generatePDF(savedBooking);
         // Save PDF to invoice table
        saveInvoice(pdfData, savedBooking, "PDF");

        // Generate CSV
        byte[] csvData = generateCSV(savedBooking);
        // Save CSV to invoice table
        saveInvoice(csvData, savedBooking, "CSV");*/
        
        // Generate RTF
        byte[] rtfData = generateRTF(savedBooking);       
        // Save RTF to invoice table
        saveInvoice(rtfData, savedBooking, "RTF");

        // Send email with PDF and CSV attachment
        sendEmailWithAttachments(savedBooking.getCustEmail(), "Booking Information", "Thank you for booking your trip with us,\nWe look forward to making your Journey Unforgettable!", /*pdfData, csvData,*/ rtfData, "Best Regards, \nAgriventure Agrotourism");
	}

	/*private byte[] generatePDF(Booking booking) 
	{
		try (PDDocument document = new PDDocument()) 
		{
	        PDPage page = new PDPage();
	        document.addPage(page);

	        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) 
	        {
	            contentStream.beginText();
	            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
	            contentStream.newLineAtOffset(100, 700);
	            contentStream.showText("============= Booking Information =============");
	            contentStream.newLine();

	            // Insert each record on a new line
	            contentStream.showText("Booking ID : " + booking.getBookingId());
	            contentStream.newLine();
	            contentStream.showText("Customer Name : " + booking.getCustName());
	            contentStream.newLine();
	            contentStream.showText("Phone Number : " + booking.getCustMoNo());
	            contentStream.newLine();
	            contentStream.showText("Customer Email : " + booking.getCustEmail());
	            contentStream.newLine();
	            contentStream.showText("Total No. of People : " + booking.getTotalMembers());
	            contentStream.newLine();
	            contentStream.showText("Booking Date : " + booking.getBookingDate());
	            contentStream.newLine();
	            contentStream.showText("Tour Guide Name : " + booking.getGuide());
	            contentStream.newLine();
	            contentStream.showText("Package Type : " + booking.getTourPackage());
	            contentStream.newLine();
	            contentStream.showText("Booking Amount: " + booking.getBookingAmt());
	            contentStream.newLine();
	            contentStream.showText("Booking Status : " + booking.getBookingStatus());
	            contentStream.newLine();
	            contentStream.showText("================================================");
	            contentStream.endText();
	        }

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        document.save(outputStream);
	        return outputStream.toByteArray();
	    } 
		catch (IOException e) 
		{
	        e.printStackTrace();
	        throw new RuntimeException("Error generating PDF");
	    }
    }

	private byte[] generateCSV(Booking booking) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             OutputStreamWriter osw = new OutputStreamWriter(baos, StandardCharsets.UTF_8);
             CSVPrinter csvPrinter = new CSVPrinter(osw, CSVFormat.DEFAULT.withHeader(
                     "Booking ID", "Customer Name", "Phone Number", "Customer Email",
                     "Total No. of People", "Booking Date", "Tour Guide Name", 
                     "Package Type", "Booking Amount", "Booking Status"))) {

            csvPrinter.printRecord(
                    booking.getBookingId(),
                    booking.getCustName(),
                    booking.getCustMoNo(),
                    booking.getCustEmail(),
                    booking.getTotalMembers(),
                    booking.getBookingDate(),
                    booking.getGuide(),
                    booking.getTourPackage(),
                    booking.getBookingAmt(),
                    booking.getBookingStatus()
            );

            csvPrinter.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating CSV");
        }
    }*/
	
	private byte[] generateRTF(Booking booking) {
        String rtfContent = "\n\n\n\n                         AGRIVENTURE AGROTOURISM                         \n\n\n\n"+
        					"========================== Booking Information ==========================\n\n\n" +
                            "           Booking ID              :      " + booking.getBookingId() + "\n" +
                            "           Customer Name           :      " + booking.getCustName() + "\n" +
                            "           Phone Number            :      " + booking.getCustMoNo() + "\n" +
                            "           Customer Email          :      " + booking.getCustEmail() + "\n" +
                            "           Total No. of People     :      " + booking.getTotalMembers() + "\n" +
                            "           Booking Date            :      " + booking.getBookingDate() + "\n" +
                            "           Tour Guide Name         :      " + booking.getGuide() + "\n" +
                            "           Package Type            :      " + booking.getTourPackage() + "\n" +
                            "           Booking Amount          :      " + booking.getBookingAmt() + "\n" +
                            "           Booking Status          :      " + booking.getBookingStatus() + "\n\n\n" +                       
                            "=========================================================================\n\n\n"+
                            "Thank you for booking your trip with us, \n"+ 
                            "We look forward to making your Journey Unforgettable!\n\n\n"+
                            "Best Regards,\nAgriventure Agrotourism";

        return rtfContent.getBytes();
    }

    private void saveInvoice(byte[] data, Booking booking, String fileType) {
        Invoice invoice = new Invoice();
        invoice.setBookingId(booking.getBookingId());
        invoice.setFileData(data);
        invoice.setFileType(fileType);
        //invoice.setInvoiceDate(new Date());
        invoice.setInvoiceDate(LocalDate.now());
        invoiceRepo.save(invoice);
    }
    
    private void sendEmailWithAttachments(String to, String subject, String text, /*byte[] pdfData, byte[] csvData,*/ byte[] rtfData, String text1 ) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);
            
           /* // Convert byte[] to a ByteArrayResource for PDF
            ByteArrayResource pdfResource = new ByteArrayResource(pdfData);
            helper.addAttachment("Booking_Info.pdf", pdfResource);
            // Convert byte[] to a ByteArrayResource for CSV
            ByteArrayResource csvResource = new ByteArrayResource(csvData);
            helper.addAttachment("Booking_Info.csv", csvResource);*/
          
            ByteArrayResource rtfResource = new ByteArrayResource(rtfData);
            helper.addAttachment("Booking_Info.rtf", rtfResource);
            helper.setText(text1);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error sending email");
        }
    }

	@Override
	public Booking getBookingById(long id) 
	{
		return bookRepo.findById(id).orElse(null);
	}

	@Override
	public List<Booking> getAllBooking() 
	{
		return bookRepo.findAll();
	}

	@Override
	public Booking updateBooking(Booking book) 
	{
		Booking existingBooking = bookRepo.findById(book.getBookingId()).orElse(null);
		existingBooking.setBookingDate(book.getBookingDate());
		
		Booking updatedBooking = bookRepo.save(existingBooking);
		return updatedBooking;
	}

	@Override
	public Map<String, Object> deleteBooking(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		Booking book = bookRepo.findById(id).orElse(null);
		
		if(book == null)
		{
			response.put("Not Deleted", "Booking Not Deleted Because ID not FOUND");
		}
		else
		{
			bookRepo.delete(book);
			response.put("Deleted", "Booking Deleted Successfully");
		}
		return response;
	}
}



