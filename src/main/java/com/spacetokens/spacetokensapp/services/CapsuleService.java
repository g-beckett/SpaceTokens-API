package com.spacetokens.spacetokensapp.services;

import com.spacetokens.spacetokensapp.entities.Capsule;
import com.spacetokens.spacetokensapp.entities.Timeline;
import com.spacetokens.spacetokensapp.repositories.CapsuleRepository;
import com.spacetokens.spacetokensapp.repositories.TimelineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CapsuleService {

    private final CapsuleRepository capsuleRepository;
    private final TimelineRepository timelineRepository;

    public Capsule createNewCapsule(String name, String unlockDate, String description, Integer userId){
        Date date = Date.valueOf(unlockDate);
        Timestamp timestamp = new Timestamp(date.getTime());
        Optional<Timeline> tlOpt = timelineRepository.findByUserId(userId);
        if(tlOpt.isEmpty()){
            throw new RuntimeException("Timeline doesn't exist");
        }
        Timeline timeline = tlOpt.get();
        Capsule newCapsule = new Capsule(name, timestamp, description, timeline, userId);
        newCapsule = capsuleRepository.save(newCapsule);
        return newCapsule;
    }

    public List<Capsule> findAllCapsules(){

        return capsuleRepository.findAll();
    }

    // find all  by user
    public List<Capsule> findCapsulesByUserId(Integer userId){

        return capsuleRepository.findAllByUserId(userId);
    }

    //find capsules by id
    public Capsule findCapsuleById(Integer id){
        Optional<Capsule> capsuleOptional = capsuleRepository.findById(id);
        //if value is found then return it
        if (capsuleOptional.isPresent()){
            return capsuleOptional.get();
        } else {
            //this is where you could throw an exception and then handle it with @ControllerAdvice controller
            //for now we'll just return null
            return null;
        }
    }
}