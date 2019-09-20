package com.christensen.prsapp.controllers.dto;

import lombok.Data;

@Data
public class ResultDTO {

    private FigureEnum cpuFigure;
    private ResultEnum result;
    private PlayerDTO player;
}
