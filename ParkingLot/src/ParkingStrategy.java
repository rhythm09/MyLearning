import java.util.*;

public interface ParkingStrategy {
    public Queue<ParkingSpot> getParkingSpotTypeList();
}

class NearToEntrance implements  ParkingStrategy {
    public Queue<ParkingSpot> getParkingSpotTypeList() {
        return new ArrayDeque<ParkingSpot>();
    }
}

class NearToEntAndElev implements  ParkingStrategy {
    public Queue<ParkingSpot> getParkingSpotTypeList() {
        return new PriorityQueue<ParkingSpot>(new MaxHeapComparator());
    }
}

class NearToExit implements  ParkingStrategy {
    public Queue<ParkingSpot> getParkingSpotTypeList() {
        return new PriorityQueue<ParkingSpot>(new MinHeapComparator());
    }
}

class MaxHeapComparator implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot p1, ParkingSpot p2) {
        if(p1.id < p2.id) {
            return 1;
        }
        else if(p1.id > p2.id) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class MinHeapComparator implements Comparator<ParkingSpot> {
    public int compare(ParkingSpot p1, ParkingSpot p2) {
        if(p1.id > p2.id) {
            return 1;
        }
        else if(p1.id < p2.id) {
            return -1;
        }
        else {
            return 0;
        }
    }
}


