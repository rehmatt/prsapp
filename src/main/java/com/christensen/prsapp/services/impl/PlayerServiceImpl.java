package com.christensen.prsapp.services.impl;

import com.christensen.prsapp.controllers.dto.PlayerDTO;
import com.christensen.prsapp.repositories.PlayerRepository;
import com.christensen.prsapp.repositories.entities.Player;
import com.christensen.prsapp.services.PlayerService;
import com.christensen.prsapp.services.mappers.PlayerMapper;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public Iterable<PlayerDTO> getPlayers() {
        final Iterable<Player> players = playerRepository.findAll();
        return playerMapper.playersToDTOs(players);
    }

    @Override
    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        Player foundPlayer = playerRepository.findByName(playerDTO.getName());
        if (foundPlayer == null) {
            final Player player = playerMapper.dtoToPlayer(playerDTO);
            final Player savedPlayer = playerRepository.save(player);
            return playerMapper.playerToDTO(savedPlayer);
        } else {
            return playerMapper.playerToDTO(foundPlayer);
        }
    }
}
