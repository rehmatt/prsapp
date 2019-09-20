import { Component, OnInit } from '@angular/core';
import { Player } from '../model/player';
import { GameService } from '../service/game.service';
import {Result} from "../model/result";
import {Move} from "../model/move";

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent {

  public result: string;

  constructor(public player: Player, private gameService: GameService) {
  }

  play(figure: string) {
    let move = new Move();
    move.figure = figure;
    move.player = this.player;
    this.gameService.play(move).subscribe((data : Result)=> {
      this.player.map(data.player);
      this.setResultText(data);
    });
  }

  private setResultText(data: Result) {
    let cpuFigure: string = data.cpuFigure.toLowerCase();
    switch (data.result) {
      case "WIN":
        this.result = `CPU selected ${cpuFigure}. You've won!`;
        break;
      case "DRAW":
        this.result = `CPU also selected ${cpuFigure}. It's a draw!`;
        break;
      case "LOSS":
        this.result = `CPU selected ${cpuFigure}. You've lost!`;
        break;
    }
  }

  playAgain() {
    this.result = undefined;
  }
}
