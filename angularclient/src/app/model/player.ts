import { Injectable } from "@angular/core";

@Injectable()
export class Player {
    name: string;
    wins: number;
    draws: number;
    losses: number;

    map(player: Player) {
      this.name = player.name;
      this.wins = player.wins;
      this.draws = player.draws;
      this.losses = player.losses;
    }
}
