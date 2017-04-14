package com.thoughtworks.gaia.A.endpoint;

/**
 * Created by cypc on 4/7/17.
 */


import com.thoughtworks.gaia.A.entity.A;
import com.thoughtworks.gaia.A.service.AService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("A")
@Api(value = "A", description = "Access to A resource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AEndPoint {
    @Autowired
    private AService aService;

    @Path("/{A_id}")
    @ApiOperation(value = "Get product by id", response = A.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get product successfully"),
            @ApiResponse(code = 404, message = "No product matches given id")
    })
    @GET
    public Response getA(@PathParam("A_id") Long id) {
        A a = aService.getA(id);
        return Response.ok().entity(a).build();
    }


    @Path("/add")
    @ApiOperation(value = "Get product by id", response = A.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "add product successfully"),
            @ApiResponse(code = 404, message = "No product matches given id")
    })
    @POST
    public Response addA(@HeaderParam("name") String name) {
        A a=new A();
        a.setName(name);
        A a1=aService.addA(a);
        return Response.ok().entity(a1).build();
    }
}
