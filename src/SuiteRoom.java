public class SuiteRoom extends Room {
    private double livingArea;
    private int numberOfBathrooms;
    private boolean hasKitchenette;

    public SuiteRoom(int roomNumber, int floor, String occupancy, double pricePerNight, double livingArea, int numberOfBathrooms, boolean hasKitchenette) {
        super(roomNumber, floor, occupancy, pricePerNight);
        this.livingArea = livingArea;
        this.numberOfBathrooms = numberOfBathrooms;
        this.hasKitchenette = hasKitchenette;
    }

    @Override
    public String getRoomDetails() {
        return "Suite Room - Room Number: " + getRoomNumber() +
               ", Floor: " + getFloor() +
               ", Living Area: " + livingArea + "m2" +
               ", Bathrooms: " + numberOfBathrooms +
               ", Kitchenette: " + (hasKitchenette ? "Yes" : "No") +
               ", Price: " + getPricePerNight();
    }
}
