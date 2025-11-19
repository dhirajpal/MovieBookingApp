[README.md](https://github.com/user-attachments/files/23619968/README.md)

# Movie Ticket Booking System (Java)

A structured console-based Java application that simulates a real movie ticket booking workflow.  
The project demonstrates Object-Oriented Programming, modular class design, and Java Collections usage to manage movies, customers and ticket bookings.

## Introduction
This project is designed as a simple but complete ticket booking platform.  
It includes operations such as movie listing, ticket booking, customer registration and booking history display.  
The design ensures easy readability, extensibility and maintenance.

## Project Objectives
- Build a real-world movie booking simulation using Java.
- Demonstrate OOP concepts including classes, objects and encapsulation.
- Use Java Collections Framework (ArrayList and HashMap) for data handling.
- Provide a clean modular structure suitable for academic or beginner projects.

## System Architecture
The application is divided into four major components:

1. Movie Module  
Handles movie creation, storing and displaying movie details.  
Includes fields like movie ID, name and price.

2. Customer Module  
Manages customer information and registration.

3. Ticket Module  
Represents a booked ticket with auto-generated ticket ID, movie info, customer info and amount.

4. Booking Manager  
Connects all modules and performs operations:
- View movie
- Add customer
- Book ticket
- Cancel Booking

## Features (Detailed)

### Movie Features 
- Display available movies 
- Display available seats 
- Validate movie selection before booking  

### Customer Features
- Register customers  
- Maintain customer records and seats

### Ticket Booking Features
- Auto-generate ticket ID  
- Validate movie and customer    
- Store booking history  

### Booking History
- See all booked tickets  
- Shows ticket ID, movie, customer and seats  

## Project Structure
Project folder contains:
MovieBookingApp.java  
BookingManager.java  
Movie.java  
Customer.java  
Ticket.java  
README.md  
Synopsis.pdf  

## Technologies Used
- Java 8 or above  
- Java Collections Framework  

## How to Run
To compile:
javac *.java

To run:
java MovieBookingApp

## Future Improvement Ideas
- Add GUI using JavaFX or Swing  
- Add database storage  
- Add seat mapping  
- Add payment simulation  
- Create admin login panel  

## Author
Dhiraj Pal
