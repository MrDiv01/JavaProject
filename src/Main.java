import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelSystem hotelSystem = new HotelSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Örnek odalar ekleme (admin işlemleri için başlangıç verisi)
        hotelSystem.addRoom(new StandardRoom(101, 1, "Single", 50.0, 2));
        hotelSystem.addRoom(new DeluxeRoom(201, 2, "Double", 120.0, 10.0, "Sea View"));
        hotelSystem.addRoom(new SuiteRoom(301, 3, "Triple", 200.0, 20.0, 2, true));

        while (!exit) {
            System.out.println("\nWelcome to Hotel Booking Management System!");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(hotelSystem, scanner);
                    break;
                case 2:
                    customerMenu(hotelSystem, scanner);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    private static void adminMenu(HotelSystem hotelSystem, Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Room");
            System.out.println("2. Delete Room");
            System.out.println("3. List Rooms");
            System.out.println("4. Generate Booking Report");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (1-Standard, 2-Deluxe, 3-Suite): ");
                    int roomType = scanner.nextInt();
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter floor: ");
                    int floor = scanner.nextInt();
                    System.out.print("Enter occupancy (Single/Double/Triple): ");
                    String occupancy = scanner.next();
                    System.out.print("Enter price per night: ");
                    double price = scanner.nextDouble();

                    if (roomType == 1) {
                        System.out.print("Enter number of windows: ");
                        int windows = scanner.nextInt();
                        hotelSystem.addRoom(new StandardRoom(roomNumber, floor, occupancy, price, windows));
                    } else if (roomType == 2) {
                        System.out.print("Enter balcony size (m2): ");
                        double balconySize = scanner.nextDouble();
                        System.out.print("Enter view (Sea/Landmark/Mountain): ");
                        String view = scanner.next();
                        hotelSystem.addRoom(new DeluxeRoom(roomNumber, floor, occupancy, price, balconySize, view));
                    } else if (roomType == 3) {
                        System.out.print("Enter living area (m2): ");
                        double livingArea = scanner.nextDouble();
                        System.out.print("Enter number of bathrooms: ");
                        int bathrooms = scanner.nextInt();
                        System.out.print("Has kitchenette? (true/false): ");
                        boolean kitchenette = scanner.nextBoolean();
                        hotelSystem.addRoom(new SuiteRoom(roomNumber, floor, occupancy, price, livingArea, bathrooms, kitchenette));
                    } else {
                        System.out.println("Invalid room type!");
                    }
                    System.out.println("Room added successfully!");
                    break;
                case 2:
                    System.out.print("Enter room number to delete: ");
                    int roomToDelete = scanner.nextInt();
                    System.out.println("Room deleted successfully!");
                    break;
                case 3:
                    System.out.println("Listing all rooms:");
                    hotelSystem.listRooms();
                    break;
                case 4:
                    System.out.println("Booking report feature not implemented yet.");
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void customerMenu(HotelSystem hotelSystem, Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. List Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Odaları listele
                    System.out.println("Available Rooms:");
                    hotelSystem.listRooms();
                    break;

                case 2:
                    // Oda kiralama
                    System.out.print("Enter your name: ");
                    scanner.nextLine(); // Buffer temizleme
                    String customerName = scanner.nextLine();

                    System.out.print("Enter your contact details: ");
                    String contactDetails = scanner.nextLine();

                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    String checkInDate = scanner.nextLine();

                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    String checkOutDate = scanner.nextLine();

                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();

                    Booking booking = hotelSystem.bookRoom(customerName, contactDetails, checkInDate, checkOutDate, roomNumber);

                    if (booking != null) {
                        System.out.println("Booking successful!");
                        System.out.println(booking);
                    }
                    break;

                case 3:
                    // Rezervasyonu iptal et
                    System.out.print("Enter booking ID to cancel: ");
                    int bookingId = scanner.nextInt();
                    boolean success = hotelSystem.cancelBooking(bookingId);
                    if (success) {
                        System.out.println("Booking canceled successfully.");
                    } else {
                        System.out.println("Booking ID not found.");
                    }
                    break;

                case 4:
                    // Ana menüye dön
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
