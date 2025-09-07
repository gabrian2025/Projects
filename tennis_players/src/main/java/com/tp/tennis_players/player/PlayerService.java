package com.tp.tennis_players.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers()
    {
        return playerRepository.findAll();
    }

    public List<Player> getPlayerByRank(Integer rank)
    {
        return playerRepository.findAll().stream().filter
                (player ->  rank == player.getRank()).collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText)
    {
        return playerRepository.findAll().stream().filter(player -> searchText.toLowerCase().
                contains(player.getName().toLowerCase())).collect(Collectors.toList());
    }

    public List<Player> getPlayerByWinPercentage(Integer winPercentage)
    {
        return playerRepository.findAll().stream().filter(player ->
                        player.getWinPercentage() == winPercentage).collect(Collectors.toList());
    }
    public List<Player> getPlayerByMatchesPlayed(Double matchesPlayed)
    {
        return playerRepository.findAll().stream().filter(player ->
                matchesPlayed == player.getMatchesPlayed()).collect(Collectors.toList());

    }

    public Player addPlayer(Player player)
    {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player player)
    {
        Optional<Player> existingPlayer = playerRepository.findByName(player.getName());
        if(existingPlayer.isPresent())
        {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setRank(player.getRank());
            playerToUpdate.setMatchesPlayed(player.getMatchesPlayed());
            playerToUpdate.setWinPercentage(player.getWinPercentage());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;

    }
    @Transactional
    public void deletePlayer(String playerName)
    {
        Optional<Player> existingPlayer = playerRepository.findByName(playerName);
        if(existingPlayer.isPresent())
        {
            playerRepository.delete(existingPlayer.get());
        }
    }

}
