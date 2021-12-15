package model;

public class FreeRoom extends Room {
    private String roomNumber;
    private Double price;
    private RoomType enumeration;

    public FreeRoom(String roomNumber, double price, RoomType enumeration) {
        super(roomNumber, price, enumeration);
        this.price = 0.0;
        this.roomNumber = roomNumber;
        this.enumeration = enumeration;
        }
    @Override
    public String toString() {
        return roomNumber + " " + this.price + " " + enumeration;

    }

}
