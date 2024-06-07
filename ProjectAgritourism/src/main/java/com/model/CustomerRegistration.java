package com.model;

//import java.util.Properties;
import java.util.Random;

//import jakarta.mail.Authenticator;
//import jakarta.mail.Message;
//import jakarta.mail.MessagingException;
//import jakarta.mail.PasswordAuthentication;
//import jakarta.mail.Session;
//import jakarta.mail.Transport;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
//import lombok.Data;

@Entity
//@Data
public class CustomerRegistration 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1, initialValue = 1000)
	private long customerId;
	private String customerName;
	private String customerPhoneNo;
	private String customerEmail;
	private String customerUserName;
	private String customerPassword;	
	
	public CustomerRegistration() {
		super();
	}
	 
	public CustomerRegistration(long customerId, String customerName, String customerPhoneNo, String customerEmail, String customerUserName, String customerPassword) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNo = customerPhoneNo;
		this.customerEmail = customerEmail;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}

	public void setCustomerUserName(String customerUserName) {
		 this.customerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	
	
	
	
	
	//@ManyToOne
		 //@JoinColumn(name = "admin_id")    //It is a foreign key in customer table
		 //private Admin admin;
		 
		//@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	    //private List<FeedbackReview> feedback;
		 
		/*public CustomerRegistration() {
			super();
		}
		
		public CustomerRegistration(long customerId, String customerName, String customerPhoneNo, String customerEmail, String customerUserName, String customerPassword, Admin admin) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.customerPhoneNo = customerPhoneNo;
			this.customerEmail = customerEmail;
			this.customerUserName = customerUserName;
			this.customerPassword = customerPassword;
			this.admin = admin;
		}		

		public long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
		
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		
		public String getCustomerPhoneNo() {
			return customerPhoneNo;
		}
		public void setCustomerPhoneNo(String customerPhoneNo) {
			this.customerPhoneNo = customerPhoneNo;
		}
		
		public String getCustomerEmail() {
			return customerEmail;
		}
		public void setCustomerEmail(String customerEmail) {
			this.customerEmail = customerEmail;
		}
		
		public String getCustomerUserName() {
			return customerUserName;
		}
		public void setCustomerUserName(String customerUserName) {
			this.customerUserName = customerUserName;
		}
		
		public String getCustomerPassword() {
			return customerPassword;
		}
		public void setCustomerPassword(String customerPassword) {
			this.customerPassword = customerPassword;
		}
		
		public Admin getAdmin() {
			return admin;
		}
		public void setAdmin(Admin admin) {
			this.admin = admin;
		}*/
	
	
	/*public CustomerRegistration() {
		super();
	}

	public CustomerRegistration(long customerId, String customerName, String customerPhoneNo, String customerEmail,
			String customerUserName, String customerPassword, List<FeedbackReview> feedback) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhoneNo = customerPhoneNo;
		this.customerEmail = customerEmail;
		this.customerUserName = customerUserName;
		this.customerPassword = customerPassword;
		this.feedback = feedback;
	}

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}
	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public List<FeedbackReview> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<FeedbackReview> feedback) {
		this.feedback = feedback;
	}*/

	
	@PrePersist
    public void prePersist() {
        // Generate customerUserName and customerPassword
        generateCredentials();
        // Send email with credentials
       // sendEmail();
    }


	private void generateCredentials() {
        // Generate random username and password
		//CustomerRegistration s = new CustomerRegistration();
		//String customerName = s.getCustomerName();
        this.customerUserName = generateRandomString(8);
		//this.customerUserName = customerName +"123";
        this.customerPassword = generateRandomString(6);
    }

   /* private void sendEmail() {
        // Configure email properties
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "securebanknetwork.sbn@gmail.com";
        String password = "mzpkebelrqxchlzo";
        String from = "securebanknetwork.sbn@gmail.com"; //"your.email@example.com";
        String to = this.customerEmail;
        String subject = "Your Account Information";
        String messageText = "Dear " + this.customerName + ",\n\n"
                + "Thank you for registering!\n\n"
                + "Your username: " + this.customerUserName + "\n"
                + "Your password: " + this.customerPassword + "\n\n"
                + "Please keep this information secure.\n\n"
                + "Best regards,\n"
                + "Your Platform Team";

        // Create properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Get the Session object
        Session session = Session.getInstance(properties, new Authenticator() {
        
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(messageText);

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }*/

    // Method to generate a random alphanumeric string of given length
    private String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        Random rnd = new Random();
        while (stringBuilder.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();
    }

}
