package com.spacetokens.spacetokensapp.controllers;

import com.spacetokens.spacetokensapp.entities.Capsule;
import com.spacetokens.spacetokensapp.entities.Timeline;
import com.spacetokens.spacetokensapp.services.CapsuleService;
import com.spacetokens.spacetokensapp.services.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/timeline")
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

//    @PostMapping("/new")
//    public ResponseEntity<?> createNewTimeline(@RequestParam Integer userId){
//        timelineService.createNewTimeline(userId);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

    @GetMapping("/getTimeline")
    public ResponseEntity<Timeline> getUserTimeline(@RequestParam Integer userId){
        Timeline timeline = timelineService.getTimeline(userId);
        System.out.println(timeline);
        return ResponseEntity.ok().body(timeline);
        // return new ResponseEntity<>(list, HttpStatus.OK);
    }
  }
