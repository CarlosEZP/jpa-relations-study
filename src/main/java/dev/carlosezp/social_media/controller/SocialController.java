package dev.carlosezp.social_media.controller;

import dev.carlosezp.social_media.entity.SocialUser;
import dev.carlosezp.social_media.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/social/users")
public class SocialController {
    @Autowired
    private SocialService service;

    @GetMapping()
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SocialUser> createUser(@RequestBody SocialUser user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }
}
