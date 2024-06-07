package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Booking;
import com.service.BookingService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BookingController 
{
	@Autowired
	BookingService bookService;
	
	@PostMapping("/addBookings")
	public ResponseEntity<String> saveBookingAndSendEmail(@RequestBody Booking booking) 
	{
	  bookService.saveBookingAndSendEmail(booking);
	  return ResponseEntity.ok("Booking Saved and Email Sent Successfully.");
	}
	
	@GetMapping("/getBooking/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable("id") long id) 
	{
		Booking book = bookService.getBookingById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Booking GET").body(book);
	}
	
	@GetMapping("/getAllBookingg")
	public ResponseEntity<List<Booking>> getAll() 
	{
		List<Booking> b = bookService.getAllBooking();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Booking GET").body(b);
	}
	
	@PutMapping("/updateBookingg")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking book)
	{
		Booking bk = bookService.updateBooking(book);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Admin Updated").body(bk);
	}
	
	@DeleteMapping("/deleteBookingg/{id}")
	public ResponseEntity<Map<String, Object>> deleteBooking(@PathVariable long id)
	{
		Map<String, Object> response = bookService.deleteBooking(id);
		
		return ResponseEntity.ok(response);
	}
}


/*<div class="row"> 
<div class="col-md-6" *ngFor="let gd of newBooking.guide; let i = index" >
  <label class="form-group">Guide {{i + 1}}</label>
    <select [(ngModel)]="gd.guideId" (change)="selectGuide(gd, $event)" name="guideId{{i}}" class="form-control" required>
      <option *ngFor="let gu of allGuide" [value]="gu.guideId">{{gu.guideName}}</option>
    </select>
</div>
</div> */




/*<div class="row"> 
            <div class="col-md-6" *ngFor="let gd of newBooking.guide; let i = index" >
              <label class="form-group">Guide {{i + 1}}</label>
             <!-- <div class="input-group mb-2"> -->
                <select [(ngModel)]="gd.guideId" (change)="selectGuide(gd, $event)" name="guideId{{i}}" class="form-control" required>
                  <option *ngFor="let gu of allGuide" [value]="gu.guideId">{{gu.guideName}}</option>
                </select>
               <!-- <button type="button" class="btn btn-danger" (click)="removeActivity(i)">Remove</button> -->
              <!--</div> -->
            </div>
            <button type="button" class="btn btn-secondary mb-3" (click)="addActivity()">Add Activity</button> -->
          </div> */

