public class Ticket {

    long entry_time;
    Vehicle vehicle;
    ParkingSpot parking_spot;

    public Ticket(long entry_time, Vehicle vehicle, ParkingSpot parking_spot) {
        this.entry_time = entry_time;
        this.vehicle = vehicle;
        this.parking_spot = parking_spot;
    }
}
