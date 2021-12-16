package Service;
import model.Customer;
import model.Reservation;
import model.Room;
import java.util.*;

public class ReservationService {


    private final Map<String,Room> allRooms= new HashMap<>();
    private final Map<Customer,Collection<Reservation>> allReservatoin = new HashMap<>();
    void ReservationService(){};
    static ReservationService obj = null;

    public static ReservationService getInstance(){
        if (obj == null){
            obj = new ReservationService();
        }
        return obj;
    }



    public void addRoom(Room room){
        allRooms.put(room.getRoomNumber(),room);

    }
    public  Collection<Room> getAllRoom(){
        return(allRooms.values());
    }
    public Room getARoom(String roomId){
        Room findroom = null;
        for (Map.Entry<String,Room> entry : allRooms.entrySet()) {
            if (Objects.equals(entry.getKey(), roomId)) {
               findroom = entry.getValue();


            }
        }
        return findroom;
    }

    public Reservation reserveARoom(Customer customer, Room room, Date checkInDate, Date checkOutDate){
        Reservation new_Reservation= new Reservation(customer,room,checkInDate,checkOutDate);
        if (allReservatoin.containsKey(customer)){
            allReservatoin.get(customer).add(new_Reservation);
        }
        else{
            ArrayList<Reservation> temp = new ArrayList<>();
            temp.add(new_Reservation);
            allReservatoin.put(customer, temp);}

        return new_Reservation;
    }

    public Collection<Room> findRooms(Date checkInDate,Date checkOutDate){
        ArrayList<Room>  reservedRooms = new ArrayList<Room>();
        ArrayList<Room> foundedRooms = new ArrayList<Room>();
        for (Map.Entry<Customer,Collection<Reservation>> listEntry: allReservatoin.entrySet()){
            for (Reservation reserved: listEntry.getValue()){
                if ((reserved.getCheckInDate().compareTo(checkInDate)>= 0 && reserved.getCheckInDate().compareTo(checkOutDate)<= 0) || (reserved.getCheckOutDate().compareTo(checkInDate)>=0 && reserved.getCheckOutDate().compareTo(checkOutDate)<=0)) {
                    reservedRooms.add(reserved.getRoom());
                }
            }
        }

        for (Room room:allRooms.values()){
            if (!reservedRooms.contains(room)){
                foundedRooms.add(room);
            }
        }
        return foundedRooms;

    }
    public Collection<Reservation>getCustomersReservation(Customer customer){
        return allReservatoin.get(customer);

    }
    public void distplayAllReservation(){
        for (Map.Entry<Customer,Collection<Reservation>> listEntry: allReservatoin.entrySet()){
            for (Reservation reserved: listEntry.getValue()){

                System.out.println(reserved.toString());

                }
            }


    }

}
