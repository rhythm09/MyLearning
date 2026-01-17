import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

abstract public class ParkingSpotManager {

    Queue<ParkingSpot> list;
    ParkingStrategy parkingStrategy;
    ParkingSpotManager(ParkingStrategy ps) {
        this.parkingStrategy = ps;
        this.list = ps.getParkingSpotTypeList();
    }
    ParkingSpot    findParkingSpace() {
        ParkingSpot spot = null;
        while(!this.list.isEmpty() && (this.list.peek().getIs_empty() == false || this.list.peek().getIs_valid() == false)) {
            this.list.remove();
        }
        if(!this.list.isEmpty()) {
            spot = this.list.peek();
        }
        return spot;

    }
     void addParkingSpace(ParkingSpot parkingSpot) {
            parkingSpot.setIs_valid(true);
            this.list.add(parkingSpot);

     }
    void removeParkingSpace(ParkingSpot parkingSpot) {
        parkingSpot.setIs_valid(false);
    }
     void parkVehicle(Vehicle vehicle) {
        ParkingSpot ps = this.findParkingSpace();
        if(ps == null) {
            System.out.println("Sorry all slots are full");
            return;
        }

        if(ps.parkVehicle(vehicle) == true) {
            this.list.remove();
        }
    }
    void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
        this.addParkingSpace(spot);
    }

}

class TwoWheelerParkingSpotManager extends  ParkingSpotManager {
    TwoWheelerParkingSpotManager() {
        super(new NearToEntAndElev());
    }
}

class FourWheelerParkingSpotManager extends  ParkingSpotManager {
    FourWheelerParkingSpotManager() {
        super(new NearToExit());
    }
}

class ParkingSpotManagerFactory {
    ParkingSpotManager getParkingSpotManager(VehicleType vt) {
        ParkingSpotManager psm = switch (vt) {
            case TwoWheeler -> new TwoWheelerParkingSpotManager();
            default -> new FourWheelerParkingSpotManager();
        };
        return psm;
    }
}

