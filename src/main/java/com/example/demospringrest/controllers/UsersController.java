package com.example.demospringrest.controllers;

import com.example.demospringrest.models.User;
import com.example.demospringrest.services.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;

        this.userService.add(new User("Antonio"));
        this.userService.add(new User("Chula"));
        this.userService.add(new User("Patricia"));
        this.userService.add(new User("Arya"));

    }

    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> listarTodos() {
        return userService.getAll();
    }

    @GET
    @Path("/users/{nombre}")
    @Produces("application/json")
    public User listarUno(@PathParam("nombre") String nombre) {
        return userService.get(nombre);
    }


    @POST
    @Path("/users")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addUser(User user) {
        userService.add(user);

        return Response.created(
                URI.create("/users/" + user.getNombre())
        ).build();
    }


}
