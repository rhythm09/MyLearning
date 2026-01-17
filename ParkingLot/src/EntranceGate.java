public class EntranceGate {
    ParkingSpotManagerFactory psm_factory;
    EntranceGate(ParkingSpotManagerFactory factory) {
        this.psm_factory = factory;
    }
     ParkingSpot getParkingSpot(VehicleType vt) {
         ParkingSpotManager psm = psm_factory.getParkingSpotManager(vt);
         return psm.findParkingSpace();
     }

     Ticket bookParkingSpot( Vehicle vehicle) {
        ParkingSpot spot = getParkingSpot(vehicle.vehicle_type);
        if(spot == null) {
            System.out.println("Parking is full Ticket is not be generated");
            return null;
        }
        return generateticket(vehicle,spot);

     }

     Ticket generateticket(Vehicle vehicle, ParkingSpot ps) {
        return new Ticket(System.currentTimeMillis(),vehicle,ps);
     }
}
