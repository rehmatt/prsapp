package com.christensen.prsapp.repositories.entities;

import com.christensen.prsapp.controllers.dto.ResultEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Player {

    @Id
    private String name;
    private int wins;
    private int draws;
    private int losses;

    public void setResult(ResultEnum result) {
        switch (result) {
            case WIN:
                wins += 1;
                break;
            case DRAW:
                draws += 1;
                break;
            case LOSS:
                losses += 1;
                break;
        }
    }

    @Override
    public String toString() {
        return "User{" + " name=" + name + ", wins=" + wins + ", draws=" + draws + ", losses=" + losses + '}';
    }
}
