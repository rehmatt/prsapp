package com.christensen.prsapp.services.impl;

import com.christensen.prsapp.controllers.dto.FigureEnum;
import com.christensen.prsapp.controllers.dto.PlayerDTO;
import com.christensen.prsapp.controllers.dto.PlayerMoveDTO;
import com.christensen.prsapp.controllers.dto.ResultDTO;
import com.christensen.prsapp.controllers.dto.ResultEnum;
import com.christensen.prsapp.repositories.entities.Player;
import com.christensen.prsapp.repositories.PlayerRepository;
import com.christensen.prsapp.services.GameService;
import com.christensen.prsapp.services.mappers.PlayerMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameServiceImpl implements GameService {

    private final ComputerPlayerUnit computerPlayerUnit = new ComputerPlayerUnit();

    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRepository;

    public GameServiceImpl(PlayerMapper playerMapper, PlayerRepository playerRepository) {
        this.playerMapper = playerMapper;
        this.playerRepository = playerRepository;
    }

    @Override
    public ResultDTO move(PlayerMoveDTO move) {
        final Player player = playerMapper.dtoToPlayer(move.getPlayer());

        FigureEnum playerFigure = move.getFigure();
        FigureEnum cpuFigure = computerPlayerUnit.move();
        ResultEnum result = playerFigure.play(cpuFigure);
        player.setResult(result);
        final Player savedPlayer = playerRepository.save(player);

        final ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(result);
        resultDTO.setCpuFigure(cpuFigure);
        final PlayerDTO playerDTO = playerMapper.playerToDTO(savedPlayer);
        resultDTO.setPlayer(playerDTO);
        return resultDTO;
    }

    final class ComputerPlayerUnit {
        private Random moveGenerator = new Random();

        FigureEnum move() {
            final int cpuMove = moveGenerator.nextInt(3);
            return FigureEnum.values()[cpuMove];
        }
    }

}
