package com.christensen.prsapp.controllers;

import com.christensen.prsapp.controllers.dto.PlayerMoveDTO;
import com.christensen.prsapp.controllers.dto.ResultDTO;
import com.christensen.prsapp.services.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/play")
    ResultDTO play(@RequestBody PlayerMoveDTO playerMoveDTO) {
        return gameService.move(playerMoveDTO);
    }


}
