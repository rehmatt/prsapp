package com.christensen.prsapp.controllers.dto;

public enum FigureEnum {

    PAPER {
        @Override
        public ResultEnum play(FigureEnum cpuFigure) {
            switch (cpuFigure) {
                case PAPER:
                    return ResultEnum.DRAW;
                case ROCK:
                    return ResultEnum.WIN;
                case SCISSORS:
                    return ResultEnum.LOSS;
                default:
                    return ResultEnum.DRAW;
            }
        }
    },
    ROCK {
        @Override
        public ResultEnum play(FigureEnum cpuFigure) {
            switch (cpuFigure) {
                case PAPER:
                    return ResultEnum.LOSS;
                case ROCK:
                    return ResultEnum.DRAW;
                case SCISSORS:
                    return ResultEnum.WIN;
                default:
                    return ResultEnum.DRAW;
            }
        }
    },
    SCISSORS {
        @Override
        public ResultEnum play(FigureEnum cpuFigure) {
            switch (cpuFigure) {
                case PAPER:
                    return ResultEnum.WIN;
                case ROCK:
                    return ResultEnum.LOSS;
                case SCISSORS:
                    return ResultEnum.DRAW;
                default:
                    return ResultEnum.DRAW;
            }
        }
    };

    public ResultEnum play(FigureEnum cpuFigure) {
        return ResultEnum.DRAW;
    }
}
