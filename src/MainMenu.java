import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import api.HotelResource;
import model.Customer;
import model.Reservation;
import model.Room;

public class MainMenu {
    public static void MainMenu(){
        boolean keepRunning = true;
                Scanner scanner = new Scanner(System.in);
                while (keepRunning) {
                    System.out.println("1.Find and reserve a room");
                    System.out.println("2.See my reservations");
                    System.out.println("3.Create an account");
                    System.out.println("4.Admin");
                    System.out.println("5.Exit");
                    String input = null;
                    int selection = 0;
                    try{
                         input = scanner.nextLine();
                         selection = Integer.parseInt(input);

                    }catch(Exception e){
                        System.out.println("in valid input");
                        continue;}

                    if (!Arrays.asList("1", "2", "3", "4", "5").contains(input)) {
                        System.out.println("in valid input");
                    }

                    switch (selection) {
                        case 1:
                            System.out.println("Enter CheckIn Date mm/dd/yyyy");
                            String sCheckInDate = scanner.nextLine();
                            Date checkInDate = null;
                            Date checkOutDate = null;
                            try {
                                checkInDate = new SimpleDateFormat("MM/dd/yyyy").parse(sCheckInDate);
                            } catch (IllegalArgumentException | ParseException ex) {
                                System.out.println("date is invalid");
                                continue;
                            }
                            System.out.println("Enter CheckOut Date mm/dd/yyyy");
                            String sCheckOutDate = scanner.nextLine();
                            try {
                                checkOutDate = new SimpleDateFormat("MM/dd/yyyy").parse(sCheckOutDate);
                            } catch (IllegalArgumentException | ParseException ex) {
                                System.out.println("date is invalid");
                                continue;
                            }
                            Collection<Room> foundRooms = new ArrayList<>(HotelResource.getInstance().findARoom(checkInDate, checkOutDate));
                            if (foundRooms.size() == 0) {
                                System.out.println("no room available");
                                continue;
                            }
                            for (Room room : foundRooms) {
                                String toprint = room.toString();
                                System.out.println(toprint);
                            }

                            if (foundRooms.size() > 0) {
                                System.out.println("do you want to book a room? Y/N");
                                String wantToBook = scanner.nextLine();
                                if (Objects.equals(wantToBook, "Y")) {
                                    System.out.println("do you have an account? Y/N");
                                    String haveAaccound = scanner.nextLine();
                                    if (Objects.equals(haveAaccound, "Y")) {
                                        System.out.println("please enter your email");
                                        String email = scanner.nextLine();
                                        System.out.println("please enter the room number you would like to book");
                                        String roomID = scanner.nextLine();
                                        Room room_get = HotelResource.getInstance().getRoom(roomID);
                                        System.out.println(room_get.toString());
                                        if (!foundRooms.contains(room_get)) {
                                            System.out.println("this room is not available");
                                            continue;
                                        }
                                        Reservation newReservation = HotelResource.getInstance().bookARoom(email, room_get, checkInDate, checkOutDate);
                                        System.out.println(newReservation.toString());
                                        continue;
                                    } else if (Objects.equals(haveAaccound, "N")) {
                                        System.out.println("Enter your First Name");
                                        String firstName = scanner.nextLine();
                                        System.out.println("Enter your Last Name");
                                        String lastName = scanner.nextLine();
                                        System.out.println("Enter your Last email");
                                        String email_2 = scanner.nextLine();
                                        HotelResource.getInstance().createACustomer(email_2, firstName, lastName);
                                        System.out.println("Your account is created");
                                    }
                                } else if (Objects.equals(wantToBook, "N")) {
                                    continue;
                                } else {
                                    throw new IllegalArgumentException("Error, Invalid input");
                                }


                            }
                            break;

                        case 2:
                            System.out.println("please enter your email");
                            String email = scanner.nextLine();
                            Collection<Reservation> reservations = HotelResource.getInstance().getCustomersReservations(email);
                            if (reservations == null) {
                                System.out.println("no reservation is found");
                                continue;
                            }
                            for (Reservation reservation : reservations) {
                                System.out.println(reservation.toString());
                            }
                            break;


                        case 3:
                            System.out.println("Enter your First Name");
                            String firstName = scanner.nextLine();
                            System.out.println("Enter your Last Name");
                            String lastName = scanner.nextLine();
                            System.out.println("Enter your Last email");
                            String email_2 = scanner.nextLine();
                            HotelResource.getInstance().createACustomer(email_2, firstName, lastName);
                            System.out.println("Your account is created");
                            break;


                        case 4:
                            AdminMenu.AdminMenu();
                            break;

                        case 5:
                            System.exit(0);
                            break;


                    }
                }



    }

}
