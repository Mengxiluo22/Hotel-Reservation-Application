# Hotel-Reservation-Application
This is a java application for a hotel breservation system. The goal was to create a hotel application which allows users to book and manage room reservations. 

https://user-images.githubusercontent.com/89999225/150012353-eb1cd08d-2405-40c5-b9d2-d2a31f4316c5.mp4

## User Scenarios
The application provides four user scenarios:

1. <b>Creating a customer account</b>: The user needs to first create a customer account before they can create a reservation.

2. <b>Searching for rooms</b>: The app should allow the user to search for available rooms based on provided checkin and checkout dates. If the application has available rooms for the specified date range, a list of the corresponding rooms will be displayed to the user for choosing.

3. <b>Booking a room</b>: Once the user has chosen a room, the app will allow them to book the room and create a reservation.

4. <b>Viewing reservations</b>: After booking a room, the app allows customers to view a list of all their reservations.

## Admin Scenarios
The application provides four administrative scenarios:

1. <b>Displaying all customers accounts</b>.
2. <b>Viewing all of the rooms in the hotel</b>.
3. <b>Viewing all of the hotel reservations</b>.
4. <b>Adding a room to the hotel application</b>.

## Reserving a Room
The application allows customers to reserve a room.
1. <b>Avoid conflicting reservations</b>: A single room may only be reserved by a single customer per a checkin and checkout date range.

### Room Requirements
<b>Room cost</b>: Rooms will contain a price per night. When displaying rooms, paid rooms will display the price per night and free rooms will display "Free" or have a $0 price.
<b>Unique room numbers</b>: Each room will have a unique room number, meaning that no two rooms can have the same room number.
<b>Room type</b>: Rooms can be either single occupant or double occupant (Enumeration: SINGLE, DOUBLE).

### Customer Requirements
The application will have customer accounts. Each account has:

1. <b>A unique email for the customer</b>: RegEx is used to check that the email is in the correct format (i.e., name@domain.com).
2. <b>A first name and last name</b>.
3. The email RegEx is simple for the purpose of this exercise and may not cover all real-world valid emails. 


