package com.christensen.prsapp.services.impl;

import com.christensen.prsapp.controllers.dto.FigureEnum;
import com.christensen.prsapp.controllers.dto.PlayerDTO;
import com.christensen.prsapp.controllers.dto.PlayerMoveDTO;
import com.christensen.prsapp.controllers.dto.ResultDTO;
import com.christensen.prsapp.controllers.dto.ResultEnum;
import com.christensen.prsapp.repositories.entities.Player;
import com.christensen.prsapp.repositories.PlayerRepository;
import com.christensen.prsapp.services.mappers.PlayerMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.FieldSetter;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(MockitoJUnitRunner.class)
@PrepareForTest({GameServiceImpl.ComputerPlayerUnit.class})
public class GameServiceImplTest {

    private static final String PLAYER_NAME = "Mattis";

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private PlayerMapper playerMapper;

    @Mock
    private PlayerRepository playerRepository;

    private GameServiceImpl.ComputerPlayerUnit cpu;

    @Before
    public void setUp() throws NoSuchFieldException {
        cpu = PowerMockito.mock(GameServiceImpl.ComputerPlayerUnit.class);
        FieldSetter.setField(gameService, gameService.getClass().getDeclaredField("computerPlayerUnit"), cpu);
        when(cpu.move()).thenReturn(FigureEnum.PAPER);
    }

    @Test
    public void testMoveDraw() {
        PlayerMoveDTO playerMove = preparePlayerMoveDTO(FigureEnum.PAPER);
        Player player = preparePlayer();
        Player playerWithResult = preparePlayer();
        playerWithResult.setDraws(1);
        PlayerDTO playerDTOWithResult = preparePlayerDTO();
        playerDTOWithResult.setDraws(1);
        when(playerMapper.dtoToPlayer(eq(playerMove.getPlayer()))).thenReturn(player);
        when(playerMapper.playerToDTO(eq(playerWithResult))).thenReturn(playerDTOWithResult);
        when(playerRepository.save(eq(playerWithResult))).thenReturn(playerWithResult);

        final ResultDTO move = gameService.move(playerMove);

        verifyInvocations(playerMove);

        assertThat(move.getResult()).isEqualTo(ResultEnum.DRAW);
        assertThat(move.getPlayer().getWins()).isEqualTo(0);
        assertThat(move.getPlayer().getDraws()).isEqualTo(1);
        assertThat(move.getPlayer().getLosses()).isEqualTo(0);
    }

    @Test
    public void testMoveWin() {
        PlayerMoveDTO playerMove = preparePlayerMoveDTO(FigureEnum.SCISSORS);
        Player player = preparePlayer();
        Player playerWithResult = preparePlayer();
        playerWithResult.setWins(1);
        PlayerDTO playerDTOWithResult = preparePlayerDTO();
        playerDTOWithResult.setWins(1);

        when(playerMapper.dtoToPlayer(eq(playerMove.getPlayer()))).thenReturn(player);
        when(playerMapper.playerToDTO(eq(playerWithResult))).thenReturn(playerDTOWithResult);
        when(playerRepository.save(eq(playerWithResult))).thenReturn(playerWithResult);

        final ResultDTO move = gameService.move(playerMove);

        verifyInvocations(playerMove);

        assertThat(move.getResult()).isEqualTo(ResultEnum.WIN);
        assertThat(move.getPlayer().getWins()).isEqualTo(1);
        assertThat(move.getPlayer().getDraws()).isEqualTo(0);
        assertThat(move.getPlayer().getLosses()).isEqualTo(0);
    }

    @Test
    public void testMoveLoss() {
        PlayerMoveDTO playerMove = preparePlayerMoveDTO(FigureEnum.ROCK);
        Player player = preparePlayer();
        Player playerWithResult = preparePlayer();
        playerWithResult.setLosses(1);
        PlayerDTO playerDTOWithResult = preparePlayerDTO();
        playerDTOWithResult.setLosses(1);

        when(playerMapper.dtoToPlayer(eq(playerMove.getPlayer()))).thenReturn(player);
        when(playerMapper.playerToDTO(eq(playerWithResult))).thenReturn(playerDTOWithResult);
        when(playerRepository.save(eq(playerWithResult))).thenReturn(playerWithResult);

        final ResultDTO move = gameService.move(playerMove);

        verifyInvocations(playerMove);

        assertThat(move.getResult()).isEqualTo(ResultEnum.LOSS);
        assertThat(move.getPlayer().getWins()).isEqualTo(0);
        assertThat(move.getPlayer().getDraws()).isEqualTo(0);
        assertThat(move.getPlayer().getLosses()).isEqualTo(1);
    }

    private void verifyInvocations(PlayerMoveDTO playerMove) {
        verify(cpu, times(1)).move();
        verify(playerMapper, times(1)).dtoToPlayer(eq(playerMove.getPlayer()));
        verify(playerMapper, times(1)).playerToDTO(any(Player.class));
        verify(playerRepository, times(1)).save(any(Player.class));
    }

    private PlayerDTO preparePlayerDTO() {
        final PlayerDTO player = new PlayerDTO();
        player.setName(PLAYER_NAME);
        return player;
    }

    private Player preparePlayer() {
        final Player player = new Player();
        player.setName(PLAYER_NAME);
        return player;
    }

    private PlayerMoveDTO preparePlayerMoveDTO(FigureEnum playerFigure) {
        PlayerMoveDTO playerMove = new PlayerMoveDTO();
        playerMove.setFigure(playerFigure);
        playerMove.setPlayer(preparePlayerDTO());
        return playerMove;
    }

}
