package Algorithm.LeetCode.LeetCode_1603_Design_Parking_System;

import java.util.HashMap;
import java.util.Map;

class ParkingSystem {
    Map<Integer, Integer> parkingLot;

    public ParkingSystem(int big, int medium, int small) {
        parkingLot = new HashMap<>();
        parkingLot.put(1, big);
        parkingLot.put(2, medium);
        parkingLot.put(3, small);
    }

    public boolean addCar(int carType) {
        int space = parkingLot.get(carType);

        if (space > 0) {
            parkingLot.put(carType, space - 1);

            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
