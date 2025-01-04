public class DeluxeRoom extends Room {
    private double balconySize;
    private String view;

    public DeluxeRoom(int roomNumber, int floor, String occupancyRate, double pricePerNight, double balconySize, String view) {
        super(roomNumber, floor, occupancyRate, pricePerNight);
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
