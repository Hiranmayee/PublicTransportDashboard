package org.dahsboard.com.controller;

import org.retail.model.Bus;
import org.retail.service.ProductService;
import org.retail.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(value = "/myRetail/products")
public class BusApi {

    @Autowired
	Bus bus;

	@Autowired
	ProductService productService;

	@Autowired
	RegisterService registerService;


	@GET
	@Path("/{id}")
	public String showProductDetails (@PathParam("id") int productId) throws Exception{
		    bus.setProductId(productId);

		return productService.getProduct(productId);
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateProductDetails(@PathParam("id") int productId) {
		bus.setProductId(productId);

		return productService.modifyProduct(bus);
	}


}
