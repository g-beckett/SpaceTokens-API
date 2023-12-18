package com.spacetokens.spacetokensapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Capsule")
@NoArgsConstructor
@AllArgsConstructor
public class Capsule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String capsuleName;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "timeline_id", referencedColumnName = "id")
    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Timeline timeline;
    private Timestamp startDate;
    private Timestamp unlockDate;
    private String description;
    private Integer userId;

    // will have an id, name of capsule, start date
    public Capsule (String capsuleName, Timestamp unlockDate, String description, Timeline timeline) {

        this.capsuleName = capsuleName;
        this.startDate = Timestamp.valueOf(LocalDateTime.now());
        this.unlockDate = unlockDate;
        this.description = description;
        this.userId = 333;
        this.timeline = timeline;
    }
}