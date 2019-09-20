package com.christensen.prsapp.controllers.dto;

import lombok.Data;

@Data
public class PlayerMoveDTO {

    private FigureEnum figure;
    private PlayerDTO player;
}
