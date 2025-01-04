public class StandardRoom extends Room {
    private int numberOfWindows;

    public StandardRoom(int roomNumber, int floor, String occupancyRate, double pricePerNight, int numberOfWindows) {
        super(roomNumber, floor, occupancyRate, pricePerNight);
        this.numberOfWindows = numberOfWindows;
    }

    @Override
    public String getRoomDetails() {
        return "Standard Room - Room Number: " + getRoomNumber() +
               ", Floor: " + getFloor() +
               ", Windows: " + numberOfWindows +
               ", Price: " + getPricePerNight();
    }
}
