package com.spacetokens.spacetokensapp.controllers;

import com.spacetokens.spacetokensapp.entities.Capsule;
import com.spacetokens.spacetokensapp.services.CapsuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/capsules")
public class CapsuleController {

    //depend. injection --> only one in an application; it is injected into different areas but all use the same thing
    private final CapsuleService capsuleService;

    public CapsuleController(CapsuleService capsuleService){
        this.capsuleService = capsuleService;
    }

    @PostMapping("/new")
    public ResponseEntity<Capsule> createNewCapsule(@RequestParam String capsuleName,
                                                    @RequestParam String unlockDate,
                                                    @RequestParam(defaultValue = "") String description,
                                                    @RequestParam(defaultValue = "333") Integer userId){
        System.out.println("creating new capsule: " + capsuleName);
        Capsule capsule = capsuleService.createNewCapsule(capsuleName, unlockDate, description, userId);
        System.out.println("capsule: "  + capsule);
        return new ResponseEntity<>(capsule, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Capsule>> getAllCapsules(){
        List<Capsule> list = capsuleService.findAllCapsules();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Capsule>> getAllByUserId(@PathVariable Integer userId){
        List<Capsule> capsuleList = capsuleService.findCapsulesByUserId(userId);
        return new ResponseEntity<>(capsuleList, HttpStatus.OK);

    }

    @GetMapping("/capsuleId")
    public ResponseEntity<Capsule> getCapsuleById(@RequestParam Integer id){
        Capsule capsule = capsuleService.findCapsuleById(id);
        return new ResponseEntity<>(capsule, HttpStatus.OK);
    }
}
