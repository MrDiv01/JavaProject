import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelSystem hotelSystem = initializeHotelSystem();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("\nWelcome to Hotel Booking Management System!");
                System.out.println("1. Admin Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");

                switch (scanner.nextInt()) {
                    case 1 -> adminMenu(hotelSystem, scanner);
                    case 2 -> customerMenu(hotelSystem, scanner);
                    case 3 -> {
                        exit = true;
                        System.out.println("Exiting... Thank you!");
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }
        }
    }

    private static HotelSystem initializeHotelSystem() {
        HotelSystem hotelSystem = new HotelSystem();
        hotelSystem.addRoom(new StandardRoom(101, 1, "Single", 50.0, 2));
        hotelSystem.addRoom(new DeluxeRoom(201, 2, "Double", 120.0, 10.0, "Sea View"));
        hotelSystem.addRoom(new SuiteRoom(301, 3, "Triple", 200.0, 20.0, 2, true));
        return hotelSystem;
    }

    private static void adminMenu(HotelSystem hotelSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Room");
            System.out.println("2. List Rooms");
            System.out.println("3. Back to Main Menu");
            System.out.print("Select an option: ");

            switch (scanner.nextInt()) {
                case 1 -> addRoom(hotelSystem, scanner);
                case 2 -> {
                    System.out.println("Listing all rooms:");
                    hotelSystem.listRooms();
                }
                case 3 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addRoom(HotelSystem hotelSystem, Scanner scanner) {
        System.out.print("Enter room type (1-Standard, 2-Deluxe, 3-Suite): ");
        int roomType = scanner.nextInt();

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        System.out.print("Enter floor: ");
        int floor = scanner.nextInt();

        System.out.print("Enter occupancy rate (Single/Double/Triple): ");
        String occupancyRate = scanner.next();

        System.out.print("Enter price per night: ");
        double price = scanner.nextDouble();

        switch (roomType) {
            case 1 -> {
                System.out.print("Enter number of windows: ");
                int windows = scanner.nextInt();
                hotelSystem.addRoom(new StandardRoom(roomNumber, floor, occupancyRate, price, windows));
            }
            case 2 -> {
                System.out.print("Enter balcony size (m2): ");
                double balconySize = scanner.nextDouble();
                System.out.print("Enter view (Sea/Landmark/Mountain): ");
                String view = scanner.next();
                hotelSystem.addRoom(new DeluxeRoom(roomNumber, floor, occupancyRate, price, balconySize, view));
            }
            case 3 -> {
                System.out.print("Enter living area (m2): ");
                double livingArea = scanner.nextDouble();
                System.out.print("Enter number of bathrooms: ");
                int bathrooms = scanner.nextInt();
                System.out.print("Has kitchenette? (true/false): ");
                boolean kitchenette = scanner.nextBoolean();
                hotelSystem.addRoom(new SuiteRoom(roomNumber, floor, occupancyRate, price, livingArea, bathrooms, kitchenette));
            }
            default -> System.out.println("Invalid room type!");
        }
        System.out.println("Room added successfully!");
    }

    private static void customerMenu(HotelSystem hotelSystem, Scanner scanner) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. List Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Available Rooms:");
                    hotelSystem.listRooms();
                }
                case 2 -> bookRoom(hotelSystem, scanner);
                case 3 -> cancelBooking(hotelSystem, scanner);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void bookRoom(HotelSystem hotelSystem, Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter your contact details: ");
        String contactDetails = scanner.nextLine();

        System.out.print("Enter entry date (yyyy-mm-dd): ");
        String checkEntryDate = scanner.nextLine();

        System.out.print("Enter release date (yyyy-mm-dd): ");
        String checkTheReleaseDate = scanner.nextLine();

        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();

        Booking booking = hotelSystem.bookRoom(customerName, contactDetails, checkEntryDate, checkTheReleaseDate, roomNumber);
        if (booking != null) {
            System.out.println("Booking successful!");
            System.out.println(booking);
        }
    }

    private static void cancelBooking(HotelSystem hotelSystem, Scanner scanner) {
        System.out.print("Enter booking ID to cancel: ");
        int bookingId = scanner.nextInt();
        if (hotelSystem.cancelBooking(bookingId)) {
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }
}