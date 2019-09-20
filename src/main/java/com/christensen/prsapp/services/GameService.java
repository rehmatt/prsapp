package com.christensen.prsapp.services;

import com.christensen.prsapp.controllers.dto.PlayerMoveDTO;
import com.christensen.prsapp.controllers.dto.ResultDTO;

public interface GameService {
    ResultDTO move(PlayerMoveDTO play);
}
