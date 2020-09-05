package org.dahsboard.com.model;

import org.springframework.stereotype.Component;

@Component
public class BusCapacity {
    private int busID;
    private int busCapacity;
    private int busOccupancy;


    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }


    public int getBusCapacity() {
        return busCapacity;
    }

    public void setBusCapacity(int busCapacity) {
        this.busCapacity = busCapacity;
    }

    public int getBusOccupancy() {
        return busOccupancy;
    }

    public void setBusOccupancy(int busOccupancy) {
        this.busOccupancy = busOccupancy;
    }


}