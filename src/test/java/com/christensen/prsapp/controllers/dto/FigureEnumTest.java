package com.christensen.prsapp.controllers.dto;

import com.christensen.prsapp.controllers.dto.FigureEnum;
import com.christensen.prsapp.controllers.dto.ResultEnum;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureEnumTest {

    @Test
    public void testPlayPaper() {
        assertThat(FigureEnum.PAPER.play(FigureEnum.PAPER)).isEqualTo(ResultEnum.DRAW);
        assertThat(FigureEnum.PAPER.play(FigureEnum.ROCK)).isEqualTo(ResultEnum.WIN);
        assertThat(FigureEnum.PAPER.play(FigureEnum.SCISSORS)).isEqualTo(ResultEnum.LOSS);
    }

    @Test
    public void testPlayRock() {
        assertThat(FigureEnum.ROCK.play(FigureEnum.PAPER)).isEqualTo(ResultEnum.LOSS);
        assertThat(FigureEnum.ROCK.play(FigureEnum.ROCK)).isEqualTo(ResultEnum.DRAW);
        assertThat(FigureEnum.ROCK.play(FigureEnum.SCISSORS)).isEqualTo(ResultEnum.WIN);
    }

    @Test
    public void testPlayScissors() {
        assertThat(FigureEnum.SCISSORS.play(FigureEnum.PAPER)).isEqualTo(ResultEnum.WIN);
        assertThat(FigureEnum.SCISSORS.play(FigureEnum.ROCK)).isEqualTo(ResultEnum.LOSS);
        assertThat(FigureEnum.SCISSORS.play(FigureEnum.SCISSORS)).isEqualTo(ResultEnum.DRAW);
    }
}
