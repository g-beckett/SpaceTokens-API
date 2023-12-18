package com.spacetokens.spacetokensapp.repositories;

import com.spacetokens.spacetokensapp.entities.Capsule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//sql stuff
@Repository
public interface CapsuleRepository extends JpaRepository<Capsule, Integer> {

    //SELECT * from CAPSULE where capsule.userId = ?
    List<Capsule> findAllByUserId(Integer userId);

}
