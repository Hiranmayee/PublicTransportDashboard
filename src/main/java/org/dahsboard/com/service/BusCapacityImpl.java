package org.dahsboard.com.service;


import org.dahsboard.com.dao.BusDao;
import org.dahsboard.com.model.Bus;
import org.dahsboard.com.model.BusCapacity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum GroupBy {

    RED("red"), GREEN("green"), ORANGE("orange");
    String value;

    GroupBy(String name) {
        value = name;
    }

    String getValue() {
        return value;
    }
}
@Service
public class BusCapacityImpl  {
    @Autowired
    BusDao busDao;
    @Autowired
    BusCapacity busCapacity;

    public String showBusOccupanyDetailsWithColorNearlingCapacity() {
        Map<String,Integer> getMap=showBusOccupanyDetails();
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(1);
        for(int capacity:getMap.values()) {
            int percentage = Integer.parseInt(defaultFormat.format(capacity));
            if (percentage < 30) return GroupBy.GREEN.getValue();
            else if(percentage < 70)  return GroupBy.ORANGE.getValue();
            else if (percentage > 70) return GroupBy.RED.getValue();
        }
        return null;
    }

    public Map<String,Integer> showBusOccupanyDetails(){
        //TODO Get BUS from BusDAO and fetch bus capacity and occupancy details
        String busId = busDao.getAllBuses();
        int availableSeats = (busCapacity.getBusCapacity()-busCapacity.getBusOccupancy());
        Map<String,Integer> occupancyDetails = new HashMap<>();
        occupancyDetails.put(busId,availableSeats);
        return occupancyDetails;
    }
}