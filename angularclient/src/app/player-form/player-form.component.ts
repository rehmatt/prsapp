import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {PlayerService} from '../service/player.service';
import {Player} from '../model/player';

@Component({
  selector: 'app-player-form',
  templateUrl: './player-form.component.html',
  styleUrls: ['./player-form.component.css']
})
export class PlayerFormComponent {

  playerName: string;

  constructor(private player: Player, private route: ActivatedRoute, private router: Router, private playerService: PlayerService) {
    console.log(this.player)
  }

  onSubmit() {
    this.player.name = this.playerName;
    this.playerService.save(this.player).subscribe(result => {
      this.player.map(result);
      this.router.navigate(['/players']);
    });
  }

}
