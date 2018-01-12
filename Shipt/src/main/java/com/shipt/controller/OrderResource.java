package com.shipt.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import com.shipt.dto.User;
import com.shipt.entity.Order;
import com.shipt.service.OrderService;


@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
	
	@Autowired
    private OrderService orderService;
	
	@GET
	public List<User> get() {
		List<User> list = new ArrayList<>();
		User user = new User();
		user.setUserId(1);
		user.setUserName("balu");
		list.add(user);
		return list;
	}
	
	/*@GET
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	*/
	
	@GET
	@Path("/{orderId}")
	public Order get(@PathParam("orderId") Long orderId) {
		return orderService.find(orderId);
	}
	
	@GET
	@Path("/customer/{customerId}")
	public List<Order> getOrders(@PathParam("customerId") Long customerId){
		return orderService.findByCustomerId(customerId);
	}


	@POST
	public Response create(Order order, @Context UriInfo uriInfo) throws URISyntaxException {
		Order newOrder=orderService.save(order);
		String newId = String.valueOf(newOrder.getOrderId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newOrder).build();
	}
	
	@PUT
	@Path("/{orderId}/{orderStatus}")
	public Order update(@PathParam("orderId") Long orderId,
						@PathParam("orderStatus") String orderStatus, Order order) {
		return orderService.update(order, orderId, orderStatus);
	}
	
	@DELETE
	@Path("/{orderId}")
	public Order delete(@PathParam("orderId") Long orderId) {
		return orderService.delete(orderId);
	}
	
	
}
