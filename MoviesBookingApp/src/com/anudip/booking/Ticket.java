package com.anudip.booking;

import java.util.ArrayList;

/**
 * The Ticket class represents a single booking transaction.
 */
public class Ticket {
    private String bookingId; // Unique ID for the ticket
    private Movie movie; // The movie the ticket is for
    private Customer customer; // The customer who booked it
    private ArrayList<String> bookedSeats; // Which seats were booked

    // Constructor
    public Ticket(String bookingId, Movie movie, Customer customer, ArrayList<String> bookedSeats) {
        this.bookingId = bookingId;
        this.movie = movie;
        this.customer = customer;
        this.bookedSeats = bookedSeats;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<String> getBookedSeats() {
        return bookedSeats;
    }

    @Override
    public String toString() {
        return "---------------------------------\n" +
               "| Booking ID: " + bookingId + "\n" +
               "| Movie: " + movie.getTitle() + " at " + movie.getShowtime() + "\n" +
               "| Customer: " + customer.getName() + "\n" +
               "| Seats: " + bookedSeats.toString() + "\n" +
               "| Total Seats: " + bookedSeats.size() + "\n" +
               "---------------------------------";
    }
}