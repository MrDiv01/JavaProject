import java.util.ArrayList;
import java.util.List;

public class HotelSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    // Oda ekleme
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Odaları listeleme
    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Room room : rooms) {
            System.out.println(room.getRoomDetails());
        }
    }

    // Oda müsaitlik kontrolü
    public boolean isRoomAvailable(Room room, String checkInDate, String checkOutDate) {
        for (Booking booking : bookings) {
            if (booking.getRoom().equals(room) && booking.overlaps(new Booking("", "", checkInDate, checkOutDate, room))) {
                return false;
            }
        }
        return true;
    }

    // Oda kiralama
    public Booking bookRoom(String customerName, String contactDetails, String checkInDate, String checkOutDate, int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                if (isRoomAvailable(room, checkInDate, checkOutDate)) {
                    Booking newBooking = new Booking(customerName, contactDetails, checkInDate, checkOutDate, room);
                    bookings.add(newBooking);
                    System.out.println("Booking successful! Booking ID: " + newBooking.getBookingId());
                    return newBooking;
                } else {
                    System.out.println("Room is not available for the selected dates.");
                    return null;
                }
            }
        }
        System.out.println("Room number not found.");
        return null;
    }

    // Rezervasyon iptali
    public boolean cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                bookings.remove(booking);
                System.out.println("Booking canceled successfully!");
                return true;
            }
        }
        System.out.println("Booking ID not found.");
        return false;
    }

    // Tüm rezervasyonları listeleme
    public void listBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
