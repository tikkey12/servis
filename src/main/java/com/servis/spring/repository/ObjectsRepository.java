package com.servis.spring.repository;

import com.servis.spring.entity.BDObjects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ObjectsRepository {

    @GetMapping("/")
    public ResponseEntity main() {
        return ResponseEntity.ok("okok");
    }

    @GetMapping("/task")
    public ResponseEntity task() {
        return ResponseEntity.ok(new BDObjects(1l, "ururu"));
    }
}
