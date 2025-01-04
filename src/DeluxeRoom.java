public class DeluxeRoom extends Room {
    private double balconySize;
    private String view;

    public DeluxeRoom(int roomNumber, int floor, String occupancy, double pricePerNight, double balconySize, String view) {
        super(roomNumber, floor, occupancy, pricePerNight);
        this.balconySize = balconySize;
        this.view = view;
    }

    @Override
    public String getRoomDetails() {
        return "Deluxe Room - Room Number: " + getRoomNumber() +
               ", Floor: " + getFloor() +
               ", Balcony Size: " + balconySize + "m2" +
               ", View: " + view +
               ", Price: " + getPricePerNight();
    }
}
