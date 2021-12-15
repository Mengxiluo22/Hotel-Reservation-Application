package api;
import Service.ReservationService;
import model.Customer;
import Service.CustomerService;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AdminResource {
    private void AdminResource(){};
    static AdminResource obj = null;

    public static AdminResource getInstance(){
        if (obj == null){
            obj = new AdminResource();
        }
        return obj;
    }

    public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }


    public void addRoom (List<Room> rooms){
        for (Room room:rooms){
            ReservationService.getInstance().addRoom(room);
        }
    }




    public Collection<Room> getAllRooms(){
        return ReservationService.getInstance().getAllRoom();
    }

    public Collection<Customer>getAllCustomer(){
        return CustomerService.getInstance().getAllCustomers();
    }


    public void displayAllReservations(){
        ReservationService.getInstance().distplayAllReservation();
    }


}
