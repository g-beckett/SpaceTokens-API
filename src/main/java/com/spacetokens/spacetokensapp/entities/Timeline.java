package com.spacetokens.spacetokensapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="Timeline")
@NoArgsConstructor
@AllArgsConstructor
public class Timeline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    @OneToMany(mappedBy = "timeline", cascade=CascadeType.ALL)
    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    private List<Capsule> capsules;

    public Timeline(Integer userId) {
        this.userId = userId;
        this.capsules = new ArrayList<>();
    }

}