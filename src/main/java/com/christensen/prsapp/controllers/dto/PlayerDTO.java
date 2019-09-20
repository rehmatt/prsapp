package com.christensen.prsapp.controllers.dto;

import lombok.Data;

@Data
public class PlayerDTO {

    private String name;
    private int wins;
    private int draws;
    private int losses;
}
