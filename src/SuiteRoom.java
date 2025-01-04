public class SuiteRoom extends Room {
    private double livingArea;
    private int numberOfBathrooms;
    private boolean hasKitchenette;

    public SuiteRoom(int roomNumber, int floor, String occupancyRate, double pricePerNight, double livingArea, int numberOfBathrooms, boolean hasKitchenette) {
        super(roomNumber, floor, occupancyRate, pricePerNight);
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
