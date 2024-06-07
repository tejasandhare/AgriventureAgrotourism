package com.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence", allocationSize = 501)
	private long bookingId;
	private String custName;
	private String custMoNo;
	private String custEmail; 
	private String totalMembers;
	private LocalDate bookingDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    private Guide guide; // Change from List<Guide> to Guide for OneToOne association

    //@ManyToOne(fetch = FetchType.EAGER)
	@ManyToOne(cascade = CascadeType.PERSIST)
    private TourPackage tourPackage; // Change from List<TourPackage> to TourPackage for ManyToOne association
	
    @ManyToOne(fetch = FetchType.EAGER)
    private LivingHome liveHome;
	private String bookingAmt;
	private String bookingStatus = "Confirm";
	

    public Booking() {
		super();
	}
	public Booking(long bookingId, String custName, String custMoNo, String custEmail, String totalMembers,
			LocalDate bookingDate, Guide guide, TourPackage tourPackage, LivingHome liveHome, String bookingAmt,
			String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.custName = custName;
		this.custMoNo = custMoNo;
		this.custEmail = custEmail;
		this.totalMembers = totalMembers;
		this.bookingDate = bookingDate;
		this.guide = guide;
		this.tourPackage = tourPackage;
		this.liveHome = liveHome;
		this.bookingAmt = bookingAmt;
		this.bookingStatus = bookingStatus;
	}
	
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustMoNo() {
		return custMoNo;
	}
	public void setCustMoNo(String custMoNo) {
		this.custMoNo = custMoNo;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	public String getTotalMembers() {
		return totalMembers;
	}
	public void setTotalMembers(String totalMembers) {
		this.totalMembers = totalMembers;
	}
	
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public Guide getGuide() {
		return guide;
	}
	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	
	public TourPackage getTourPackage() {
		return tourPackage;
	}
	public void setTourPackage(TourPackage tourPackage) {
		this.tourPackage = tourPackage;
	}
	
	public LivingHome getLiveHome() {
		return liveHome;
	}
	public void setLiveHome(LivingHome liveHome) {
		this.liveHome = liveHome;
	}
	
	public String getBookingAmt() {
		return bookingAmt;
	}
	public void setBookingAmt(String bookingAmt) {
		this.bookingAmt = bookingAmt;
	}
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
    
	
    
	
	
	
	
	
	//@OneToOne(mappedBy = "booking")//(fetch = FetchType.EAGER)
    //private List<Guide> guideName;
	//private LocalDate startDate;  //@Column(name = "start_date", nullable = false)
    //private LocalDate endDate;  //@Column(name = "end_date", nullable = false
	
	//@ManyToOne(fetch = FetchType.EAGER)
    //private List<TourPackage> tourPackageName;
   // @JoinColumn(name = "package_name", nullable = false)
   // private TourPackage tourPackageName;
    //private TourPackage packageType;
    
	//private String status;  //status will be your confirm or cancel  //@Column(name = "status", nullable = false)
	   
	   /* @ElementCollection
	    @CollectionTable(name = "family_members", joinColumns = @JoinColumn(name = "booking_id"))
	    @Column(name = "family_member_name")
	    private Set<String> familyMembers = new HashSet<>(); // Names of family members*/
	
	
	/*public Booking(Long bookingId, String customerName, String custEmailId, Set<String> familyMembers,
			TourPackage tourPackId, LocalDate startDate, LocalDate endDate, String status) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.custEmailId = custEmailId;
		this.familyMembers = familyMembers;
		this.tourPackId = tourPackId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}

	public Long getBookingId() {
		return bookingId;
	}
	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustEmailId() {
		return custEmailId;
	}
	public void setCustEmailId(String custEmailId) {
		this.custEmailId = custEmailId;
	}

	public Set<String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Set<String> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public TourPackage getTourPackId() {
		return tourPackId;
	}
	public void setTourPackId(TourPackage tourPackId) {
		this.tourPackId = tourPackId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}*/
	
	
	
	/*@PrePersist
    public void prePersist() 
	{
        generateCredentials();
    }

	private void generateCredentials() 
	{
        this.adminUserName = generateRandomString(8);
        this.adminPassword = generateRandomString(6);
    }
	
	 private String generateRandomString(int length) 
	 {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder stringBuilder = new StringBuilder();
	        Random rnd = new Random();
	        while (stringBuilder.length() < length) 
	        {
	            int index = (int) (rnd.nextFloat() * chars.length());
	            stringBuilder.append(chars.charAt(index));
	        }
	        return stringBuilder.toString();
	 }*/
    
    
}
