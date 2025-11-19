package com.anudip.booking;

import java.util.ArrayList; // Import ArrayList for seats

/**
 * The Movie class represents a single movie show in the theater.
 * It stores movie details and manages the available seats.
 */
public class Movie {
    // 1. Attributes (Properties)
    private int movieId; // Unique identifier for the movie
    private String title;
    private String showtime;
    private int totalSeats;
    // We'll use an ArrayList to track seat numbers (e.g., "A1", "A2", etc.)
    private ArrayList<String> availableSeats; 

    // 2. Constructor (To create a new Movie object)
    // The constructor is called when we write 'new Movie(...)'
    public Movie(int movieId, String title, String showtime, int totalSeats) {
        this.movieId = movieId;
        this.title = title;
        this.showtime = showtime;
        this.totalSeats = totalSeats;
        // Initialize availableSeats with basic seat numbers
        this.availableSeats = new ArrayList<>();
        // For simplicity, let's name seats S1, S2, S3... up to totalSeats
        for (int i = 1; i <= totalSeats; i++) {
            this.availableSeats.add("S" + i);
        }
    }

    // 3. Getters and Setters (Accessor and Mutator Methods)
    // These methods allow us to safely read and modify the private attributes.

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public String getShowtime() {
        return showtime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeatsCount() {
        return availableSeats.size(); // The size of the list tells us how many are left
    }

    public ArrayList<String> getAvailableSeats() {
        return availableSeats;
    }

    // A utility method to represent the Movie object as a readable String
    @Override
    public String toString() {
        return "ID: " + movieId + 
               " | Title: " + title + 
               " | Time: " + showtime + 
               " | Seats Available: " + getAvailableSeatsCount();
    }
}