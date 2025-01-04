public class Booking {
    private static int idCounter = 1; // Rezervasyon ID'si için otomatik artış
    private int bookingId;
    private String customerName;
    private String contactDetails;
    private String checkInDate;
    private String checkOutDate;
    private Room room; // Hangi odanın rezerve edildiğini tutar

    public Booking(String customerName, String contactDetails, String checkInDate, String checkOutDate, Room room) {
        this.bookingId = idCounter++; // Her rezervasyon için benzersiz ID
        this.customerName = customerName;
        this.contactDetails = contactDetails;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
    }

    // Getter metotları
    public int getBookingId() {
        return bookingId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    // Tarih çakışması kontrolü
    public boolean overlaps(Booking other) {
        // Basit tarih kontrolü
        return this.room.getRoomNumber() == other.room.getRoomNumber() && // Aynı oda mı?
                !(this.checkOutDate.compareTo(other.checkInDate) <= 0 || this.checkInDate.compareTo(other.checkOutDate) >= 0);
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId +
               ", Customer: " + customerName +
               ", Contact: " + contactDetails +
               ", Room: " + room.getRoomNumber() +
               ", Check-In: " + checkInDate +
               ", Check-Out: " + checkOutDate;
    }
}
