package com.anudip.booking;

import java.util.List;
import java.util.Scanner;

public class MovieBookingApp {
    
    // We create an object of our business logic class
    private static BookingManager manager = new BookingManager();
    // We use a Scanner object to take input from the console
    private static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {
        System.out.println("Welcome to the Console Movie Ticket Booking System!");
        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View All Movies"); // R (Read)
            System.out.println("2. Book Tickets");    // C (Create)
            System.out.println("3. Cancel Booking");  // D (Delete)
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Handle non-integer input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("\nInvalid input. Please enter a number.");
                scanner.nextLine(); // Consume invalid input
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    viewAllMovies();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 4);
        
        scanner.close(); // Close the scanner when the application exits
    }
    
    // Handles the "View All Movies" option
    private static void viewAllMovies() {
        System.out.println("\n--- Available Movies ---");
        // R - Read operation from the manager
        List<Movie> movies = manager.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("No movies currently scheduled.");
            return;
        }
        
        for (Movie movie : movies) {
            // The toString() method in Movie class is used here for clean output
            System.out.println(movie); 
        }
    }
    
    // Handles the "Book Tickets" option
    private static void bookTickets() {
        viewAllMovies(); // Show movies first
        System.out.print("Enter Movie ID to book: ");
        int movieId;
        if (scanner.hasNextInt()) {
            movieId = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid Movie ID.");
            scanner.nextLine();
            return;
        }

        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your Phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter number of seats: ");
        int numSeats;
        if (scanner.hasNextInt()) {
            numSeats = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid number of seats.");
            scanner.nextLine();
            return;
        }
        
        // C - Create operation (Booking logic is inside the Manager)
        Ticket ticket = manager.bookTicket(movieId, name, phone, numSeats);
        
        if (ticket != null) {
            System.out.println("\n*** Your Booking Details ***");
            System.out.println(ticket);
        }
    }
    
    // Handles the "Cancel Booking" option
    private static void cancelBooking() {
        System.out.print("Enter Booking ID to cancel (e.g., BKG1234): ");
        String bookingId = scanner.nextLine();
        
        // D - Delete operation (Cancellation logic is inside the Manager)
        manager.cancelTicket(bookingId);
    }
}