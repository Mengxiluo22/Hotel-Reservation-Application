package model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Reservation {
    private Customer customer;
    private Room room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer,Room room,Date checkInDate,Date checkOutDate){
        this.setCheckInDate(checkInDate);
        this.setCustomer(customer);
        this.setRoom(room);
        this.setCheckOutDate(checkOutDate);

    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Name: "+ customer.getFirstName()+ " " + customer.getLastName()+ "; room:"+room.getRoomNumber() + "; check in:" + sdf.format(checkInDate) +"; check out:" + sdf.format(checkOutDate);
    }


}
