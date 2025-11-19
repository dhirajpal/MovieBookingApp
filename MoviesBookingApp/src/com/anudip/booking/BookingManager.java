package com.anudip.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; // Good practice to use List interface for ArrayList
import java.util.Map; // Good practice to use Map interface for HashMap
import java.util.Random; // To generate simple Booking IDs

public class BookingManager {
    // 1. Collections to store data
    // Stores Movies: Key=Movie ID (Integer), Value=Movie Object
    private Map<Integer, Movie> movies; 
    
    // Stores Tickets: A list of all booked tickets
    private List<Ticket> bookings; 

    // Used for auto-incrementing IDs
    private int nextMovieId = 101;
    private int nextCustomerId = 1;

    // A simple Customer list (optional, but good for tracking all customers)
    private List<Customer> customers;

    // Constructor to initialize the collections
    public BookingManager() {
        this.movies = new HashMap<>(); // Initialize the HashMap
        this.bookings = new ArrayList<>(); // Initialize the ArrayList
        this.customers = new ArrayList<>();
        // Add some initial data (Seeding)
        seedMovies();
    }
    
    // Helper method to add some initial movies
    private void seedMovies() {
        // Create (C) operation: Adding a new movie to the HashMap
        movies.put(nextMovieId, new Movie(nextMovieId++, "Inception", "10:00 AM", 50));
        movies.put(nextMovieId, new Movie(nextMovieId++, "The Matrix", "01:00 PM", 30));
        movies.put(nextMovieId, new Movie(nextMovieId++, "Dune Part 2", "04:00 PM", 60));
    }

    // --- CRUD Operations ---

    // R - Read All Movies
    public List<Movie> getAllMovies() {
        // Returns a new ArrayList containing all the Movie objects from the HashMap values
        return new ArrayList<>(movies.values());
    }
    
    // C - Create (Book) a Ticket
    public Ticket bookTicket(int movieId, String customerName, String customerPhone, int numSeats) {
        // 1. Find the movie (R - Read from HashMap)
        Movie movie = movies.get(movieId);

        if (movie == null) {
            System.out.println("Error: Movie with ID " + movieId + " not found.");
            return null;
        }

        if (movie.getAvailableSeatsCount() < numSeats) {
            System.out.println("Error: Not enough seats available for " + movie.getTitle());
            return null;
        }

        // 2. Create the Customer object
        Customer newCustomer = new Customer(nextCustomerId++, customerName, customerPhone);
        customers.add(newCustomer);

        // 3. Select and remove seats (U - Update the Movie's seat list)
        ArrayList<String> bookedSeats = new ArrayList<>();
        for (int i = 0; i < numSeats; i++) {
            // Get the first available seat and remove it from the movie's list
            String seat = movie.getAvailableSeats().remove(0); 
            bookedSeats.add(seat);
        }

        // 4. Create the Ticket (C - Create the Ticket object)
        String bookingId = generateBookingId();
        Ticket newTicket = new Ticket(bookingId, movie, newCustomer, bookedSeats);

        // 5. Add the Ticket to the booking list (C - Create/Add to ArrayList)
        bookings.add(newTicket);
        
        System.out.println("Booking successful!");
        return newTicket;
    }

    // D - Delete (Cancel) a Ticket
    public boolean cancelTicket(String bookingId) {
        // Find the ticket in the bookings ArrayList (R - Read/Iterate)
        Ticket ticketToRemove = null;
        for (Ticket t : bookings) {
            if (t.getBookingId().equals(bookingId)) {
                ticketToRemove = t;
                break;
            }
        }

        if (ticketToRemove == null) {
            System.out.println("Error: Booking ID " + bookingId + " not found.");
            return false;
        }

        // 1. Return the seats to the movie's available list (U - Update the Movie's seat list)
        Movie movie = ticketToRemove.getMovie();
        movie.getAvailableSeats().addAll(ticketToRemove.getBookedSeats());

        // 2. Remove the ticket from the bookings list (D - Delete from ArrayList)
        bookings.remove(ticketToRemove);
        
        System.out.println("Cancellation successful for Booking ID: " + bookingId);
        return true;
    }
    
    // R - Read a specific booking
    public Ticket getBooking(String bookingId) {
        for (Ticket t : bookings) {
            if (t.getBookingId().equals(bookingId)) {
                return t;
            }
        }
        return null;
    }
    
    // Utility for a simple random ID
    private String generateBookingId() {
        return "BKG" + new Random().nextInt(9000) + 1000;
    }
}