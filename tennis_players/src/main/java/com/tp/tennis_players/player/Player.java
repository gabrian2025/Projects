package com.tp.tennis_players.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_statistic")
public class Player {
    @Id
    @Column(name="player_name" , unique=true)
    private String name;
    private Integer rank;
    private Integer winPercentage;
    private Double matchesPlayed;

    public Player()
    {
        
    }

}
