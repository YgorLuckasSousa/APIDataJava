package Application;

import model.entitites.Reservation;
import model.exceptions.DomainException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner leia = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Room number: ");
            int number = leia.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(leia.next());
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(leia.next());
            Reservation res = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + res);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(leia.next());
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkOut = sdf.parse(leia.next());
            System.out.println("Error in reservation: Check-out date must be after check-in date");
            res.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + res);
        }
        catch (ParseException e){
            System.out.println("INVALID DATE FORMAT! ");
        }
        catch (DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

            leia.close();
        }
    }

