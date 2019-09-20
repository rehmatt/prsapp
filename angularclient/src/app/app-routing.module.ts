import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {GameComponent} from './game/game.component';
import {PlayerFormComponent} from './player-form/player-form.component';
import {PlayerListComponent} from "./player-list/player-list.component";

const routes: Routes = [
  {path: 'play', component: GameComponent},
  {path: 'addplayer', component: PlayerFormComponent},
  {path: 'players', component: PlayerListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
