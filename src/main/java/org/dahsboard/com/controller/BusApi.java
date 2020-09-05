package org.dahsboard.com.controller;

import org.dahsboard.com.model.Bus;
import org.dahsboard.com.service.BusService;
import org.dahsboard.com.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

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


	@Autowired
    ModelAndView modelAndView;

	@GET
	@Path("/{id}")
	public ModelAndView showBusLocationDetailsOnMap (@PathParam("id") int busId) throws Exception{
		    bus.setBusID(busId);
		    System.out.println(" in controller");
		    modelAndView.setViewName("busLocationView");
      return modelAndView;
	}

    @GET
    @Path("/")
    public String showAllBusesDetails (@PathParam("id") int busId) throws Exception{
        bus.setBusID(busId);

        return busService.getBus(busId);
    }

    /*@GET
    @Path("/{id}")
    public String showDetails(@PathParam("id") int busId) throws Exception{
        bus.setBusID(busId);

        return busService.getBus(busId);
    }*/

    @GET
    @Path("/{id}")
    public String showBusOccupanyDetails (@PathParam("id") int busId) throws Exception{
        bus.setBusID(busId);

        return busService.getBus(busId);
    }

    @GET
    @Path("/{id}")
    public String showBusOccupanyDetailsWithColorNearlingCapacity (@PathParam("id") int busId) throws Exception{
        bus.setBusID(busId);

        return busService.getBus(busId);
    }

    @PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateBustDetails(@PathParam("id") int busId) {
        bus.setBusID(busId);

		//return busService.modifyProduct(bus);
		return "This is in progress";
	}


}
