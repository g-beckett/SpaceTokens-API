package com.spacetokens.spacetokensapp.services;

import com.spacetokens.spacetokensapp.entities.Timeline;
import com.spacetokens.spacetokensapp.entities.User;
import com.spacetokens.spacetokensapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private TimelineService timelineService;
    public User createUser(){
        User newUser = new User();
        Timeline newTimeline = new Timeline();
        newUser.setTimeline(newTimeline);
        return userRepository.save(newUser);
        //timelineService.createNewTimeline(userId);
    }
}
