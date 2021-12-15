package api;

import Service.ReservationService;
import model.Customer;
import Service.CustomerService;
import model.IRoom;
import model.Room;
import model.Reservation;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private void HotelResource(){};
    static HotelResource obj = null;

    public static HotelResource getInstance(){
        if (obj == null){
            obj = new HotelResource();
        }
        return obj;
    }

    public Customer getCustomer (String email){
        return CustomerService.getInstance().getCustomer(email);
    }
    public void createACustomer (String email , String firstName , String lastName){

        CustomerService.getInstance().addCustomer(email,firstName,lastName);
    }

    public Room getRoom (String roomNumber){
        return ReservationService.getInstance().getARoom(roomNumber);
    }
    public Reservation bookARoom (String customerEmail , Room room , Date checkInDate , Date chekOutDate ){
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        return ReservationService.getInstance().reserveARoom(customer,room,checkInDate,chekOutDate);
    }
    public Collection<Room> findARoom (Date chekIn , Date chekOut){
         return ReservationService.getInstance().findRooms(chekIn,chekOut);
    }
    public Collection<Reservation> getCustomersReservations(String customerEmail){
        Customer customer = CustomerService.getInstance().getCustomer(customerEmail);
        return ReservationService.getInstance().getCustomersReservation(customer);

    }

}
