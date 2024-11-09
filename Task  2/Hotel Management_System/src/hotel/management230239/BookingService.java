package hotel.management230239;


// --- SOLID Design Principles applied ---

// ISP: Separate interfaces for different services allow flexibility.
interface BookingService {
    void bookRoom(Customer customer, int roomTypeChoice);
    void displayAvailableRooms();
}