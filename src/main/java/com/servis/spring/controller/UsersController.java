package com.servis.spring.controller;

import com.servis.spring.entity.Users;
import com.servis.spring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAllUsers(@RequestParam(required = false) String name) {
        try {
            List<Users> users = new ArrayList<Users>();

            if(name == null)
                users.addAll(usersRepository.findAll());
            else users.addAll(usersRepository.findByName(name));

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") long id) {
        Optional<Users> userData = usersRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        try {
            Users _user = usersRepository
                    .save(new Users(user.getName(), user.getPass()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUsers(@PathVariable("id") long id, @RequestBody Users user) {
        Optional<Users> userData = usersRepository.findById(id);

        if (userData.isPresent()) {
            Users _user = userData.get();
            _user.setName(user.getName());
            _user.setPass(user.getPass());
            return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
