package com.ajaxproject.service;

import com.ajaxproject.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class UserService {

    private List<User> users;

    public List<User> findByUsernameOrEmail(String username){
        List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());

        return result;
    }

    @PostConstruct
    private void initDataForTesting(){

        users = new ArrayList<>();

        User u1 = new User("JohnDoe", "pw123", "johndoe@gmail.com");
        User u2 = new User("JohnJones", "pw321", "jjones@gmail.com");
        User u3 = new User("JaneDoe", "123pw", "janedoe@gmail.com");

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

}
