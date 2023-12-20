package com.spacetokens.spacetokensapp.repositories;

import com.spacetokens.spacetokensapp.entities.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Integer> {

    Optional<Timeline> findByUserId(Integer id);

}
