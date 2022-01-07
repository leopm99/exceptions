package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int room = sc.nextInt();
		System.out.print("Checkin date (dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Checkout date (dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: checkout date must be after checkin date");
		} else {
			Reservation res = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + res);

			System.out.println();
			System.out.println("Enter the data to update the reservation: ");
			System.out.print("Checkin date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());

			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: update dates must be future dates");
			} else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation: checkout date must be after checkin date");
			} else {
				res.updateDates(checkin, checkout);
				System.out.println("Reservation: " + res);
			}

		}

		sc.close();

	}

}
