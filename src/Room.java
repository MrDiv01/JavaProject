public abstract class Room {
    private int roomNumber;
    private int floor;
    private String occupancyRate;
    private double pricePerNight;

    public Room(int roomNumber, int floor, String occupancyRate, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.occupancyRate = occupancyRate;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public String getoccupancyRate() {
        return occupancyRate;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public abstract String getRoomDetails();
}
