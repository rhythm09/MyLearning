public class ExitGate {

    ParkingSpotManagerFactory psm_factory;
    CostComputationFactory cc_factory;
    ExitGate(ParkingSpotManagerFactory psm_factory, CostComputationFactory cc_factory) {
        this.cc_factory = cc_factory;
        this.psm_factory = psm_factory;
    }

    long calculatePrice(Ticket ticket) {
        CostComputation cc = cc_factory.getCostComputation(ticket.vehicle.vehicle_type);


        return cc.price(ticket);
    }



    void removeVehicle(Ticket ticket) {

        ParkingSpotManager ps = psm_factory.getParkingSpotManager(ticket.vehicle.vehicle_type);
        CostComputation cc =cc_factory.getCostComputation(ticket.vehicle.vehicle_type);
        ps.removeVehicle(ticket.parking_spot);
        long price = calculatePrice(ticket);
        System.out.println("Vehicle " + ticket.vehicle.getVehicle_number() + " Price " + price);
    }
}
