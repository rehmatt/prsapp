import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Player} from './model/player';
import {PlayerService} from './service/player.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

  title: string;
  activePlayer: Player;

  constructor(private player: Player) {
    this.title = 'Paper - Rock - Scissors';
    this.activePlayer = player;
  }

}
