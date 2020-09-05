package org.dahsboard.com.service;

import org.retail.dao.BusDao;
import org.retail.model.Bus;
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


    public String getProduct(int productID) {
        return busDao.getSelectiveProduct(productID);
    }

    public String getAllProduct() {
        return busDao.getAllProducts();
    }

    public String modifyProduct(Bus bus) {
        return busDao.putProduct(bus);
    }


}


