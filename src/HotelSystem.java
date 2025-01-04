import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class HotelSystem {
    private final List<Room> rooms = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            rooms.forEach(room -> System.out.println(room.getRoomDetails()));
        }
    }

    public boolean isRoomAvailable(Room room, String checkEntryDate, String checkTheReleaseDate) {
        return bookings.stream()
                .noneMatch(booking -> booking.getRoom().equals(room) &&
                        booking.overlaps(new Booking("", "", checkEntryDate, checkTheReleaseDate, room)));
    }

    public Booking bookRoom(String customerName, String contactDetails, String checkEntryDate, String checkTheReleaseDate, int roomNumber) {
        // Validate dates
        LocalDate entryDate;
        LocalDate releaseDate;

        try {
            entryDate = LocalDate.parse(checkEntryDate);
            releaseDate = LocalDate.parse(checkTheReleaseDate);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Please use yyyy-MM-dd.");
            return null;
        }

        if (releaseDate.isBefore(entryDate)) {
            System.out.println("Release date cannot be before entry date.");
            return null;
        }

        Room room = findRoomByNumber(roomNumber);
        if (room == null) {
            System.out.println("Room number not found.");
            return null;
        }

        if (!isRoomAvailable(room, checkEntryDate, checkTheReleaseDate)) {
            System.out.println("Room is not available for the selected dates.");
            return null;
        }

        Booking newBooking = new Booking(customerName, contactDetails, checkEntryDate, checkTheReleaseDate, room);
        bookings.add(newBooking);
        System.out.println("Booking successful! Booking ID: " + newBooking.getBookingId());
        return newBooking;
    }

    public boolean cancelBooking(int bookingId) {
        Booking bookingToCancel = findBookingById(bookingId);
        if (bookingToCancel == null) {
            System.out.println("Booking ID not found.");
            return false;
        }

        bookings.remove(bookingToCancel);
        System.out.println("Booking canceled successfully!");
        return true;
    }

    public void listBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
        } else {
            bookings.forEach(System.out::println);
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        return rooms.stream()
                .filter(room -> room.getRoomNumber() == roomNumber)
                .findFirst()
                .orElse(null);
    }

    private Booking findBookingById(int bookingId) {
        return bookings.stream()
                .filter(booking -> booking.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);
    }
}