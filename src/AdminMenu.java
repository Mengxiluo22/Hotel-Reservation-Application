import java.util.*;

import api.AdminResource;
import com.sun.tools.javac.Main;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

public class AdminMenu {
    public static void AdminMenu() {
        boolean keepRunning = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (keepRunning) {
                System.out.println("1.See all Customers");
                System.out.println("2.See all Rooms");
                System.out.println("3.See all Reservation");
                System.out.println("4.Add a Room");
                System.out.println("5.Back to MainManu");
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


                if (selection == 1) {
                    Collection<Customer> customers = AdminResource.getInstance().getAllCustomer();
                    for (Customer customer:customers){
                        System.out.println(customer.toString());
                    }

                }
                if (selection == 2) {
                    Collection<Room> allRooms = AdminResource.getInstance().getAllRooms();
                    for (Room room: allRooms){
                        String toprint =room.toString();
                        System.out.println(toprint);
                    }
                }
                if (selection == 3) {
                    AdminResource.getInstance().displayAllReservations();
                }
                if (selection == 4) {
                    Boolean addRoomContinue = true;
                    ArrayList<Room> newRooms = new ArrayList<Room>();
                    while (addRoomContinue == true) {
                        System.out.println("Please enter the Room number");
                        String roomID = scanner.nextLine();
                        System.out.println("Please enter the Room Price");
                        Double price = Double.parseDouble(scanner.nextLine());
                        System.out.println("Please enter the Room type 1/2: 1:single,2:double");
                        Integer Roomtype = Integer.parseInt(scanner.nextLine());
                        RoomType enumeration = null;
                        if (Roomtype == 1) {
                            enumeration = RoomType.SINGLE;
                        } else if (Roomtype == 2) {
                            enumeration = RoomType.DOUBLE;
                        } else {
                            throw new IllegalArgumentException("in valid room type");
                        }
                        Room newRoom = new Room(roomID, price, enumeration);
                        newRooms.add(newRoom);
                        System.out.println("Do you want to add more rooms? Y/N");
                        String wantAddRoom = scanner.nextLine();

                        if (Objects.equals(wantAddRoom, "N")){
                            addRoomContinue = false;
                        }


                    }
                    AdminResource.getInstance().addRoom(newRooms);
                }
                if (selection == 5){
                    MainMenu.MainMenu();

                }


            }
        }
    }
}
