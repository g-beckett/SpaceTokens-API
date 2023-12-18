package com.spacetokens.spacetokensapp.services;

import com.spacetokens.spacetokensapp.entities.Capsule;
import com.spacetokens.spacetokensapp.entities.Timeline;
import com.spacetokens.spacetokensapp.repositories.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimelineService {

    private final TimelineRepository timelineRepository;

    public boolean createNewTimeline(Integer userId){
        Timeline newTimeline = new Timeline(userId);
        timelineRepository.save(newTimeline);
        return true;
    }

    public Timeline getTimeline(Integer userId){
        Optional<Timeline> tlOpt = timelineRepository.findByUserId(userId);
        if(tlOpt.isPresent()){
            return tlOpt.get();
        }
        throw new RuntimeException("there been an error");
    }
}
