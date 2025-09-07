package com.tp.tennis_players.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer rank,
        @RequestParam(required = false) Integer winPercentage,
        @RequestParam(required = false) Double matchesPlayed)
    {
        if( name != null) {
            return playerService.getPlayersByName(name);

        }
        else if(rank != null) {
            return playerService.getPlayerByRank(rank);

        }
        else if(winPercentage != null) {
            return playerService.getPlayerByWinPercentage(winPercentage);
        }
        else if(matchesPlayed != null) {
            return playerService.getPlayerByMatchesPlayed(matchesPlayed);
        }
        else {
            return playerService.getPlayers();
        }
    }
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
        Player updatedPlayer = playerService.updatePlayer(player);

        if(updatedPlayer!= null)
        {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
