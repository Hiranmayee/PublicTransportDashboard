package org.dahsboard.com.service;

import org.dahsboard.com.dao.BusDao;
import org.dahsboard.com.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class BusService {


    @Autowired
    Bus bus;

    @Autowired
    BusDao busDao;


    public String getBus(int busId) {
        return busDao.getSelectiveBus(busId);
    }

    public String getAllProduct() {

        return busDao.getAllBuses();
        //return "Empty as per now";
    }



}


