

abstract public class ParkingSpot {
    int id;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    Vehicle vehicle;
    int price;
    Boolean is_empty;
    static int random_id;

    public Boolean getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Boolean is_valid) {
        this.is_valid = is_valid;
    }

    Boolean is_valid;


    public Boolean getIs_empty() {
        return is_empty;
    }

    public void setIs_empty(Boolean is_empty) {
        this.is_empty = is_empty;
    }

    ParkingSpot() {
        this.is_empty = true;
        this.id = ParkingSpot.getNextId();
    }

    public static int getNextId() {
        return ParkingSpot.random_id++;
    }



    public abstract Boolean parkVehicle(Vehicle vehicle);

    public void removeVehicle() {
       this.vehicle = null;
       this.is_empty = true;
    }

}

class TwoWheelerParkingSpot extends  ParkingSpot {
    TwoWheelerParkingSpot() {
        super();
    }

    @Override
    public  Boolean parkVehicle(Vehicle vehicle) {
        if(vehicle.getVehicle_type() == VehicleType.TwoWheeler) {
            this.vehicle = vehicle;
            this.is_empty = false;
            System.out.println("Vehicle " + vehicle.getVehicle_number() + " is parked at id " + this.id);
            return true;
        }
        else {
            System.out.println("Wrong Vehicle came Please choose different Parking Spot");
            return false;
        }
    }


}

class FourWheelerParkingSpot extends  ParkingSpot {
    FourWheelerParkingSpot() {
        super();
    }

    @Override
    public  Boolean parkVehicle(Vehicle vehicle) {
        if(vehicle.getVehicle_type() == VehicleType.FourWheeler) {
            this.vehicle = vehicle;
            this.is_empty = false;
            System.out.println("Vehicle " + vehicle.getVehicle_number() + " is parked at id " + this.id);
            return true;
        }
        else {
            System.out.println("Wrong Vehicle came Please choose different Parking Spot");
            return false;
        }
    }


}
