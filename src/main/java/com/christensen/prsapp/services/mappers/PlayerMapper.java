package com.christensen.prsapp.services.mappers;

import com.christensen.prsapp.controllers.dto.PlayerDTO;
import com.christensen.prsapp.repositories.entities.Player;
import org.mapstruct.Mapper;

@Mapper
public interface PlayerMapper {

    PlayerDTO playerToDTO(Player player);

    Player dtoToPlayer(PlayerDTO user);

    Iterable<PlayerDTO> playersToDTOs(Iterable<Player> players);
}
