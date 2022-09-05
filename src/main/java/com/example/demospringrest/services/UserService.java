package com.example.demospringrest.services;

import com.example.demospringrest.models.User;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<User>();

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }

    public User get(String nombre) {
        for (User user : users) {
            if (user.getNombre().equalsIgnoreCase(nombre)) {
                return user;
            }
        }

        return null;
    }

}
