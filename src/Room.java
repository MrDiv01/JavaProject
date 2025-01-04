public abstract class Room {
    private int roomNumber;
    private int floor;
    private String occupancy;
    private double pricePerNight;

    public Room(int roomNumber, int floor, String occupancy, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.occupancy = occupancy;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public abstract String getRoomDetails();
}
