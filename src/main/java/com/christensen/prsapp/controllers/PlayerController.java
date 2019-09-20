package com.christensen.prsapp.controllers;

import com.christensen.prsapp.controllers.dto.PlayerDTO;
import com.christensen.prsapp.services.PlayerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public Iterable<PlayerDTO> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/players")
    public PlayerDTO addPlayer(@RequestBody PlayerDTO player) {
        return playerService.addPlayer(player);
    }


}
