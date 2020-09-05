package org.dahsboard.com.model;

import org.springframework.stereotype.Component;

@Component
public class BusCapacity {

    private double productPrice;
    private String productCurrency;

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
