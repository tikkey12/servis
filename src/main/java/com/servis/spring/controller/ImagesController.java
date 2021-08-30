package com.servis.spring.controller;

import com.servis.spring.entity.Images;
import com.servis.spring.repository.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class ImagesController {

    @Autowired
    ImagesRepository imagesRepository;

    @PostMapping("/users/images")
    public ResponseEntity<Images> createImage(@RequestBody Images image) {
        try {
            Images _image = imagesRepository
                    .save(new Images(image.getData()));
            return new ResponseEntity<>(_image, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
