package com.tp.tennis_players.player;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="player_stats")
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

    public Player(String name, Integer rank, Integer winPercentage, Double matchesPlayed)
    {
        this.name = name;
        this.rank = rank;
        this.winPercentage = winPercentage;
        this.matchesPlayed = matchesPlayed;
    }

    public String getName() {

        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getRank() {

        return rank;
    }
    public void setRank(Integer rank) {

        this.rank = rank;
    }
    public Integer getWinPercentage() {

        return winPercentage;
    }
    public void setWinPercentage(Integer winPercentage) {

        this.winPercentage = winPercentage;
    }
    public Double getMatchesPlayed() {

        return matchesPlayed;
    }
    public void setMatchesPlayed(Double matchesPlayed) {

        this.matchesPlayed = matchesPlayed;
    }

}
