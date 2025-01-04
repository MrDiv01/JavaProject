public class Booking {
    private static int idCounter = 1;
    private int bookingId;
    private String customerName;
    private String contactDetails;
    private String checkEntryDate;
    private String checkTheReleaseDate;
    private Room room;

    public Booking(String customerName, String contactDetails, String checkEntryDate, String checkTheReleaseDate, Room room) {
        this.bookingId = idCounter++;
        this.customerName = customerName;
        this.contactDetails = contactDetails;
        this.checkEntryDate = checkEntryDate;
        this.checkTheReleaseDate = checkTheReleaseDate;
        this.room = room;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getcheckEntryDate() {
        return checkEntryDate;
    }

    public String getcheckTheReleaseDate() {
        return checkTheReleaseDate;
    }

    public Room getRoom() {
        return room;
    }

    public boolean overlaps(Booking other) {
        return this.room.getRoomNumber() == other.room.getRoomNumber() &&
                !(this.checkTheReleaseDate.compareTo(other.checkEntryDate) <= 0 || this.checkEntryDate.compareTo(other.checkTheReleaseDate) >= 0);
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
               ", Customer: " + customerName +
               ", Contact: " + contactDetails +
               ", Room: " + room.getRoomNumber() +
               ", Check Entry Date: " + checkEntryDate +
               ", Check The Release Date: " + checkTheReleaseDate;
    }
}
