package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	public Reservation() {
		
	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {			
		
		Date now = new Date();
	
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("update dates must be future dates");
		} 
		if (!checkout.after(checkin)) {
			throw new DomainException("checkout date must be after checkin date");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}	

	public Date getCheckout() {
		return checkout;
	}	
	
	public long duration() {
		long diff = (checkout.getTime() - checkin.getTime()); 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);		
	}
	
	public void updateDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Error in reservation: update dates must be future dates");
		} 
		if (!checkout.after(checkin)) {
			throw new DomainException("checkout date must be after checkin date");
		} 
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", checkin: "
						+ sdf.format(checkin) + ", checkout: " + sdf.format(checkout)
						+", " + duration() + " nights";
	}
	
	
	
	

}
