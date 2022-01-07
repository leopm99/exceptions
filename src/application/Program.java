package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			System.out.print("Checkin date (dd/mm/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (dd/mm/yyyy): ");
			Date checkout = sdf.parse(sc.next());

			Reservation res = new Reservation(room, checkin, checkout);
			System.out.println("Reservation: " + res);

			System.out.println();
			System.out.println("Enter the data to update the reservation: ");
			System.out.print("Checkin date (dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Checkout date (dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());

			res.updateDates(checkin, checkout);
			System.out.println("Reservation: " + res);
		} catch (ParseException e) {
			System.out.println("Invalid date format.");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		sc.close();

	}

}
