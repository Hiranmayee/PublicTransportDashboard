package org.dahsboard.com.controller;

import org.dahsboard.com.model.Bus;
import org.dahsboard.com.service.BusService;
import org.dahsboard.com.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path(value = "/myDashboard/buses")
public class BusApi {

    @Autowired
	Bus bus;

	@Autowired
	BusService busService;

	@Autowired
	RegisterService registerService;


	@GET
	@Path("/{id}")
	public String showBusDetails (@PathParam("id") int productId) throws Exception{
		    bus.setProductId(productId);

		return busService.getProduct(productId);
	}

    @GET
    @Path("/{id}")
    public String showBusLocationDetailsOnMap (@PathParam("id") int productId) throws Exception{
        bus.setProductId(productId);

        return busService.getProduct(productId);
    }

    @GET
    @Path("/{id}")
    public String showBusOccupanyDetails (@PathParam("id") int productId) throws Exception{
        bus.setProductId(productId);

        return busService.getProduct(productId);
    }

    @GET
    @Path("/{id}")
    public String showBusOccupanyDetailsWithColorNearlingCapacity (@PathParam("id") int productId) throws Exception{
        bus.setProductId(productId);

        return busService.getProduct(productId);
    }

    @PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBustDetails(@PathParam("id") int productId) {
		bus.setProductId(productId);

		//return busService.modifyProduct(bus);
		return "This is in progress";
	}


}
