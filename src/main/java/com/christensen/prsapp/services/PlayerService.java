package com.christensen.prsapp.services;

import com.christensen.prsapp.controllers.dto.PlayerDTO;

public interface PlayerService {

    Iterable<PlayerDTO> getPlayers();

    PlayerDTO addPlayer(PlayerDTO player);
}
